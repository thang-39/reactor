package org.example.sec11.assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

@NoArgsConstructor
@Getter
public class SlackMember {

    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    public void receives(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        this.messageConsumer.accept(message);
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }


}
