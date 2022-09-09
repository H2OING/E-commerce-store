package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@Controller
public class Bill_Controller {
    @Autowired
    Bill_Service billService;
    @Autowired
    Web_User_Service webUserService;
    @Autowired
    Customer_Order_Service customerOrderService;

    @Autowired
    Product_Service productService;

    CreditCardValidation creditCardValidationGlobal = new CreditCardValidation();

    @GetMapping("/admin/bills")
    public String getAllBills(Model model){
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }
    @GetMapping(value = "/user/checkout")
    public String getBillingForm(Model model){
        Web_User user = webUserService.getLoggedInWebUser();
        //model.addAttribute("order", user.getCart().getOrder());
        model.addAttribute("order", new Customer_Order(Order_Status.HOLD, new Date(), null, webUserService.getLoggedInWebUser().getCart()));
        model.addAttribute("cart", webUserService.getLoggedInWebUser().getCart());
        model.addAttribute("creditCard", creditCardValidationGlobal);
        model.addAttribute("paypal", new PaypalValidation());
        return "checkout";
    }

    @GetMapping(value = "/admin/bill/{id}")
    public String getBill(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("bill", billService.getBillById(id));
        return "bill";
    }

    @PostMapping("/user/checkout")
    public String createCustomerOrderBill(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("bill") Bill bill,
                                          @ModelAttribute("creditCard") @Valid CreditCardValidation creditCardValidation, BindingResult resultCreditCard,
                                          @ModelAttribute("paypal") @Valid PaypalValidation paypalValidation, BindingResult resultPaypal){
        if(resultCreditCard.hasErrors() || resultPaypal.hasErrors()){
            model.addAttribute("order", new Customer_Order(Order_Status.HOLD, new Date(), null, webUserService.getLoggedInWebUser().getCart()));
            model.addAttribute("cart", webUserService.getLoggedInWebUser().getCart());
            return "checkout";
        } else {
            Customer_Order order = new Customer_Order(Order_Status.NEW, new Date(), null, cart);

            bill.setOrder(order);
            bill.setPaymentDate(new Date());

            order.setBill(bill);
            billService.createBill(bill);

            customerOrderService.createCustomerOrder(order);
            return "redirect:/";
        }
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
