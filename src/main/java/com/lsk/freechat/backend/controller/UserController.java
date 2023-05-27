package com.lsk.freechat.backend.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * User APIs
 * 1. acquire token
 * REQ: None
 * RESP:
 * {
 *     "code": 200 (Succeed) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "token": <TOKEN>
 *     }
 * }
 * Client should put the token in its request headers to perform further operations.
 * 2. login
 * REQ:
 * {
 *     "username": <USERNAME>,
 *     "password": <PASSWORD (sha256 encoded)>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Incorrect Password) | 404 (User Not Found) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * Server updates the login state and user information to the Redis after this request.
 * 3. register
 * REQ:
 * {
 *     "username": <USERNAME>,
 *     "password": <PASSWORD (sha256 Encoded)>,
 *     "email": <EMAIL>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 400 (Invalid email) | 402 (User exists) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "uid": <User id of the temp user structure>
 *     }
 * }
 * Server send an email to the user with a registration code. This request creates a temp user structure
 * in Redis.
 * 4. finish register
 * REQ:
 * {
 *     "registration_code": <REGISTRATION CODE>,
 *     "uid": <TEMP UID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Incorrect Code) | 404 (User Not Found) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * After this request, the account is stored to DB and available for further use.
 * 5. update information
 * REQ:
 * Leaving certain fields empty means the user doesn't want to update this field.
 * {
 *     "id": <USER ID>,
 *     "name": [NEW NAME],
 *     "password": [NEW PASSWORD],
 *     "email": [NEW EMAIL],
 *     "avatar": [NEW AVATAR]
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 404 (User Not Found) | 405 (Image Not Found) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * If the password is changed, server should log the user out.
 * 6. query user information
 * REQ:
 * Leave id empty to query self information
 * {
 *     "id": [USER ID]
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Not Found) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "user": <USER STRUCTURE (without password)>
 *     }
 * }
 * 7. query friend list
 * REQ: None
 * RESP: {
 *     "code": 200 (Succeed) | 403 (Not Login) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "friend_ids": [<UID 1>, <UID 2>, ...]
 *     }
 * }
 * 8. admit friend request
 * REQ:
 * {
 *     "from_uid": <FROM UID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 404 (No Such Request) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * A chat with the friend should be created after this request.
 * 9. delete friend
 * REQ:
 * {
 *     "uid": <UID OF THE FRIEND>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 404 (Friend Not Found) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * The chat with the friend should be deleted after this request.
 * 10. query chat list
 * REQ: None
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "chats": [<CHAT ID 1>, <CHAT ID 2>, ...]
 *     }
 * }
 * 11. query group list
 * REQ: None
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 500 (Server Error),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "groups": [<GROUP ID 1>, <GROUP ID 2>, ...]
 *     }
 * }
 */
@RestController
public class UserController {
}
