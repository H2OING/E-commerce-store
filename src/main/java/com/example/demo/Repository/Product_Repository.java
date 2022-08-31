package com.example.demo.Repository;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
