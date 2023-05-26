package com.lsk.freechat.backend.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * MessagingController
 * Implement APIs about messaging
 * 1. send message (client send to server via WS)
 * REQ:
 * {
 *     "message": <MESSAGE STRUCTURE>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 400 (Invalid Message Structure) | 403 (Not Login) | 404 (Target Not Found) | 405 (At User Not Found) | 406 (Resource Not Found) | 407 (User Have No Permission To Perform This Request) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 2. receive message (send to client via WS)
 * {
 *     "message": <MESSAGE STRUCTURE>
 * }
 * Client needn't give a response.
 * 3. request undo message (client send to server via WS)
 * REQ:
 * {
 *     "message_id": <MESSAGE ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (Message Not Found) | 407 (User Have No Permission To Perform This Request),
 *     "message": Message in the brackets above,
 *     "data": {}
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
 */
@RestController("/api/message")
public class MessagingController {

}
