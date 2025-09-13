package org.example.MultiAgentCommunication3;

public class Message {

    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
