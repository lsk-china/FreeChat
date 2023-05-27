SET NAMES utf8mb4;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `avatar` bigint NOT NULL DEFAULT 0,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `sender_id` bigint NOT NULL,
                            `receiver_id` bigint NOT NULL,
                            `send_time` datetime NOT NULL,
                            `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `is_undone` int NOT NULL DEFAULT 0,
                            `target_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `keep_forever` int NOT NULL DEFAULT 0,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user`  (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `user_id` int NOT NULL,
                               `group_id` int NOT NULL,
                               `user_role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `group_message`;
CREATE TABLE `group_message`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `group_id` bigint NOT NULL,
                                  `message_id` bigint NOT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `avatar` bigint NOT NULL,
                          `owner` bigint NOT NULL,
                          `createTime` datetime NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `user_id` bigint NOT NULL,
                           `friend_id` bigint NOT NULL,
                           `time` datetime NOT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `uploader` bigint NOT NULL,
                         `upload_date` datetime NOT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `chat_message`;
CREATE TABLE `chat_message`  (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `chat_id` bigint NOT NULL,
                                 `message_id` bigint NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
                         `id` bigint NOT NULL,
                         `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `user1` bigint NOT NULL,
                         `user2` bigint NOT NULL,
                         `create_time` datetime NOT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;