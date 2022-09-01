package com.example.demo.Controller;

import com.example.demo.Model.Customer_Order;
import com.example.demo.Service.Customer_Order_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Customer_Order_Controller {
/*
    @Autowired
    Customer_Order_Service customerOrderService;

    @GetMapping("PlaceholderMapping3")
    public String getAllCustomerOrders(Model model){
        model.addAttribute("customerOrders", customerOrderService.getAllCustomerOrders());
        return "customerOrders";
    }

    @GetMapping(value = "/{id}")
    public String getCustomerOrder(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("customerOrder", customerOrderService.getCustomerOrderById(id));
        return "customerOrder";
    }

    @PostMapping(value = "PlaceholderMapping4")
    public String createCustomerOrder(@Valid Customer_Order customerOrder){
        customerOrderService.createCustomerOrder(customerOrder);
        return "createCustomerOrder";
    }

    @PutMapping(value = "PlaceholderMapping5")
    public String updateCustomerOrder(@PathVariable(name = "id") Long id,@Valid Customer_Order customerOrder){
        customerOrderService.updateCustomerOrder(id, customerOrder);
        return "updateCustomerOrder";
    }

    @RequestMapping(value = "PlaceholderMapping6", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCustomerOrder(@PathVariable(name = "id") Long id){
        customerOrderService.deleteCustomerOrder(id);
        return "deleteCustomerOrder";
    }

 */
}
