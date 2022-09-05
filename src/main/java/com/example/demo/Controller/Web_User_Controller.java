package com.example.demo.Controller;

import com.example.demo.Model.Web_User;
import com.example.demo.Service.Web_User_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class Web_User_Controller {
    @Autowired
    Web_User_Service webUserService;

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

    @GetMapping(value = "/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("webUser", new Web_User());
        return "registration";
    }

    @PostMapping(value = "/register")
    public String createWebUser(@ModelAttribute("webUser") Web_User webUser){
        webUserService.createWebUser(webUser);
        return "redirect:/register?success";
    }

    @GetMapping("/admin/webuser/update/{id}")
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
    public String postUpdateWebUser(@PathVariable(name = "id") Long id,@Valid Web_User webUser, BindingResult result, Model model){
        
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
