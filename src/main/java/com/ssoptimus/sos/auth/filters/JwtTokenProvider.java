package com.ssoptimus.sos.auth.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtTokenProvider {
    private String secretKey;

    @PostConstruct
    private void init(){
        System.out.println("aa");

        secretKey = Base64.getEncoder().encodeToString("asdsdsssss".getBytes());
        System.out.println(secretKey);
    }

    public String createToken(String userPk){
        Calendar accessDate = Calendar.getInstance();
        accessDate.add(Calendar.MINUTE,1);
        Calendar refreshDate = Calendar.getInstance();
        refreshDate.add(Calendar.DATE,1);

        Claims accessToken = Jwts.claims()
                .setSubject("access_token")
                .setIssuedAt(new Date())
                .setId(userPk)
                .setExpiration(accessDate.getTime());

        Claims refreshToken = Jwts.claims()
                .setSubject("refresh_token")
                .setIssuedAt(new Date())
                .setId(userPk)
                .setExpiration(refreshDate.getTime());

        // jwt body 부분
        Map<String,Object> claimsStringMap = new HashMap<>();
        claimsStringMap.put("refresh_token",refreshToken);
        claimsStringMap.put("access_token",accessToken);
        return Jwts.builder()
                .setClaims(claimsStringMap)
                .setHeaderParam("typ", "JWT")
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(Base64.getDecoder().decode(secretKey)).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    private String getUserId(String token){
        Claims claims = parseClaims(token);
        return claims.getSubject();
    }

    public boolean validateToken(String token){

        try{
            Claims claim = parseClaims(token);
            System.out.println(claim.get("refresh_token"));
            System.out.println(claim.get("access_token"));
            ObjectMapper mapper = new ObjectMapper();
            Map accessToken = mapper.convertValue(claim.get("access_token"),Map.class);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date( Long.parseLong(String.valueOf(accessToken.get("exp"))+"000" )));
            System.out.println(calendar);
            System.out.println(calendar1);
            if( calendar.after(calendar1)){
                return false;
            }
            return true;
        }
         catch (ExpiredJwtException e) {
             //log.info("Expired JWT Token", e);
             return false;

        } catch (UnsupportedJwtException e) {
           // log.info("Unsupported JWT Token", e);
            return false;

        } catch (IllegalArgumentException e) {
            //log.info("JWT claims string is empty.",e);
            return false;
        }
    }
}
