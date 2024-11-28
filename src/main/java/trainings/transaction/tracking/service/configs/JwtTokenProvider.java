package trainings.transaction.tracking.service.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;

public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;

    // Validate and extract claims from the token
    public String getUsernameFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.getSubject();
    }

    private Claims parseClaims(String token) {
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(jwtSecret) // Set the key used for signing the JWT
                .build();

        return parser.parseClaimsJws(token).getBody(); // Parse JWT and get claims
    }

    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            parseClaims(token); // Will throw an exception if the token is invalid
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
