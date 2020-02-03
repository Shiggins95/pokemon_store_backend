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
            "10 Custom Pokemon",
            "Get 10 Custom Pokemon",
            0.99,
            "package",
            17,
            "https://image.ibb.co/mbVHDz/thumb10.png");
    product1.setUser(user1);
    user1.addToProducts(product1);
    productrepo.save(product1);
    Product product2 =
        new Product(
            "20 Custom Pokemon",
            "Get 20 Custom Pokemon",
            1.99,
            "package",
            0,
            "https://image.ibb.co/karDmK/thumb20.png");
    product2.setUser(user1);
    user1.addToProducts(product2);
    productrepo.save(product2);
    Product product3 =
        new Product(
            "Guardian Deities",
            "Get the Alolan Guardian Deities",
            2.99,
            "package",
            100,
            "https://image.ibb.co/cdUNwK/GUARDIANDEITIESTHUMB.png");
    product3.setUser(user1);
    user1.addToProducts(product3);
    productrepo.save(product3);
    Product product4 =
        new Product(
            "Ultra Beasts",
            "Get All Ultra Beasts",
            3.99,
            "package",
            0,
            "https://image.ibb.co/dGM5iz/THUMBNAIL.png");
    product4.setUser(user1);
    user1.addToProducts(product4);
    productrepo.save(product4);
    Product product5 =
        new Product(
            "Shiny Darkrai",
            "Get a Shiny Darkrai",
            2.99,
            "shiny_legend",
            100,
            "https://image.ibb.co/kVtAiz/darkraithumb.png");
    product5.setUser(user1);
    user1.addToProducts(product5);
    productrepo.save(product5);
    Product product6 =
        new Product(
            "Shiny Shaymin",
            "Get a Shiny Shaymin",
            1.99,
            "shiny_legend",
            0,
            "https://image.ibb.co/nwAWOz/shayminthumb.png");
    product6.setUser(user1);
    user1.addToProducts(product6);
    productrepo.save(product6);
    Product product7 =
        new Product(
            "Shiny Japanese Ditto",
            "Get a Shiny Japanese Ditto",
            1.99,
            "shiny_single",
            10,
            "https://image.ibb.co/eTqOmK/dittothumb.png");
    product7.setUser(user1);
    user1.addToProducts(product7);
    productrepo.save(product7);
    userRepo.save(user1);
    Product product8 =
        new Product(
            "Shiny Genesect",
            "Get a Shiny Genesect",
            1.99,
            "event",
            7,
            "https://image.ibb.co/nB34Ae/genesect.png");
    product8.setUser(user1);
    user1.addToProducts(product8);
    productrepo.save(product8);
    Product product9 =
        new Product(
            "Shiny Mew",
            "Get a shiny Mew",
            1.99,
            "shiny_legend",
            100,
            "https://image.ibb.co/heMo3z/mewthumb.png");
    product9.setUser(user1);
    user1.addToProducts(product9);
    productrepo.save(product9);
    userRepo.save(user1);
  }
}
