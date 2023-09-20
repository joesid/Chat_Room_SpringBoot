package com.example.chat_room_springboot;

public class Message {
    private String username;
    private String content;

    public Message() {
        // Default constructor
    }

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
    }

    // Getters and setters for username and content

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + "\"," +
                "\"content\":\"" + content + "\"" +
                "}";
    }
}
