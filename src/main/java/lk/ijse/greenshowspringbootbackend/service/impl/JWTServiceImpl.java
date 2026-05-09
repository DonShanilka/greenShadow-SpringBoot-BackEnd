package lk.ijse.greenshowspringbootbackend.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lk.ijse.greenshowspringbootbackend.service.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${spring.jwtKey}")
    private String jwtKey;

    @Override
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public String refreshToken(UserDetails userDetails) {
        return refreshToken(new HashMap<>(), userDetails);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {

        final String username = extractUserName(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private <T> T extractClaim(String token,
                               Function<Claims, T> claimResolver) {

        final Claims claims = getAllClaims(token);

        return claimResolver.apply(claims);
    }

    private String generateToken(Map<String, Object> extraClaims,
                                 UserDetails userDetails) {

        extraClaims.put("role", userDetails.getAuthorities());

        Date now = new Date();

        Date expireDate = new Date(
                now.getTime() + 100000 * 120 * 120
        );

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private String refreshToken(Map<String, Object> extraClaims,
                                UserDetails userDetails) {

        extraClaims.put("role", userDetails.getAuthorities());

        Date now = new Date();

        Date refreshExpireDate = new Date(
                now.getTime() + 100000L * 120 * 120 * 48
        );

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(refreshExpireDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims getAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignKey() {

        return Keys.hmacShaKeyFor(
                jwtKey.getBytes(StandardCharsets.UTF_8)
        );
    }
}