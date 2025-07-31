package com.mobisoftinfotech.springai.dto;

public class AIRequest {
	
	private String prompt;
	private String model;

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
