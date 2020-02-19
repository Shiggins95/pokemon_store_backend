package com.stephenhiggins.pokemon_store_backend;

import com.stephenhiggins.pokemon_store_backend.models.Product;
import com.stephenhiggins.pokemon_store_backend.models.User;
import net.minidev.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {
  Product product;
  User user;

  @Before
  public void setup() throws NoSuchAlgorithmException {
    product =
        new Product(
            "Product 1",
            "This is product 1",
            1.99,
            "Legend",
            100,
            "https://image.ibb" + ".co/kVtAiz/darkraithumb.png",
            "");
    user = new User("stephen.higgins@email.com", "Password123");
  }

  @Test
  public void canCreateNewProduct() {
    String description = product.getDescription();
    assertEquals("This is product 1", description);
  }

  @Test
  public void canAssignUser() {
    product.setUser(user);
    assertEquals("stephen.higgins@email.com", product.getUser().getEmail());
  }
}
