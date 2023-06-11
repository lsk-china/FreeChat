package com.lsk.freechat.backend.helper;

import ch.qos.logback.core.status.Status;
import com.google.gson.Gson;
import com.lsk.freechat.backend.model.Message;
import com.lsk.freechat.backend.model.User;
import com.lsk.freechat.backend.response.StatusCode;
import org.apache.tomcat.util.threads.StopPooledThreadException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

import static com.lsk.freechat.backend.util.UUIDUtil.uuid;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * RedisHelper
 * Contains some useful Redis operations
 */
@Component
public class RedisHelper {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * The Gson serializer
     */
    private static final Gson gson = new Gson();

    /**
     * Save a temporary user structure to Redis, used for registration
     * Expires in 86400 secs (a day)
     * @param user the user structure
     * @return the ID of the temporary user, UUID
     */
    public String saveTempUserStructure(User user) {
        String tempUUID = uuid();
        String userJson = gson.toJson(user);
        String key = "TEMP-USER-" + tempUUID;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            // Use Boolean.FALSE.equals to prevent NPE when unboxing a null value
            if (Boolean.FALSE.equals(conn.set(key.getBytes(UTF_8),
                    userJson.getBytes(UTF_8),
                    Expiration.seconds(86400),
                    RedisStringCommands.SetOption.SET_IF_ABSENT))) { // I have to set this option because there is no conn.set(byte[], byte[], Expiration)
                // Throw a server error when failing to perform the set operation
                throw new StatusCode(500, "Failed to save temporary user structure to Redis");
            }
        }
        return tempUUID;
    }

    /**
     * Query a temporary user structure from Redis
     * @param tempId temporary User id
     * @return the user structure, null for not exist
     */
    public User getTempUserStructure(String tempId) {
        String key = "TEMP-USER-" + tempId;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            if (Boolean.FALSE.equals(conn.exists(key.getBytes(UTF_8)))) { // If the user doesn't exist, return null. We don't need to throw error here because this method returns something
                return null;
            }
            String json = new String(Objects.requireNonNull(conn.get(key.getBytes(UTF_8))));
            return gson.fromJson(json, User.class);
        }
    }

    /**
     * Delete a temporary user structure in Redis
     * @param tempId the temporary user id
     */
    public void deleteTempUserStructure(String tempId) {
        String key = "TEMP-USER-" + tempId;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            if (Boolean.FALSE.equals(conn.exists(key.getBytes(UTF_8)))) { // If the user doesn't exist, throw a server error.
                throw new StatusCode(500, "User structure not exist");
            }
            conn.del(key.getBytes(UTF_8));
        }
    }

    /**
     * Save user information to Redis for a token
     * @param token the token of the session
     */
    public void saveUserInfoForToken(String token, User user) {
        String key = "USER-INFO-" + token;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            if (Boolean.FALSE.equals(conn.set(
                    key.getBytes(UTF_8),
                    gson.toJson(user).getBytes(UTF_8)
            ))) { // throw a server error when failing to save
                throw new StatusCode(500, "Cannot save user information for token: " + token);
            }
        }
    }

    /**
     * Check if user information exists in Redis
     * @param token the token of the session
     * @return true if the token exists
     */
    public boolean isUserInfoExists(String token) {
        String key = "USER-INFO-" + token;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            return Boolean.TRUE.equals(conn.exists(key.getBytes(UTF_8)));
        }
    }

    /**
     * Save message structure to Redis
     * @param message the message to save
     */
    public void saveMessageToRedis(Message message) {
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            conn.sAdd("messageCache".getBytes(UTF_8), gson.toJson(message).getBytes(UTF_8));
        }
    }

    /**
     * Query user information from Redis
     * @param token token of the session
     * @return the user structure
     */
    public User getUserInformation(String token) {
        String key = "USER-INFO-" + token;
        try (RedisConnection conn = redisConnectionFactory.getConnection()) {
            if (Boolean.FALSE.equals(conn.exists(key.getBytes(UTF_8)))) { // If the user doesn't exist, return null. We don't need to throw error here because this method returns something
                return null;
            }
            String json = new String(Objects.requireNonNull(conn.get(("USER-INFO-" + token).getBytes())), UTF_8);
            return gson.fromJson(json, User.class);
        }
    }
}
