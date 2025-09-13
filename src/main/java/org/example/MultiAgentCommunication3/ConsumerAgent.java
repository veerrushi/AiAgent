package org.example.MultiAgentCommunication3;

public class ConsumerAgent {

    private String name;

    public ConsumerAgent(String name) {
        this.name = name;
    }

    /**
     * The agent's perception and action for a received message.
     * @param message The message received from another agent.
     */
    public void receive(Message message) {
        // Perceive: A message has arrived.
        System.out.println(this.name + ": Message received! -> " + message.getContent());

        // Act: Process the message. In this case, we just print it.
        // Complex logic would go here to handle the message's content.
        System.out.println(this.name + ": Message processed successfully.");
    }

    public static void main(String[] args) {
        // Create our agents.
        ConsumerAgent consumer = new ConsumerAgent("ConsumerAgent");
        ProducerAgent producer = new ProducerAgent(consumer);

        // The main loop for our simple multi-agent system.
        // The producer will send a message to the consumer every few seconds.
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Loop " + (i + 1) + " ---");
            producer.produceAndSend();
            try {
                // Wait for a bit to simulate a real-world delay.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n--- Communication complete. ---");
    }
}
