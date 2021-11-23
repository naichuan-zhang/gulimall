package io.renren.modules.app.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@ConfigurationProperties(prefix = "renren.jwt")
@Component
public class JwtUtils {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String secret;
    private long expire;
    private String header;

    /**
     * 生成jwt token
     * @param userId
     * @return
     */
    public String generateToken(long userId) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(userId + "")
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.debug("Failed when executing getClaimsByToken", e);
            return null;
        }
    }

    public boolean isExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
