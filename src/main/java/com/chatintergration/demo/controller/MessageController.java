package com.chatintergration.demo.controller;

import com.chatintergration.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public void sendMessageToGoogleChat(@RequestParam String message) {

        messageService.sendMessage(message);
    }

}
