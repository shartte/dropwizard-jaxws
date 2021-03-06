package com.roskart.dropwizard.jaxws.example.auth;

import com.google.common.base.Optional;
import com.roskart.dropwizard.jaxws.example.core.User;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

/**
 * BasicAuthenticator is copied from dropwizard-example.
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("secret".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername()));
        }
        throw new AuthenticationException("Invalid credentials");
    }
}
