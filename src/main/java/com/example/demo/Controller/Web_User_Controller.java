package com.example.demo.Controller;

import com.example.demo.Model.Web_User;
import com.example.demo.Service.Web_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(value = "PlaceholderMapping8")
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

    @PutMapping(value = "PlaceholderMapping10")
    public String updateWebUser(@PathVariable(name = "id") Long id, Web_User webUser){
        webUserService.updateWebUser(id, webUser);
        return "updateWebUser";
    }

    @RequestMapping(value = "PlaceholderMapping11", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteWebUser(@PathVariable(name = "id") Long id){
        webUserService.deleteWebUser(id);
        return "deleteWebUser";
    }
}
