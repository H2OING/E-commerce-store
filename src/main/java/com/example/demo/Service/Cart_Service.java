package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Product;
import com.example.demo.Model.Web_User;
import com.example.demo.Repository.Cart_Repository;
import com.example.demo.Repository.Product_Repository;
<<<<<<< HEAD
=======

>>>>>>> efbdfeee81175f91e934c233105742180e5a512f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
<<<<<<< HEAD
=======

>>>>>>> efbdfeee81175f91e934c233105742180e5a512f
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class Cart_Service {
    @Autowired
    Cart_Repository cartRepository;
    @Autowired
<<<<<<< HEAD
    Product_Repository productRepository;
=======
    Product_Repository prodRepo;
    @Autowired
    Product_Service prodService;
>>>>>>> efbdfeee81175f91e934c233105742180e5a512f

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
            existingCart.setWebUser(cart.getWebUser());
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
<<<<<<< HEAD

    public void addToCart(Long productId, int quantity, Web_User loggedInUser) {
        Product product = productRepository.findById(productId).get();
        Cart cart = loggedInUser.getCart();
        cart.addProduct(product);
        product.addCart(cart);
        cartRepository.save(cart);
        productRepository.save(product);
    }

    public void removeFromCart(Long productId, Web_User loggedInUser){
        Product product = productRepository.findById(productId).get();
        Cart cart = loggedInUser.getCart();
        cart.removeProduct(product);
        product.removeCart(cart);
        cartRepository.save(cart);
        productRepository.save(product);
=======
    
    public void addToCart(Long id, String sessionToken, int quantity, boolean answer) { 
    	Cart cart = new Cart();
    	Product product = new Product();
    	product.setQuantity(quantity);
    	cart.setProducts((Collection<Product>) prodService.getProductById(id));
    	cart.setEmpty(answer);
    	cart.getProducts().add(product);
    	cart.setWebUser(null);  //need to think where to add session token, either in cart or web_user
    	
    	//Collection<Product> prod = (Collection<Product>) prodRepo.findById(id).get();
    	
    	
    	cartRepository.save(cart);
>>>>>>> efbdfeee81175f91e934c233105742180e5a512f
    }
}
