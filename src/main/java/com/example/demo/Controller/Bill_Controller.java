package com.example.demo.Controller;

import com.example.demo.Model.Bill;
import com.example.demo.Service.Bill_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String createBill(Bill bill){
        billService.createBill(bill);
        return "createBill";
    }

    @PutMapping(value = "/updateBill/{id}")
    public String updateBill(@PathVariable(name = "id") Long id, Bill bill){
        billService.updateBill(id, bill);
        return "updateBill";
    }

    @RequestMapping(value = "/deleteBill/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteBill(@PathVariable(name = "id") Long id){
        billService.deleteBill(id);
        return "deleteBill";
    }
}
