package com.lsk.freechat.backend.service;

public interface UserService {
    /**
     * Create a token for the session
     * @return The generated token
     */
    String token();

    /**
     * Login
     * @param username Login username
     * @param password Password, sha256 encoded
     *
     */
    void login(String username, String password);
}
