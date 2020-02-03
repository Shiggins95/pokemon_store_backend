package com.stephenhiggins.pokemon_store_backend.controllers;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {

  private final String prodOrigin = "http://192.168.0.2:3000";
  private final String devOrigin = "http://localhost:3000";

  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @PostMapping(value = "/pay")
  public String pay(@RequestBody JSONObject body) throws StripeException {
    Stripe.apiKey = "sk_test_ptrilgY8VaHZpbahZgEYAolX00zx0tpUn2";
    Integer price = Integer.valueOf(body.getAsString("price"));
    String email = body.getAsString("email");
    Map<String, String> card = (HashMap) body.get("card");
    String method = card.get("id");
    String id = body.getAsString("id");
    Map<String, Object> customerParams = new HashMap<>();
    customerParams.put("email", email);
    customerParams.put("source", id);
    Customer customer = Customer.create(customerParams);

    Map<String, Object> params = new HashMap<>();
    params.put("amount", price);
    params.put("currency", "gbp");
    params.put("description", "My First Test Charge (created for API docs)");
    params.put("receipt_email", "stephen.higgins1995@gmail.com");
    params.put("customer", customer.getId());

    Charge charge = Charge.create(params);

    System.out.println(body.toString());
    System.out.println(body.getAsString("card"));

    return new JSONObject().toString();
  }
}
