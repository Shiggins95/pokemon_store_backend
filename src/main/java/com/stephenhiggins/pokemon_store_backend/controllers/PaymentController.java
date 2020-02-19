package com.stephenhiggins.pokemon_store_backend.controllers;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {

  private final String prodOrigin = "https://pokemonstorereact.herokuapp.com/";
  private final String devOrigin = "http://localhost:3000";
  // TODO - make users an inherited class of admin and customer. Add customer id to customers when
  // payment is made
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @PostMapping(value = "/pay")
  public String pay(@RequestBody JSONObject body) throws StripeException {
    Stripe.apiKey = "sk_test_ptrilgY8VaHZpbahZgEYAolX00zx0tpUn2";
    Integer price = Integer.valueOf(body.getAsString("price"));
    String email = body.getAsString("email");
    Map<String, Object> options = new HashMap<>();
    options.put("email", email);
    List<Customer> customers = Customer.list(options).getData();
    Map<String, String> card = (HashMap) body.get("card");
    String id = body.getAsString("id");

    // customer details
    Map<String, Object> customerParams = new HashMap<>();
    List<HashMap> items = (ArrayList) body.get("ya_boys_products");
    HashMap<String, String> address = (HashMap) body.get("address");
    customerParams.put("email", email);

    Customer customer;
    if (customers.size() > 0) {
      customer = Customer.retrieve(customers.get(0).getId());
      System.out.println("CUSTOMER ID: " + customers.get(0).getId());
      customer.update(customerParams);
    } else {
      System.out.println("NO CUSTOMER FOUND");
      customer = Customer.create(customerParams);
    }

    // charge details
    Map<String, Object> params = new HashMap<>();
    params.put("amount", price);
    params.put("currency", "gbp");
    params.put("description", "My First Test Charge (created for API docs)");
    params.put("receipt_email", email);
    params.put("customer", customer.getId());

    Charge charge = Charge.create(params);

    System.out.println(body.toString());
    System.out.println(body.getAsString("card"));

    return new JSONObject().toString();
  }
}
