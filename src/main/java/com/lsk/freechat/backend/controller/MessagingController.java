package com.lsk.freechat.backend.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * MessagingController
 * Implement APIs about messaging
 * 1. send message (client send to server via WS)
 * REQ: <MESSAGE STRUCTURE>
 * 2. receive message (send to client via WS)
 * {
 *     <MESSAGE STRUCTURE>
 * }
 * Client needn't give a response.
 * 3. request undo message (client send to server via WS)
 * REQ:
 * {
 *     "message_id": <MESSAGE ID>
 * }
 * 4. undo message broadcast (server send to client via WS)
 * {
 *     "message_id": <MESSAGE ID>
 * }
 * Client needn't give a response.
 * 5. upload a file (plain request)
 * REQ: Multipart Request, File in part "file".
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "file_id": <File ID>
 *     }
 * }
 * 6. download a file (plain request)
 * REQ:
 * {
 *     "file_id": <FILE ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (File Not Found),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * File is sent to the client as an attachment.
 * 7. upload an image (plain request)
 * REQ: Multipart Request, image in part "file".
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "image_id": <Image ID>,
 *         "keep_forever": true | false
 *     }
 * }
 * 8. download an image (plain request)
 * REQ:
 * {
 *     "image_id": <IMAGE_ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (File Not Found),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "image": <Image content, Base64 encoded>
 *     }
 * }
 * 9. get messages in chat or group (plain request)
 * REQ:
 * {
 *     "type": "GROUP | CHAT",
 *     "id": <ID OF GROUP OR CHAT>,
 *     "page": <PAGE>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 400 (Invalid Target Type) | 403 (Not Login) | 404 (Target Not Found) | 407 (User Have No Permission To Perform This Request) | 406 (Page Too Big) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "messages": [<MESSAGE 1>, <MESSAGE 2>, ...],
 *         "page" <CURRENT PAGE>,
 *         "total_pages": <TOTAL PAGES>
 *     }
 * }
 * 10. send friend request (client to server via ws)
 * REQ:
 * {
 *     "dest_uid": <DEST UID>
 * }
 * RESP: NONE
 * After this request, server saves the request to Redis, waiting for the dest user to confirm the request.
 * If the dest user is NOT online, server sends the request to the client as soon as it gets online.
 * The request expires in 1 day (86400 secs)
 * 11. receive friend request (from server to client via ws)
 * {
 *     "from_uid": <FROM UID>
 * }
 * 12. add chat (server send to client via ws)
 * {
 *     "chat_id": <CHAT ID>
 * }
 * 13. add group (server send to client via ws)
 * {
 *     "group_id" <GROUP ID>
 * }
 */
@RestController("/api/message")
public class MessagingController {

}
