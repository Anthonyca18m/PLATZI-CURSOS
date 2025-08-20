package com.platzi.platzi_play.domain.service;


import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class PlatziPlayAiService {

    OpenAiChatModel model = OpenAiChatModel.builder()
            .apiKey("demo")
            .modelName("gpt-4o-mini")
            .build();

    public String generateGreeting(String text) {
        try {
            return model.chat(text);
        } catch (Throwable e) {
            // Handle exceptions appropriately, e.g., log the error or return a default message
            return "No hay key pipipi";
        }
    }

    public String generateFarewell() {
        return "Thank you for visiting Platzi Play!";
    }

    public String generateHelpMessage() {
        return "How can I assist you today?";
    }

    public String generateErrorMessage() {
        return "An error occurred. Please try again later.";
    }
}
