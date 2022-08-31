package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Service.Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Category_Controller {

    @Autowired
    Category_Service categoryService;

    @GetMapping("/categories")
    public String getAllCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping(value = "/category/{id}")
    public String getCategory(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "category";
    }

    @PostMapping(value = "/admin/createCategory")
    public String createCategory(Category category){
        categoryService.createCategory(category);
        return "createCategory";
    }

    @PutMapping(value = "/admin/updateCategory/{id}")
    public String updateCategory(@PathVariable(name = "id") Long id, Category category){
        categoryService.updateCategory(id, category);
        return "updateCategory";
    }

    @RequestMapping(value = "/admin/deleteCategory/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
        return "deleteCategory";
    }
}
