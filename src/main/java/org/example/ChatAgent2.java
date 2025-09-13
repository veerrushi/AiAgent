package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A more advanced Java Agent that has memory.
 * It remembers the last few interactions and can provide context-aware responses.
 * This class introduces the concept of an agent's internal 'state'.
 */
public class ChatAgent2 {

    private static final int MEMORY_SIZE = 5; // The number of previous messages to remember.
    private List<String> memory; // The agent's internal state (memory).

    public ChatAgent2() {
        this.memory = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("Hello! I am a Chat Agent with a memory of " + MEMORY_SIZE + " messages. Type 'exit' to quit.");

        // Create an instance of our agent.
        ChatAgent2 agent = new ChatAgent2();

        // The core agent loop.
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("You: ");
                String input = scanner.nextLine(); // Perceive: Get user input.

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Chat Agent: Goodbye!");
                    break; // Act: Terminate the agent.
                }

                // Add the new input to memory, ensuring we don't exceed the memory size.
                agent.addMessageToMemory(input);

                // Act: Respond based on the current state (memory).
                agent.respond(input);
            }
        }
    }

    /**
     * Adds a message to the agent's memory.
     * If the memory is full, the oldest message is removed.
     * @param message The message to add.
     */
    private void addMessageToMemory(String message) {
        this.memory.add(message);
        if (this.memory.size() > MEMORY_SIZE) {
            this.memory.remove(0); // Remove the oldest message
        }
    }

    /**
     * The agent's thinking and acting process.
     * @param currentInput The current message from the user.
     */
    private void respond(String currentInput) {
        if (currentInput.trim().isEmpty()) {
            System.out.println("Chat Agent: I didn't catch that. Please try again.");
            return;
        }

        // Simple logic based on memory.
        if (currentInput.toLowerCase().contains("hello") || currentInput.toLowerCase().contains("hi")) {
            System.out.println("Chat Agent: Hello to you too! How can I help?");
        } else if (memory.size() > 1 && memory.get(memory.size() - 2).toLowerCase().contains("what is")) {
            System.out.println("Chat Agent: I'm sorry, I can't answer complex questions yet.");
        } else {
            System.out.println("Chat Agent: " + currentInput);
        }
    }
}

