package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Service.Category_Service;
import com.example.demo.Service.Product_Service;

import javax.validation.Valid;

import com.example.demo.Service.Web_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class Category_Controller {

    @Autowired
    Category_Service categoryService;
    @Autowired
    Product_Service productService;

    @Autowired
    Web_User_Service webUserService;

    @GetMapping("/categories")
    public String getAllCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        if(webUserService.isLoggedIn()){
            Collection<Product> products = webUserService.getLoggedInWebUser().getCart().getProducts();
            model.addAttribute("cartProducts", products);
        }
        return "categories";
    }

    @GetMapping(value = "/category/{id}")
    public String getCategory(@PathVariable(name = "id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("products", productService.getProductsByCategoryId(category));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category";
    }

    @PostMapping(value = "/admin/createCategory")
    public String createCategory(@Valid Category category){
        categoryService.createCategory(category);
        return "createCategory";
    }

    @PutMapping(value = "/admin/updateCategory/{id}")
    public String updateCategory(@PathVariable(name = "id") Long id, @Valid Category category){
        categoryService.updateCategory(id, category);
        return "updateCategory";
    }

    @RequestMapping(value = "/admin/deleteCategory/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
        return "deleteCategory";
    }
}
