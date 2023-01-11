package com.example.restexample.restexample.services.auth;

import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import com.example.restexample.restexample.dal.models.Usuarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getTokenFromHeader(HttpServletRequest request){
       String bearer =  request.getHeader("Authorization");

       return Strings.isBlank(bearer)?Strings.EMPTY: bearer.replaceFirst("Bearer ", Strings.EMPTY);
    }

    public boolean validateToken(String token){
        try {
            String nameUsr = getSpecificValue(token,Claims::getSubject);
            return Strings.isNotBlank(nameUsr);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public <T> T getSpecificValue(String token, Function<Claims,T> generator){
        Claims c = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        if(Objects.nonNull(c)){
            return generator.apply(c);
        }
        return null;
    }

    public String generateToken(Usuarios userDto){
         return Jwts.builder().setSubject(userDto.getCorreo())
        .setIssuedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))
        .setExpiration(new Date(System.currentTimeMillis() + 300000))
        .signWith(key)
        .compact();
    }
    
}
