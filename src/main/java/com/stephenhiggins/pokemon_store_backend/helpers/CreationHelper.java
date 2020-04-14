package com.stephenhiggins.pokemon_store_backend.helpers;

import com.stephenhiggins.pokemon_store_backend.models.JwtGenerator;
import com.stephenhiggins.pokemon_store_backend.models.User;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;

public class CreationHelper {
  public static JSONObject buildSuccessfulLoginObject(
      User user, DateTime dateNow, DateTime expiryDate) {
    JSONObject userInfo = new JSONObject();
    JSONObject tokenInfo = new JSONObject();
    tokenInfo.put("token_id", JwtGenerator.getToken(expiryDate.getMillis()));
    tokenInfo.put("expires_at", expiryDate.getMillis());
    userInfo.put("success", true);
    userInfo.put("user_id", user.getId());
    userInfo.put("token_info", tokenInfo);
    return userInfo;
  }

  public static JSONObject buildFailureLoginObject(String reason) {
    JSONObject failResponse = new JSONObject();
    failResponse.put("error", reason);
    return failResponse;
  }

  public static JSONObject buildFailurePasswordResetObject(String email) {
    JSONObject failure = new JSONObject();
    failure.put("error", "could not locate user with email: " + email);
    return failure;
  }

  public static JSONObject buildSuccessfulPasswordResetObject(User user) {
    JSONObject success = new JSONObject();
    success.put("success", "successfully updated password");
    success.put("user_id", user.getId());
    return success;
  }
}
