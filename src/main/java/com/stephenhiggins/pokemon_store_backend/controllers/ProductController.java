package com.stephenhiggins.pokemon_store_backend.controllers;

import com.stephenhiggins.pokemon_store_backend.models.Product;
import com.stephenhiggins.pokemon_store_backend.models.User;
import com.stephenhiggins.pokemon_store_backend.repos.ProductRepo;
import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

  @Autowired UserRepo userRepo;
  @Autowired ProductRepo productRepo;

  private final String prodOrigin = "http://192.168.0.2:3000";
  private final String devOrigin = "http://localhost:3000";

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @GetMapping(value = "/")
  public List<Product> getAllUsers() {
    return productRepo.findAll();
  }

  @Transactional
  @CrossOrigin(origins = {prodOrigin, devOrigin})
  @PostMapping(value = "/new_product")
  public Product createNewProduct(@RequestBody JSONObject body) {
    String name = body.getAsString("name");
    String description = body.getAsString("description");
    double price = Double.valueOf(body.getAsString("price"));
    String type = body.getAsString("type");
    int quantity = Integer.valueOf(body.getAsString("quantity"));
    String img = body.getAsString("img");
    User user = userRepo.getOne(Long.valueOf(body.getAsString("userId")));
    Product product = new Product(name, description, price, type, quantity, img);
    user.addToProducts(product);
    productRepo.save(product);
    userRepo.save(user);
    return product;
  }
}