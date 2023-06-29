package com.lsk.freechat.backend.helper;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * WsHelper
 * Holds the connected clients
 */
public class WsHelper {
    private static final Map<Long, Principal> connectedClients = new HashMap<>();

    public static void addClient(Long uid, Principal sessionId) {
        connectedClients.put(uid, sessionId);
    }

    public static Principal getClient(Long uid) {
        return connectedClients.get(uid);
    }

    public static void clientDisconnect(Long uid) {
        connectedClients.remove(uid);
    }
}
