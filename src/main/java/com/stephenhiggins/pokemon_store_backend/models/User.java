package com.stephenhiggins.pokemon_store_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stephenhiggins.pokemon_store_backend.helpers.Crypto;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String email;
  @Column private byte[] salt;
  @Column private String hash;

  @JsonIgnoreProperties(value = "user")
  @OneToMany(mappedBy = "user")
  private List<Product> products;

  public User(String email, String password) throws NoSuchAlgorithmException {
    this.email = email;
    byte[] salt = Crypto.generateSalt();
    this.salt = salt;
    this.hash = Crypto.hash(password, salt);
    this.products = new ArrayList<>();
  }

  public User() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void addToProducts(Product product) {
    this.products.add(product);
    product.setUser(this);
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void removeFromProducts(Product product) {
    this.products.remove(product);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public byte[] getSalt() {
    return salt;
  }

  public void setSalt(byte[] salt) {
    this.salt = salt;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }
}
