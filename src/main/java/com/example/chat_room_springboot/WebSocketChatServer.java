package com.example.chat_room_springboot;

import org.springframework.stereotype.Component;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {

    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String message) {
        onlineSessions.values().forEach(session -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @OnOpen
    public void onOpen(Session session) {
        // Add the session to the list of online sessions
        onlineSessions.put(session.getId(), session);
    }

    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        // You can process the received message here
        // For now, let's just broadcast it to all connected clients

        // Get the username from the session (set it when the user logs in)
        String username = (String) session.getUserProperties().get("username");

        // Create a message object and send it to all clients
        Message message = new Message(username, jsonStr);
        sendMessageToAll(message.toString());
    }

    @OnClose
    public void onClose(Session session) {
        // Remove the session from the list of online sessions
        onlineSessions.remove(session.getId());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
