package com.lsk.freechat.backend.util;

import java.util.UUID;

/**
 * Generate UUID with one simple method
 * (Sometimes marcos are truly convenient.....
 */
public final class UUIDUtil {

    /**
     * Generate UUID with one simple method
     * (Sometimes marcos are truly convenient.....
     * @return the generated UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

}
