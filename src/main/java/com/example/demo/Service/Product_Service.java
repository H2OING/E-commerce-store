package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class Product_Service {
    @Autowired
    Product_Repository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        } else{
            throw new EntityNotFoundException();
        }
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setPicture(product.getPicture());
            existingProduct.setCarts(product.getCarts());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        } else{
            throw new EntityNotFoundException();
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException();
        }
    }
}
