package com.example.demo.Controller;

import com.example.demo.Model.Role;
import com.example.demo.Model.Web_User;
import com.example.demo.Service.Category_Service;
import com.example.demo.Service.Web_User_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class Web_User_Controller {
    @Autowired
    Web_User_Service webUserService;
    @Autowired
    Category_Service categoryService; //For navigation bar

    @GetMapping("/admin/webuser")
    public String getAllWebUsers(Model model){
        model.addAttribute("webUser", webUserService.getAllWebUsers());
        return "webUser-show-all";
    }

    @GetMapping(value = "/admin/webuser/{id}")
    public String getWebUser(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("webUser", webUserService.getWebUserById(id));
        return "webUser";
    }


    @GetMapping(value = "/user/accountDetails")
    public String getLoggedInUserDetails(Model model){
        model.addAttribute("webUser", webUserService.getLoggedInWebUser());
        return "accountDetails";
    }


    @GetMapping(value = "/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("webUser", new Web_User());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "registration";
    }

    @PostMapping(value = "/register")

    public String createWebUser(@ModelAttribute("webUser") Web_User webUser){

        webUserService.createWebUser(webUser);
        return "redirect:/register?success";
    }

    public String createWebUser(@ModelAttribute("webUser") @Valid Web_User webUser, BindingResult result){
        try {
            if (result.hasErrors()) {
                return "registration";
            } else {
                webUserService.createWebUser(webUser);
                return "redirect:/register?success";
            }
        } catch (Exception e){
            return "redirect:/register?error";
        }

    }


    @PutMapping(value = "PlaceholderMapping10")
    public String updateWebUser(@PathVariable(name = "id") Long id, @Valid Web_User webUser){
        webUserService.updateWebUser(id, webUser);
        return "updateWebUser";
    }

    @GetMapping(value = "/admin/webuser/update/{id}")
    public String updateWebUser(@PathVariable(name = "id") Long id, Model model){
        try{
            model.addAttribute("webuser", webUserService.getWebUserById(id));
            return "webUser-update";
        }
        catch(Exception e){
            return "error";
        }
    }
    @PostMapping("/admin/webuser/update/{id}")
    public String postUpdateCourse(@PathVariable(name = "id") Long id,@Valid Web_User webUser, BindingResult result, Model model){
        
        if(!result.hasErrors()){
            if(webUserService.updateWebUser(id, webUser))
                return "redirect:/admin/webuser/" + id;
            else
                return "redirect:/error";
        }
        else{
            model.addAttribute("webuser", webUserService.getAllWebUsers());
            return"webUser-update";
        }

    }


    @RequestMapping(value = "/admin/webuser/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteWebUser(@PathVariable(name = "id") Long id){
        webUserService.deleteWebUser(id);
        return "redirect:/admin/webuser";
    }
}
