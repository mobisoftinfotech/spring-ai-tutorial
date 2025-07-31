package com.mobisoftinfotech.springai.dto;

public class AIResponse {
	
    private String model;
    private String response;

    public AIResponse(String model, String response) {
        this.model = model;
        this.response = response;
    }

    public String getModel() {
        return model;
    }

    public String getResponse() {
        return response;
    }
}
