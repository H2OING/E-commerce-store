package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.Customer_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Customer_Controller {

    @Autowired
    Customer_Service customerService;

    @GetMapping("/admin/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping(value = "/admin/customer/{id}")
    public String getCustomer(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @PostMapping(value = "/register")
    public String createCustomer(@Valid Customer customer){
        customerService.createCustomer(customer);
        return "register";
    }

    @PutMapping(value = "PlaceholderMapping2")
    public String updateCustomer(@PathVariable(name = "id") Long id, @Valid Customer customer){
        customerService.updateCustomer(id, customer);
        return "updateCustomer";
    }

    @RequestMapping(value = "/admin/deleteCustomer/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCustomer(@PathVariable(name = "id") Long id){
        customerService.deleteCustomer(id);
        return "deleteCustomer";
    }
}
