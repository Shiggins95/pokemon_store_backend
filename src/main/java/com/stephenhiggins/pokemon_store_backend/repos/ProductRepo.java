package com.stephenhiggins.pokemon_store_backend.repos;

import com.stephenhiggins.pokemon_store_backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {}
