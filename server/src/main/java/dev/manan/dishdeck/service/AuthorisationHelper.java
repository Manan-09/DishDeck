package dev.manan.dishdeck.service;

import dev.manan.dishdeck.configuration.RequestContext;
import dev.manan.dishdeck.data.entity.AuditableBean;
import lombok.experimental.UtilityClass;
import org.springframework.security.access.AccessDeniedException;

import static java.util.Objects.nonNull;

@UtilityClass
public class AuthorisationHelper {

    public static void validateOwnership(AuditableBean bean) {
        if( nonNull(bean.getCreatedBy()) && bean.getCreatedBy().equals(RequestContext.getCurrentUserId())) {
            throw new AccessDeniedException("You are not authorised");
        }
    }
}
