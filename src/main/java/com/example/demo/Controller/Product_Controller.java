package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Product_Controller {
    @Autowired
    Product_Service productService;

    @GetMapping
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @GetMapping(value = "/product/{id}")
    public String getProduct(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @PostMapping(value = "/admin/createProduct")
    public String createProduct(Product product){
        productService.createProduct(product);
        return "createProduct";
    }

    @PutMapping(value = "/admin/updateProduct/{id}")
    public String updateProduct(@PathVariable(name = "id") Long id, Product product){
        productService.updateProduct(id, product);
        return "updateProduct";
    }

    @RequestMapping(value = "/admin/deleteProduct/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
        return "deleteProduct";
    }
}
