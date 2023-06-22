package org.example.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileReaderService {
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec03");

    private static Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (bufferedReader, sink) -> {
            try {
                String line = bufferedReader.readLine();
                System.out.println("reading --- " + line);
                if (Objects.isNull(line))
                    sink.complete();
                else
                    sink.next(line);
            } catch (IOException e) {
                sink.error(e);
            }
            return bufferedReader;
        };
    }

    private static Consumer<BufferedReader> closeReader() {
        return bufferedReader -> {
            try {
                bufferedReader.close();
                System.out.println("--closed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Flux<String> read(String fileName) {
        return Flux.generate(
                openReader(PATH.resolve(fileName)),
                read(),
                closeReader()
        );
    }

    // Thang lam - fail - no work
    public static Flux<String> readFile(String fileName) {

        return Flux.create(fluxSink -> {
            try (Stream<String> lines = Files.lines(PATH.resolve(fileName))) {
                while (true) {
                    fluxSink.next(lines.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    });
}
}
