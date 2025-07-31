package com.mobisoftinfotech.springai.controller;

import com.mobisoftinfotech.springai.dto.AIRequest;
import com.mobisoftinfotech.springai.dto.AIResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

	private final Map<String, ChatClient> chatClients;

	public AIController(Map<String, ChatClient> chatClients) {
		this.chatClients = chatClients;
	}

	@PostMapping
	public AIResponse getAIResponse(@RequestBody AIRequest request) {
		String modelKey = request.getModel() != null ? request.getModel().toLowerCase() : "openai";
		ChatClient client = chatClients.get(modelKey);

		if (client == null) {
			return new AIResponse(modelKey, "Unsupported model: " + modelKey);
		}

		String output = client.prompt(request.getPrompt() != null ? request.getPrompt() : "Hello AI!").call().content();

		return new AIResponse(modelKey, output);
	}

}
