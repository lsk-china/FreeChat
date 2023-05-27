package com.lsk.freechat.backend.response;

/**
 * StatusCode
 * Throw this exception to terminate the logic process and tell PostProcessAspect to response an error message to the client
 */
public class StatusCode extends RuntimeException {

    /**
     * The error code to be returned
     */
    private int code;

    public StatusCode(int code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode(Throwable t) {
        super(t);
        this.code = 500; // When return a server error, set code to 500 (means server error)
    }

    public int getCode() {
        return this.code;
    }
}
