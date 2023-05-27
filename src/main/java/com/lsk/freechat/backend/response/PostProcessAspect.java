package com.lsk.freechat.backend.response;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * PostProcessAspect
 * Executes when a controller returns a response. It packages the response into correct structure and handle the exceptions.
 */
@Slf4j
@Aspect
@Component
public class PostProcessAspect {

    // Gson serializer
    private static final Gson gson = new Gson();

    @Pointcut("execution(com.lsk.freechat.backend.controller.*.**(..))") // Matches every method of every class in com.lsk.freechat.backend.controller
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            return processResponse(pjp.proceed());
        } catch (Throwable t) {
            if (t instanceof StatusCode) { // if t is an instance of status code, just process it
                return processResponse(t);
            } else { // Otherwise, wrap it into a StatusCode
                return processResponse(new StatusCode(t));
            }
        }
    }

    /**
     * Process a successful response
     * @param response The real response to be put in "data"
     * @return Serialized json string
     */
    public static String processResponse(Object response) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", 200);
        responseMap.put("message", "Succeed");
        responseMap.put("data", response == null ? new Object() : response);
        return gson.toJson(responseMap);
    }

    /**
     * Process a failed response
     * @param code Error code
     * @param message Error message
     * @return Serialized json string
     */
    public static String processResponse(int code, String message) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", code);
        responseMap.put("message", message);
        responseMap.put("data", new Object());
        return gson.toJson(responseMap);
    }

    /**
     * Process a failed response
     * @param statusCode the StatusCode to be parsed
     * @return Serialized json string
     */
    public static String processResponse(StatusCode statusCode) {
        Map<String, Object> responseMap = new HashMap<>();
        if (statusCode.getCode() == 500 && statusCode.getCause() != null) { // When StatusCode wraps an exception
            responseMap.put("code", statusCode.getCode());
            responseMap.put("message", statusCode.getCause().getClass().getCanonicalName() +
                    " : " + statusCode.getCause().getMessage());
        } else {
            responseMap.put("code", statusCode.getCode());
            responseMap.put("message", statusCode.getMessage());
        }
        responseMap.put("data", new Object());
        return gson.toJson(responseMap);
    }
}
