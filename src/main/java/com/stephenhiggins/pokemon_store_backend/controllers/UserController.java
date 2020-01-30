package com.stephenhiggins.pokemon_store_backend.controllers;

import com.stephenhiggins.pokemon_store_backend.helpers.CreationHelper;
import com.stephenhiggins.pokemon_store_backend.helpers.Crypto;
import com.stephenhiggins.pokemon_store_backend.models.User;
import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

  @Autowired UserRepo userRepo;
  private final String prodOrigin = "http://192.168.0.2:3000";
  private final String devOrigin = "http://localhost:3000";

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @DeleteMapping(value = "/delete_all")
  public JSONObject deleteAllUsers() {
    System.out.println("deleting");
    userRepo.deleteAll();
    JSONObject obj = new JSONObject();
    obj.put("deleted", true);
    return obj;
  }

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @GetMapping(value = "/")
  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @PostMapping(value = "/new_user")
  public JSONObject logUserIn(
      @RequestBody JSONObject userBody, @RequestHeader("Authorization") String auth)
      throws NoSuchAlgorithmException {

    String email = userBody.getAsString("email");
    String password = userBody.getAsString("password");
    User searchUser = userRepo.findByEmail(email);
    User user;
    DateTime dateNow = new DateTime();
    //    DateTime expiryDate = new DateTime().withHourOfDay(expiryHour);
    DateTime expiryDate = new DateTime().plusHours(1);

    if (searchUser == null) {
      user = new User(email, password);
      userRepo.save(user);
      return CreationHelper.buildSuccessfulLoginObject(user, dateNow, expiryDate);
    } else {
      //      JSONObject valid = JwtGenerator.verifyToken(auth);
      //        // System.out.println("VALID: " + valid.getAsString("verified"));
      //      if (Boolean.valueOf(valid.getAsString("verified")) == true) {
      String hash = Crypto.hash(password, searchUser.getSalt());
      if (hash.equals(searchUser.getHash())) {
        user = searchUser;
        userRepo.save(user);
        System.out.println("SUCCESSFUL LOGIN");
        return CreationHelper.buildSuccessfulLoginObject(user, dateNow, expiryDate);
      }
      System.out.println("FAILED LOGIN");
      return CreationHelper.buildFailureLoginObject("PASSWORD INCORRECT");

      //      } else {
      //        return CreationHelper.buildFailureLoginObject(valid.getAsString("error"));
      //      }
    }
  }

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @PutMapping(value = "change_pw_fli")
  public JSONObject changePasswordFromLoggedInStatus(@RequestBody JSONObject userInfo)
      throws NoSuchAlgorithmException {
    String email = userInfo.getAsString("email");
    User user = userRepo.findByEmail(email);

    if (user == null) {
      return CreationHelper.buildFailurePasswordResetObject(email);
    } else {
      byte[] salt = Crypto.generateSalt();
      String hash = Crypto.hash(userInfo.getAsString("password"), salt);
      user.setHash(hash);
      user.setSalt(salt);
      userRepo.save(user);
      return CreationHelper.buildSuccessfulPasswordResetObject(user);
    }
  }

  private User createUser(JSONObject userObject) throws NoSuchAlgorithmException {
    String password = userObject.getAsString("password");
    String email = userObject.getAsString("email");
    User user;
    User searchUser = userRepo.findByEmail(email);
    if (searchUser == null) {
      user = new User(email, password);
    } else {
      user = searchUser;
    }
    // System.out.println("SEARCH: " + searchUser);
    return userRepo.save(user);
  }
}
