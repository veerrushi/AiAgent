package org.example;

import java.util.Random;

public class GoalOrientedAgent4 {

    private int currentNumber;
    private final int targetNumber;
    private final String name;
    private final Random random;

    public GoalOrientedAgent4(String name, int start, int target) {
        this.name = name;
        this.currentNumber = start;
        this.targetNumber = target;
        this.random = new Random();
    }

    /**
     * The agent's core loop of perception, decision, and action.
     */
    public void run() {
        System.out.println(name + ": My goal is to reach " + targetNumber + ".");

        while (currentNumber != targetNumber) {
            // Perceive: Check the current number and compare it to the target.
            System.out.println(name + ": Current number is " + currentNumber + ".");

            // Decide: Determine the best action to take.
            if (currentNumber < targetNumber) {
                // Action: Add a random number to get closer to the target.
                int delta = random.nextInt(5) + 1; // Add a random number between 1 and 5.
                currentNumber += delta;
                System.out.println(name + ": I'm adding " + delta + " to get closer to the goal.");
            } else {
                // Action: Subtract a random number to get closer to the target.
                int delta = random.nextInt(5) + 1;
                currentNumber -= delta;
                System.out.println(name + ": I'm subtracting " + delta + " to get closer to the goal.");
            }

            // Simulate some delay for a more realistic run.
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Goal achieved!
        System.out.println(name + ": Success! I've reached the target number " + targetNumber + ".");
    }

    public static void main(String[] args) {
        // Create an instance of our goal-oriented agent.
        GoalOrientedAgent4 agent = new GoalOrientedAgent4("Number Agent", 10, 25);
        agent.run();
    }
}
