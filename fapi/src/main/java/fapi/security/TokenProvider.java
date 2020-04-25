package fapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenProvider implements Serializable {

    /**
     * retrieve username from jwt token
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }


    /**
     * retrieve expiration date from jwt token
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * for retrieveing any information from token we will need the secret key
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SecurityJwtConstants.SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     * check if the token has expired
     */
    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * generate token for user
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
//        final String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim(SecurityJwtConstants.AUTHORITIES_KEY, authorities)
//                .signWith(SignatureAlgorithm.HS256, SecurityJwtConstants.SIGNING_KEY)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + SecurityJwtConstants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
//                .compact();
    }


    /**
     * while creating the token -
     * 1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
     * 2. Sign the JWT using the HS512 algorithm and secret key.
     * 3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
     * compaction of the JWT to a URL-safe string
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityJwtConstants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .signWith(SignatureAlgorithm.HS256, SecurityJwtConstants.SIGNING_KEY).compact();
    }

    /**
     * validate token
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = getUsernameFromToken(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

//    public UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuthentication, UserDetails userDetails) {
//        final JwtParser jwtParser = Jwts.parser().setSigningKey(SecurityJwtConstants.SIGNING_KEY);
//        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
//        final Claims claims = claimsJws.getBody();
//        final Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(SecurityJwtConstants.AUTHORITIES_KEY).toString().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
//    }
}
