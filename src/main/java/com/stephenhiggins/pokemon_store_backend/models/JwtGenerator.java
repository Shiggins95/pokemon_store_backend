package com.stephenhiggins.pokemon_store_backend.models;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;

import java.time.temporal.TemporalField;
import java.util.Date;

public class JwtGenerator {
  public JwtGenerator() {}

  public static String getToken(Long date) {
    String token = "";
    try {
      Algorithm algo = Algorithm.HMAC256("secret");
      // System.out.println(date);
      token =
          JWT.create()
              .withClaim("expires_at", date)
              .withClaim("origin", "https://the_pokemon_store")
              .withClaim("authority", "full")
              .withIssuer("auth0")
              .sign(algo);
    } catch (JWTCreationException e) {
      // System.out.println(e);
    }

    return token;
  }

  public static JSONObject verifyToken(String token) {

    JSONObject obj = new JSONObject();
    try {
      Algorithm algo = Algorithm.HMAC256("secret");
      JWTVerifier verifier = JWT.require(algo).withIssuer("auth0").build();
      DecodedJWT jwt;
      try {
        jwt = verifier.verify(token);
      } catch (Exception e) {
        // System.out.println("EXCEPTION MOFO" + e);
        obj.put("error", e);
        obj.put("verified", false);
        return obj;
      }
      Long expires = jwt.getClaim("expires_at").asLong();
      Long now = new DateTime().getMillis();
      // System.out.println("EXPIRES: "+jwt.getClaim("expires_at").asString());
      // System.out.println("ORIGIN: "+jwt.getClaim("origin").asString());
      // System.out.println("AUTHORITY: "+jwt.getClaim("authority").asString());
      if (now > expires) {
        // System.out.println("NOT VALID NOW: " + now);
        // System.out.println("NOT VALID EXPIRES: " + expires);
        obj.put("error", "TOKEN HAS EXPIRED");
        obj.put("verified", false);
        return obj;
      }
      else {
        obj.put("success", "token verification success");
        obj.put("verified", true);
        // System.out.println("VALID NOW: " + now);
        // System.out.println("VALID EXPIRES: " + expires);
        return obj;
      }
    } catch (JWTVerificationException e) {
      // System.out.println(e);
      obj.put("error", e);
      obj.put("verified", false);
      return obj;
    }
  }
}
