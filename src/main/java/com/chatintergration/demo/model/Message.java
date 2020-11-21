package com.chatintergration.demo.model;

import javax.persistence.Id;

public class Message {

    @Id
    private long messageId;

    private String messageContent;

    public Message(long messageId, String messageContent) {

        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
