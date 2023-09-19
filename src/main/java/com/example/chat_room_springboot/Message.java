package com.example.chat_room_springboot;


public class Message {
    private String username;
    private String msg;
    private MessageType type;

    public enum MessageType {
        SPEAK
    }

    public Message() {

    }

    public Message(String username, String msg, MessageType type) {
        this.username = username;
        this.msg = msg;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void getMsg(String msg){
        this.msg = msg;
    }
    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type){
        this.type = type;
    }
}
