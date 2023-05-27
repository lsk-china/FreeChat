package com.lsk.freechat.backend.controller;

/**
 * Group APIs
 * 1. create group
 * REQ:
 * {
 *     "name": <GROUP NAME>,
 *     "members": [<MEMBER UID 1>, <MEMBER UID 2>, <MEMBER UID 3>, [MEMBER UID 4], ...]
 *     "avatar": [AVATAR ID]
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 400 (Too Few Users) | 403 (Not Login) | 404 (User Not Found) | 406 (Resource Not Found) | 407 (User Have No Permission To Perform This Request),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "group_id": <GROUP ID>
 *     }
 * }
 * If user doesn't provide an Avatar ID, server should assign a default one.
 * 2. grant admin
 * REQ:
 * {
 *     "user_id": <USER ID>,
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found) | 407 (User Have No Permission To Perform This Request),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 3. revoke admin
 * REQ:
 * {
 *     "user_id": <USER ID>,
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found) | 405 (User Is Not An Admin) | 407 (User Have No Permission To Perform This Request),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 4. invite people
 * REQ:
 * {
 *     "user_id": <USER ID>,
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 5. apply join
 * REQ:
 * {
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found) ,
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 6. leave group
 * REQ:
 * {
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found) | 405 (Not In This Group),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 7. change group information
 * REQ:
 * {
 *     "group_id": <GROUP ID>,
 *     "name": [NAME],
 *     "avatar": [AVATAR]
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 407 (User Have No Permission To Perform This Request) | 403 (Not Login) | 404 (User Or Group Not Found) | 406 (Image Not Found),
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 8. get group information
 * REQ:
 * {
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 403 (Not Login) | 404 (User Or Group Not Found),
 *     "message": Message in the brackets above,
 *     "data": {
 *         "group": <GROUP STRUCTURE>,
 *         "members": [<MEMBER UID 1>, <MEMBER UID 2>, ...]
 *     }
 * }
 * 9. delete group
 * REQ:
 * {
 *     "group_id": <GROUP ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 407 (User Have No Permission To Perform This Request) | 403 (Not Login) | 404 (User Or Group Not Found) ,
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 * 10. kick user
 * REQ:
 * {
 *     "user_id": <USER ID>
 * }
 * RESP:
 * {
 *     "code": 200 (Succeed) | 407 (User Have No Permission To Perform This Request) | 403 (Not Login) | 404 (User Or Group Not Found) ,
 *     "message": Message in the brackets above,
 *     "data": {}
 * }
 */
public class GroupController {
}
