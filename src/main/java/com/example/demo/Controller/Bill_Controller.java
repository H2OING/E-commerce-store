package com.example.demo.Controller;

import com.example.demo.Model.Bill;
import com.example.demo.Service.Bill_Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class Bill_Controller {
    @Autowired
    Bill_Service billService;

    @GetMapping("/bills")
    public String getAllBills(Model model){
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }

    @GetMapping(value = "/bill/{id}")
    public String getBill(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("bill", billService.getBillById(id));
        return "bill";
    }

    @PostMapping(value = "/createBill")
    public String createBill(@Valid Bill bill, BindingResult result){
    	if(!result.hasErrors()) {
        billService.createBill(bill);
        return "redirect:/bills";
    	}else {
    		return "error-page";
    	}
    }
    
    @GetMapping(value = "/createBill")
    public String getCreatedBill(Model model, Bill bill) {
    	Bill bills = new Bill();
    	model.addAttribute("createdBill", bills);
    	return "createBill";
    }

    @PutMapping(value = "/updateBill/{id}")
    public String updateBill(@PathVariable(name = "id") Long id,@Valid Bill bill, BindingResult result){
        if(!result.hasErrors()) {
    	billService.updateBill(id, bill);
        return "redirect:/bills";
        }else {
        	return "error-page";
        }
    }
    
    @GetMapping(value = "/updateBill/{id}")
    public String getUpdatedBill(@PathVariable(name = "id") Long id,Model models) {
    	models.addAttribute("updatedBill", billService.getBillById(id));
		return "updateBill";
    }

    @RequestMapping(value = "/deleteBill/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteBill(@PathVariable(name = "id") Long id, Model model){
    	try {
        model.addAttribute("DeletedBill", billService.deleteBill(id));
        return "bills";
    	} catch (Exception e) {
    		
    	return "redirect:/error-page";
		
    	}
    }
}
