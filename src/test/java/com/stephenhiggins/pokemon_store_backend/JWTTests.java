//package com.stephenhiggins.pokemon_store_backend;
//
//import com.stephenhiggins.pokemon_store_backend.models.JwtGenerator;
//import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
//import net.minidev.json.JSONObject;
//import org.joda.time.DateTime;
//import org.junit.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class JWTTests {
//
//  @Autowired UserRepo userRepo;
//
//  String token;
//  String tokenTwo;
//  DateTime failDate;
//  DateTime passDate;
//
//    @Before
//    public void setup() {
//      failDate = new DateTime().minusHours(1);
//      passDate = new DateTime().plusHours(1);
//      token = JwtGenerator.getToken(failDate.getMillis());
//      tokenTwo = JwtGenerator.getToken(passDate.getMillis());
//    }
//
//  @Test
//  public void contextLoads() {}
//
//  @Test
//  public void canGetToken() {
//    String[] split = token.split("\\.");
//    assertEquals(3, split.length);
//  }
//
//  @Test
//  public void canVerifyToken() {
//    JSONObject resultOne = JwtGenerator.verifyToken(token);
//    JSONObject resultTwo = JwtGenerator.verifyToken(tokenTwo);
//    assertEquals("true", resultTwo.getAsString("verified"));
//    assertEquals("false", resultOne.getAsString("verified"));
//  }
//}
