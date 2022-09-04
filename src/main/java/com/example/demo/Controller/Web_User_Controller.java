package com.example.demo.Controller;

import com.example.demo.Model.Role;
import com.example.demo.Model.Web_User;
import com.example.demo.Service.Web_User_Service;
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
        return "registration";
    }

    @PostMapping(value = "/register")
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

    @PutMapping(value = "/admin/webuser/update/{id}")
    public String updateWebUser(@PathVariable(name = "id") Long id, Web_User webUser){
        webUserService.updateWebUser(id, webUser);
        return "updateWebUser";
    }

    @RequestMapping(value = "/admin/webuser/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteWebUser(@PathVariable(name = "id") Long id){
        webUserService.deleteWebUser(id);
        return "redirect:/admin/webuser";
    }
}
