package com.administration.etatcivil.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.administration.etatcivil.security.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${administration.app.jwtSecret}")
	private String jwtSecret;

	@Value("${administration.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalide JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalide JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token est expiré: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token n'est pas pris en charge: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT a chaîne de revendications est vide: {}", e.getMessage());
		}

		return false;
	}
}
