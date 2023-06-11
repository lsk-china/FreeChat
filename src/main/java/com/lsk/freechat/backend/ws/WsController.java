package com.lsk.freechat.backend.ws;

import com.lsk.freechat.backend.config.RedisConfiguration;
import com.lsk.freechat.backend.helper.RedisHelper;
import com.lsk.freechat.backend.model.User;
import com.lsk.freechat.backend.ws.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;

import javax.annotation.Resource;

/**
 * WsController
 * Handles Websocket Requests
 */
@Controller
public class WsController {

    @Resource
    private RedisHelper redisHelper;

    /**
     * clientSend
     * Description:
     * send message (client send to server via WS)
     * REQ: <MESSAGE STRUCTURE>
     * @param message Message Structure
     * @param token Token of this session
     */
    @MessageMapping("/client_send")
    public void clientSend(Message message, @CookieValue("token") String token) {
        // 1. Check if the session is logged in, and obtain the sender information.
        if (! redisHelper.isUserInfoExists(token)) {
            // Discard the message if the session is not logged in.
            return;
        }
        User senderUser = redisHelper.getUserInformation(token);
        if (senderUser == null) {
            // this shouldn't happen....
            return;
        }

        // 2. construct message structure from the data send by client

    }


}
