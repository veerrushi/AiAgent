package org.example;

import java.util.Scanner;

public class EchoAgent1 {


    public static void main(String[] args) {
        System.out.println("Hello! I am a simple Echo Agent. Type 'exit' to quit.");

        // The 'Scanner' object represents our agent's perception of the environment (user input).
        Scanner scanner = new Scanner(System.in);

        // The core 'agent loop'. This is where the magic happens.
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine(); // Perceive: Get a line of input.

            // The 'if' statement represents the agent's 'thinking' or decision-making process.
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Echo Agent: Goodbye!");
                break; // Act: Terminate the loop and exit.
            } else if (!input.trim().isEmpty()) {
                // Act: Respond to the user's input.
                System.out.println("Echo Agent: " + input);
            } else {
                // Act: Handle empty input.
                System.out.println("Echo Agent: I didn't catch that. Please try again.");
            }
        }

        // Clean up resources.
        scanner.close();
    }
}
