package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.Bill_Service;

import javax.validation.Valid;

import com.example.demo.Service.Cart_Service;
import com.example.demo.Service.Customer_Order_Service;
import com.example.demo.Service.Web_User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class Bill_Controller {
    @Autowired
    Bill_Service billService;
    @Autowired
    Web_User_Service webUserService;
    @Autowired
    Customer_Order_Service customerOrderService;

    @GetMapping("/admin/bills")
    public String getAllBills(Model model){
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }
    @GetMapping("/user/checkout")
    public String getBillingForm(Model model){
        Web_User user = webUserService.getLoggedInWebUser();
        //model.addAttribute("order", user.getCart().getOrder());
        model.addAttribute("order", new Customer_Order(Order_Status.HOLD, new Date(), null, webUserService.getLoggedInWebUser().getCart()));
        model.addAttribute("bill", new Bill());
        model.addAttribute("paymentMethodCreditCard", Payment_Method.CREDIT_CARD);
        model.addAttribute("paymentMethodPaypal", Payment_Method.PAYPAL);
        model.addAttribute("cart", webUserService.getLoggedInWebUser().getCart());
        return "checkout";
    }

    @GetMapping(value = "/admin/bill/{id}")
    public String getBill(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("bill", billService.getBillById(id));
        return "bill";
    }
    @PostMapping("/user/createBill")
    public String createCustomerOrderBill(@ModelAttribute("bill") Bill bill){
        Web_User user = webUserService.getLoggedInWebUser();
        Customer_Order order = new Customer_Order(Order_Status.NEW, new Date(), null, user.getCart());
        bill.setOrder(order);
        bill.setPaymentDate(new Date());
        order.setBill(bill);
        billService.createBill(bill);
        customerOrderService.createCustomerOrder(order);
        return "redirect:/";
    }

    @PostMapping(value = "/admin/createBill")
    public String createBill(@Valid Bill bill, BindingResult result){
    	if(!result.hasErrors()) {
        billService.createBill(bill);
        return "redirect:/bills";
    	}else {
    		return "error-page";
    	}
    }
    
    @GetMapping(value = "/admin/createBill")
    public String getCreatedBill(Model model, Bill bill) {
    	Bill bills = new Bill();
    	model.addAttribute("createdBill", bills);
    	return "createBill";
    }

    @PutMapping(value = "/admin/updateBill/{id}")
    public String updateBill(@PathVariable(name = "id") Long id,@Valid Bill bill, BindingResult result){
        if(!result.hasErrors()) {
    	billService.updateBill(id, bill);
        return "redirect:/bills";
        }else {
        	return "error-page";
        }
    }
    
    @GetMapping(value = "/admin/updateBill/{id}")
    public String getUpdatedBill(@PathVariable(name = "id") Long id,Model models) {
    	models.addAttribute("updatedBill", billService.getBillById(id));
		return "updateBill";
    }

    @RequestMapping(value = "/admin/deleteBill/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteBill(@PathVariable(name = "id") Long id, Model model){
    	try {
        model.addAttribute("DeletedBill", billService.deleteBill(id));
        return "bills";
    	} catch (Exception e) {
    		
    	return "redirect:/error-page";
		
    	}
    }
}
