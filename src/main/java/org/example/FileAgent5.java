package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAgent5 {

    private final String fileName;
    private final String content;

    public FileAgent5(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    /**
     * The agent's core loop of perception, decision, and action to write to a file.
     */
    public void run() {
        System.out.println("FileAgent: My goal is to write a message to the file: " + fileName);

        // Perceive: Check if the file exists.
        Path filePath = Path.of(fileName);
        if (Files.exists(filePath)) {
            System.out.println("FileAgent: The file already exists. I will append to it.");
        } else {
            System.out.println("FileAgent: The file does not exist. I will create it.");
        }

        // Action: Perform the task of writing the content to the file.
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(content);
            System.out.println("FileAgent: Successfully wrote the message to the file.");
        } catch (IOException e) {
            System.err.println("FileAgent: An error occurred while writing to the file: " + e.getMessage());
        }

        // The task is complete, so the agent's run loop can end.
        System.out.println("FileAgent: My task is complete.");
    }

    public static void main(String[] args) {
        String message = "This is a message written by an AI agent again.";
        FileAgent5 agent = new FileAgent5("agent_log.txt", message);
        agent.run();
    }
}
