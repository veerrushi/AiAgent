package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebScrapingAgent6 {

    private final String url;

    public WebScrapingAgent6(String url) {
        this.url = url;
    }

    /**
     * The agent's core loop of perceiving and acting upon a web resource.
     */
    public void run() {
        System.out.println("WebScrapingAgent: My goal is to fetch the content from: " + url);

        // Action: Perform the HTTP request to the web page.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // Perceive: Get the response from the web request.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Process the perception and perform a new action (print the content).
            if (response.statusCode() == 200) {
                System.out.println("WebScrapingAgent: Successfully fetched content. Here is the first 200 characters:");
                String content = response.body();
                System.out.println(content.substring(0, Math.min(content.length(), 200)));
            } else {
                System.err.println("WebScrapingAgent: Failed to fetch URL. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("WebScrapingAgent: An error occurred: " + e.getMessage());
        }

        System.out.println("WebScrapingAgent: My task is complete.");
    }

    public static void main(String[] args) {
        // You can change this URL to any website you want to scrape.
        WebScrapingAgent6 agent = new WebScrapingAgent6("http://example.com");
        agent.run();
    }
}
