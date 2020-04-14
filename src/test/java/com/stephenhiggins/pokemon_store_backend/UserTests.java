//package com.stephenhiggins.pokemon_store_backend;
//
//import com.stephenhiggins.pokemon_store_backend.helpers.Crypto;
//import com.stephenhiggins.pokemon_store_backend.models.Product;
//import com.stephenhiggins.pokemon_store_backend.models.User;
//import com.stephenhiggins.pokemon_store_backend.repos.UserRepo;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.security.NoSuchAlgorithmException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserTests {
//
//  @Autowired UserRepo userRepo;
//
//  @Test
//  public void contextLoads() {}
//
//  @Test
//  public void canVerifyUser() throws NoSuchAlgorithmException {
//    String emailToTry = "stephen.higgins1995@gmail.com";
//    User thisUser = userRepo.findByEmail(emailToTry);
//    System.out.println(thisUser.getEmail());
//    byte[] userSalt = thisUser.getSalt();
//    String passwordToTry = "Password123";
//    String wrongPassword = "password123";
//    String correctHash = Crypto.hash(passwordToTry, userSalt);
//    String wrongHash = Crypto.hash(wrongPassword, userSalt);
//    System.out.println("WRONG HASH: " + wrongHash);
//    System.out.println("CORRECT HASH: " + correctHash);
//    System.out.println("USER HASH: " + thisUser.getHash());
//    assertEquals(thisUser.getHash(), correctHash);
//    assertNotEquals(thisUser.getHash(), wrongHash);
//  }
//
//  @Test
//  public void canAddProduct() throws NoSuchAlgorithmException {
//    Product product =
//        new Product(
//            "Product 1",
//            "This is product 1",
//            1.99,
//            "Legend",
//            100,
//            "https://image.ibb" + ".co/kVtAiz/darkraithumb.png",
//            "");
//    User user = new User("stephen.higgins@email.com", "Password123");
//
//    user.addToProducts(product);
//    assertEquals(1, user.getProducts().size());
//    assertEquals("stephen.higgins@email.com", user.getProducts().get(0).getUser().getEmail());
//  }
//}
