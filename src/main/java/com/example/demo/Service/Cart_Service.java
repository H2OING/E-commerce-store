package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Repository.Cart_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class Cart_Service {
    @Autowired
    Cart_Repository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Cart getCartById(long id){
        Optional<Cart> cart = cartRepository.findById(id);
        if(cart.isPresent()){
            return cart.get();
        } else{
            throw new EntityNotFoundException();
        }
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cart){
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isPresent()){
            Cart existingCart = optionalCart.get();
            existingCart.setTotal(cart.getTotal());
            existingCart.setEmpty(cart.isEmpty());
            existingCart.setCustomer(cart.getCustomer());
            existingCart.setOrder(cart.getOrder());
            existingCart.setProducts(cart.getProducts());
            return cartRepository.save(existingCart);
        } else{
            throw new EntityNotFoundException();
        }
    }

    public void deleteCart(Long id){
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isPresent()){
            cartRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException();
        }
    }
}
