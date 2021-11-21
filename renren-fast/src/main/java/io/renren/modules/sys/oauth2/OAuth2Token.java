package io.renren.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
