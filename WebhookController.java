
package com.chatbot.medicalbot;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public Map<String, Object> dialogflowWebhook(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        // Extract intent name
        Map<String, Object> queryResult = (Map<String, Object>) request.get("queryResult");
        String intentName = (String) ((Map<String, Object>) queryResult.get("intent")).get("displayName");

        String fulfillmentText = "";

        switch (intentName) {
            case "symptom_info":
                fulfillmentText = "Symptoms like fever and headache may indicate viral infections. Please consult a doctor.";
                break;
            case "drug_advice":
                fulfillmentText = "Avoid self-medication. Consult a pharmacist or doctor for the right drugs.";
                break;
            case "first_aid":
                fulfillmentText = "For minor cuts, clean the wound and apply antiseptic. Seek medical help if severe.";
                break;
            case "emergency_contact":
                fulfillmentText = "Dial 108 for emergency ambulance services in India.";
                break;
            case "greetings":
                fulfillmentText = "Hi! How can I help you with your health today?";
                break;
            default:
                fulfillmentText = "I'm sorry, I couldn't understand. Please try again.";
        }

        Map<String, Object> fulfillment = new HashMap<>();
        fulfillment.put("fulfillmentText", fulfillmentText);

        return fulfillment;
    }
}

