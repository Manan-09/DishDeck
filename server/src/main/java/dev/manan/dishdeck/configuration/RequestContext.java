package dev.manan.dishdeck.configuration;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class RequestContext {

    private static final String USER_ID_ATTRIBUTE = "userId";

    public static void setCurrentUserId(String userId) {
        RequestContextHolder.currentRequestAttributes().setAttribute(USER_ID_ATTRIBUTE, userId, RequestAttributes.SCOPE_REQUEST);
    }

    public static String getCurrentUserId() {
        return (String) RequestContextHolder.currentRequestAttributes().getAttribute(USER_ID_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
    }
}