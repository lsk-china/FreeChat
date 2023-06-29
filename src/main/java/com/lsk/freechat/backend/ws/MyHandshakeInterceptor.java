package com.lsk.freechat.backend.ws;

import com.lsk.freechat.backend.helper.RedisHelper;
import com.lsk.freechat.backend.helper.WsHelper;
import com.lsk.freechat.backend.model.User;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpCookie;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * MyHandshakeInterceptor
 * Intercepts the websocket handshakes so that we can know who the client is
 */
@Component
public class MyHandshakeInterceptor implements HandshakeInterceptor {

    @Resource
    private RedisHelper redisHelper;

    /**
     * Write error message to client
     * @param message the message to write
     * @param resp ServerHttpResponse instance
     * @throws Exception the IOException that may happen when writing the message
     */
    private void writeErrorMessage(String message, ServerHttpResponse resp) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getBody()));
        writer.write(message);
        resp.flush();
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 1. Get the token
        String cookieString = Objects.requireNonNull(request.getHeaders().get(HttpHeaders.COOKIE)).toString();
        List<HttpCookie> cookies = HttpCookie.parse(cookieString); // Parse the content of Cookie to a list of HttpCookie instances
        String token = "";
        for (HttpCookie cookie : cookies) {
            if (cookie.getName().equals("token")) { // find the token cookie
                token = cookie.getValue();
            }
        }
        if (token.equals("")) { // No token? Then refuse the handshake
            writeErrorMessage("No token", response);
            return false;
        }

        // 2. get the user information
        User user = redisHelper.getUserInformation(token);
        if (user == null) {
            writeErrorMessage("Not login", response);
            return false;
        }

        // 3. save the principal and token relationship
        Principal principal = request.getPrincipal();
        Long uid = user.getId();
        WsHelper.addClient(uid, principal);
        return true;

    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // seems that we don't need to handle this...
    }
}
