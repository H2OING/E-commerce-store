package com.example.demo.Controller;

import com.example.demo.Model.Bill;
import com.example.demo.Model.Cart;
import com.example.demo.Service.Cart_Service;
import com.example.demo.Service.Web_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class Cart_Controller {
    @Autowired
    Cart_Service cartService;
    @Autowired
    Web_User_Service webUserService;

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
    public String createCart(Cart cart){
        cartService.createCart(cart);
        return "createCart";
    }

    @PostMapping(value = "/user/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long productId, @RequestParam("quantity") int quantity){
        cartService.addToCart(productId, quantity, webUserService.getLoggedInWebUser());
        return "redirect:/";
    }

    @DeleteMapping(value = "/user/deleteFromCart/{id}")
    public String removeFromCart(HttpServletRequest request, Model model, @PathVariable("id") Long productId){
        cartService.removeFromCart(productId, webUserService.getLoggedInWebUser());
        return "redirect:/";
    }

    @PutMapping(value = "/updateCart/{id}")
    public String updateCart(@PathVariable(name = "id") Long id, Cart cart){
        cartService.updateCart(id, cart);
        return "updateCart";
    }

    @RequestMapping(value = "/deleteCart/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCart(@PathVariable(name = "id") Long id){
        cartService.deleteCart(id);
        return "deleteCart";
    }
}
