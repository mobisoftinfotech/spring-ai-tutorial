# Spring Boot + Spring AI Example

This project demonstrates how to integrate **Spring AI** into a Spring Boot application to interact with **OpenAI** and **Google Gemini** using a clean abstraction. It highlights environment-based switching, minimal configuration, and zero vendor lock-in — all built with familiar Spring idioms.

## Project Overview

This is a single Spring Boot app exposing a REST API endpoint that dynamically interacts with different LLM providers depending on the **active profile**:

- Spring Boot `3.5.0`
- Java `17`
- Spring AI (SNAPSHOT)
- OpenAI / Gemini (Vertex AI) support
- Minimal configuration, no boilerplate REST clients

## Prerequisites

- Java 17 or higher  
- Maven  
- OpenAI API Key and/or Google Cloud credentials  

## Project Structure
```
spring-ai-poc/
├── src/
│   └── main/
│       ├── java/                    
│       │   └── com/mobisoftinfotech/...   
│       └── resources/
│           └── application.properties      
├── pom.xml                          
└── README.md                        
```

## Dependencies

Key dependencies and configurations used:

- `spring-boot-starter-web`: REST API support  
- `spring-ai-starter-model-openai`: OpenAI integration  
- `spring-ai-starter-model-vertex-ai-gemini`: Gemini integration  
- `spring-ai-bom`: To ensure all springai dependencies stay aligned and compatible
- `spring-snapshots` repository : To resolve springai latest versions
## Setup & Configuration

### Profiles

This app supports two Spring profiles, defined in `pom.xml` :

- `openai`: Uses OpenAI models  
- `gemini`: Uses Google Gemini (via Vertex AI)

### application.properties file
#### For OpenAI
```
spring.ai.openai.api-key=YOUR_OPENAI_KEY
```

#### For Gemini
```
spring.ai.vertex.ai.gemini.project-id=YOUR_PROJECT_ID
spring.ai.vertex.ai.gemini.api-endpoint=us-central1-aiplatform.googleapis.com
spring.ai.vertex.ai.gemini.location=us-central1
```
### Google Cloud Setup
For Gemini usage:

- Create a project on Google Cloud
- Enable Vertex AI API
- Create a Service Account and download the JSON for credentials
- Set environment variable:
```bash
export GOOGLE_APPLICATION_CREDENTIALS=/path/to/your/credentials.json
```

To run the application, use:

```bash
mvn spring-boot:run
```

## Endpoint
You can call the AI prompt endpoint using:
```
curl -X POST http://localhost:8080/ai \
  -H "Content-Type: application/json" \
  -d '{
    "prompt": "What day is today?",            
    "model": "gemini" 
}'
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.
