package com.lsk.freechat.backend.ws;

import com.lsk.freechat.backend.ws.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * WsController
 * Handles Websocket Requests
 */
@Controller()
public class WsController {

    /**
     * clientSend
     * Description:
     * send message (client send to server via WS)
     * REQ: <MESSAGE STRUCTURE>
     * @param message Message Structure
     */
    @MessageMapping("/client_send")
    public void clientSend(Message message) {
    }


}
