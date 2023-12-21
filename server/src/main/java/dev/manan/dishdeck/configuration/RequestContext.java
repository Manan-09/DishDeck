package dev.manan.dishdeck.configuration;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import static dev.manan.dishdeck.util.Constant.USER_ID;

public class RequestContext {

    public static void setCurrentUserId(String userId) {
        RequestContextHolder.currentRequestAttributes().setAttribute(USER_ID, userId, RequestAttributes.SCOPE_REQUEST);
    }

    public static String getCurrentUserId() {
        return (String) RequestContextHolder.currentRequestAttributes().getAttribute(USER_ID, RequestAttributes.SCOPE_REQUEST);
    }
}