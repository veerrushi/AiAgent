package org.example.MultiAgentCommunication3;

import java.util.Random;

public class ProducerAgent {
    private static final String[] MESSAGES = {
            "Hello, World!",
            "How are you doing?",
            "The weather is nice today.",
            "I have some new data for you.",
            "Let's get this task done!"
    };

    private final Random random = new Random();
    private ConsumerAgent consumer; // Our link to the other agent.

    public ProducerAgent(ConsumerAgent consumer) {
        this.consumer = consumer;
    }

    /**
     * Generates a random message and sends it to the consumer.
     */
    public void produceAndSend() {
        // "Think": Choose a random message from the array.
        String content = MESSAGES[random.nextInt(MESSAGES.length)];

        // "Act": Create a new message and send it to the consumer.
        Message message = new Message(content);
        System.out.println("ProducerAgent: Sending message -> " + message.getContent());

        // This simulates the communication. In a real system, a message queue or network call would be used here.
        consumer.receive(message);
    }
}
