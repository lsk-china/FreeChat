package com.lsk.freechat.backend.helper;

import ch.qos.logback.core.status.Status;
import com.google.gson.Gson;
import com.lsk.freechat.backend.model.User;
import com.lsk.freechat.backend.response.StatusCode;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.nio.charset.StandardCharsets;

import static com.lsk.freechat.backend.util.UUIDUtil.uuid;

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
            if (Boolean.FALSE.equals(conn.set(key.getBytes(StandardCharsets.UTF_8),
                    userJson.getBytes(StandardCharsets.UTF_8),
                    Expiration.seconds(86400),
                    RedisStringCommands.SetOption.SET_IF_ABSENT))) { // I have to set this option because there is no conn.set(byte[], byte[], Expiration)
                // Throw a server error when failing to perform the set operation
                throw new StatusCode(500, "Failed to save temporary user structure to Redis");
            }
        }
        return tempUUID;
    }

}
