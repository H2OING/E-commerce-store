package com.example.demo.Controller;

import com.example.demo.Model.Bill;
import com.example.demo.Model.Cart;
import com.example.demo.Model.Product;
import com.example.demo.Model.Web_User;
import com.example.demo.Service.Cart_Service;
import com.example.demo.Service.Product_Service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Cart_Controller {
    @Autowired
    Cart_Service cartService;
    @Autowired
    Product_Service prodService;
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
    
    @PostMapping("/addToCart")
    public String addToCart (HttpServletRequest req, Model model, @RequestParam("id") Long id, @RequestParam("quantity") int quantity) {
    	String Stoken = (String) req.getSession(true).getAttribute("sessionToken");
    	if(Stoken !=null) {  // reminder to think where to add session token
    		Stoken = UUID.randomUUID().toString();
    		req.getSession().setAttribute("sessionToken", Stoken);
    		cartService.addToCart(id, Stoken, quantity, false);
    	}else {
    		// existing cart code
    	}
    	
    	return "PlaceHolder";
    }
    @GetMapping("/cart")
    public String OpenCart(Cart cart, Model model) {
    	List<Product> prod = prodService.getAllProducts();  //getAllProductsAddedToCart
    	//Product prod = new Product();
    	model.addAttribute("allProducts", prod);
    	Cart carts = new Cart();
    	model.addAttribute("cart", carts);
    	return "cart";
    }
}
