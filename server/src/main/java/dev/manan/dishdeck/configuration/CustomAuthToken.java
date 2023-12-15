package dev.manan.dishdeck.configuration;


import dev.manan.dishdeck.data.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthToken extends UsernamePasswordAuthenticationToken {

    private final String userId;

    public CustomAuthToken(User principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String userId) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}