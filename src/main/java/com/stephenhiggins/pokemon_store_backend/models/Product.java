package com.stephenhiggins.pokemon_store_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String name;
  @Column private String description;
  @Column private double price;
  @Column private String type;
  @Column private int quantity;
  @Column private String img;

  //  @JsonIgnoreProperties(value = "products")
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Product(
      String name, String description, double price, String type, int quantity, String img) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.type = type;
    this.quantity = quantity;
    this.img = img;
  }

  public Product() {}

  public Long getId() {
    return id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
