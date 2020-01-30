package com.stephenhiggins.pokemon_store_backend.components;

import com.stephenhiggins.pokemon_store_backend.models.Product;
import com.stephenhiggins.pokemon_store_backend.models.User;
import com.stephenhiggins.pokemon_store_backend.repos.ProductRepo;
import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UserLoader implements ApplicationRunner {
  @Autowired UserRepo userRepo;
  @Autowired ProductRepo productrepo;

  public UserLoader() {}

  public void run(ApplicationArguments args) throws NoSuchAlgorithmException {
    User user1 = new User("stephen.higgins1995@gmail.com", "Password123");
    userRepo.save(user1);

    Product product1 =
        new Product(
            "10 Legendary Pokemon",
            "Get 10 legendary Pokemon",
            0.99,
            "package",
            10,
            "https://image.ibb.co/bZcre9/All-Legends-Thumb.png");
    product1.setUser(user1);
    user1.addToProducts(product1);
    productrepo.save(product1);
    Product product2 =
        new Product(
            "20 Legendary Pokemon",
            "Get 20 legendary Pokemon",
            1.99,
            "package",
            0,
            "https://image.ibb.co/bZcre9/All-Legends-Thumb.png");
    product2.setUser(user1);
    user1.addToProducts(product2);
    productrepo.save(product2);
    Product product3 =
        new Product(
            "30 Legendary Pokemon",
            "Get 30 legendary Pokemon",
            2.99,
            "package",
            10,
            "https://image.ibb.co/bZcre9/All-Legends-Thumb.png");
    product3.setUser(user1);
    user1.addToProducts(product3);
    productrepo.save(product3);
    Product product4 =
        new Product(
            "40 Legendary Pokemon",
            "Get 40 legendary Pokemon",
            3.99,
            "package",
            10,
            "https://image.ibb.co/bZcre9/All-Legends-Thumb.png");
    product4.setUser(user1);
    user1.addToProducts(product4);
    productrepo.save(product4);
    Product product5 =
        new Product(
            "Shiny Darkrai",
            "Get a Shiny Darkrai",
            2.99,
            "shiny_legend",
            10,
            "https://image.ibb" + ".co/kVtAiz/darkraithumb.png");
    product5.setUser(user1);
    user1.addToProducts(product5);
    productrepo.save(product5);
    Product product6 =
        new Product(
            "Shiny Shaymin",
            "Get a Shiny Shaymin",
            1.99,
            "shiny_legend",
            10,
            "https://image.ibb.co/nwAWOz/shayminthumb.png");
    product6.setUser(user1);
    user1.addToProducts(product6);
    productrepo.save(product6);
    userRepo.save(user1);
  }
}
