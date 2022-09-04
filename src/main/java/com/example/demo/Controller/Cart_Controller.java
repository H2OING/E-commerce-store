package com.example.demo.Controller;

import com.example.demo.Model.Bill;
import com.example.demo.Model.Cart;
import com.example.demo.Model.Product;
import com.example.demo.Model.Web_User;
import com.example.demo.Service.Cart_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Cart_Controller {

    @Autowired
    Cart_Service cartService;
   // @Autowired
    //Custo

    @GetMapping(value = "/admin/carts")
    public String getAllCarts(Model model){
        model.addAttribute("carts", cartService.getAllCarts());
        return "carts";
    }

    @GetMapping(value = "/cart/{id}")
    public String getCart(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("cart", cartService.getCartById(id));
        return "cart";
    }

    @PostMapping(value = "PlaceholderMapping1")
    public String createCart(@Valid Cart cart){
        cartService.createCart(cart);
        return "createCart";
    }

    @PutMapping(value = "/updateCart/{id}")
    public String updateCart(@PathVariable(name = "id") Long id, @Valid Cart cart){
        cartService.updateCart(id, cart);
        return "updateCart";
    }

    @RequestMapping(value = "/deleteCart/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCart(@PathVariable(name = "id") Long id){
        cartService.deleteCart(id);
        return "deleteCart";
    }
    
    @PostMapping("/add")
    public String addToCart (@Valid Cart cart, @Valid Product prod, long id) {
    	Web_User user = new Web_User();
    	//user.getIdUser()
    	cartService.addToCart(user, id, false);
    	return "cart";
    }
}
