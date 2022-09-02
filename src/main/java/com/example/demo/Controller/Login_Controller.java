package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Web_User;
import com.example.demo.Service.Web_User_Service;

@Controller
public class Login_Controller {
    @Autowired
    Web_User_Service webUserService;
    @GetMapping("/login")
	public String login(Web_User wUser) {
		return "login";
	}
	@PostMapping("/login")
    public String postInsertNewEmployee(Web_User wUser){
            if(webUserService.getWebUserByEmailAndPassword(wUser.getEmail(), wUser.getPassword())) {
				webUserService.setLoggedIn(true);
                return "redirect:/home";
			}
            else {
                return "login";
			}
    }
	@GetMapping("/logout")
	public String logout() {
		webUserService.setLoggedIn(false);
		return "redirect:/login";
	}
    
}
