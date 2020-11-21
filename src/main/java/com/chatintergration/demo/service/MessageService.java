package com.chatintergration.demo.service;


import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class MessageService {

    private String webhookUrl = "webhookurlhere";

    RestTemplate restTemplate = new RestTemplate();

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    /**
     * @param message message we want to send
     *                this method being called send a message to chat specified in the above webhookUrl
     */
    public void sendMessage(String message) {

        try {
            URI uri = new URI(webhookUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject object = new JSONObject();

            object.put("text", message);

            HttpEntity<JSONObject> request = new HttpEntity<>(object, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

            LOGGER.debug("Message was send to the chat");


        } catch (URISyntaxException | RestClientException | JSONException ex) {

            LOGGER.error(ex.getMessage(), ex);
        }

    }

}
