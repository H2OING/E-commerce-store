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

    @GetMapping("PlaceholderMapping7")
    public String getAllWebUsers(Model model){
        model.addAttribute("webUsers", webUserService.getAllWebUsers());
        return "webUsers";
    }

    @GetMapping(value = "PlaceholderMapping8")
    public String getWebUser(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("webUser", webUserService.getWebUserById(id));
        return "webUser";
    }

    @PostMapping(value = "PlaceholderMapping9")
    public String createWebUser(Web_User webUser){
        webUserService.createWebUser(webUser);
        return "createWebUser";
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
