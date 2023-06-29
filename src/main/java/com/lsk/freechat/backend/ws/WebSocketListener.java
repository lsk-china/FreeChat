package com.lsk.freechat.backend.ws;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * WebSocketListener
 * Handles websocket events
 */
@Component
public class WebSocketListener {

    @EventListener
    public void handleClientDisconnectEvent(SessionDisconnectEvent event) {

    }
}
