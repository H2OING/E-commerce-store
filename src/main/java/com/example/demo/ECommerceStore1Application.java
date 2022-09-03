package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Model.Role;
import com.example.demo.Model.Web_User;
import com.example.demo.Repository.Bill_Repository;
import com.example.demo.Repository.Cart_Repository;
import com.example.demo.Repository.Category_Repository;
import com.example.demo.Repository.Customer_Order_Repository;
import com.example.demo.Repository.Product_Repository;
import com.example.demo.Repository.Web_User_Repository;

@SpringBootApplication
public class ECommerceStore1Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceStore1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(Bill_Repository BRepo, Cart_Repository CRepo, Customer_Order_Repository CORepo, Product_Repository ProdRepo, Web_User_Repository WRepo, Category_Repository catRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				//Web_User user = new Web_User("Markuss","Karklins", "markuss@gmail.com", "2282828" ,"maja", "12345", Role.ROLE_ADMIN);
				//user.setPasswordHashed(user.getPassword());
				//WRepo.save(user);
				//Customer customer = new Customer("Mike", "Tyson", "29857483", "Pumpkin Street",user );
				//CuRepo.save(customer);
				//Category category = new Category("Electronics", "Phone tech");
				//catRepo.save(category);
				//Product prod = new Product("Samsung S22", "New, 5G", 1, new BigDecimal(450), null,category);
				//ProdRepo.save(prod);
				//Cart cart = new Cart(new BigDecimal(450), false, customer, new ArrayList<>(Arrays.asList(prod)));
				//CRepo.save(cart);
				//Customer_Order cOrder = new Customer_Order(Order_Status.NEW, new Date(), new Date(), cart);
				//CORepo.save(cOrder);
				//Bill bill = new Bill(Payment_Method.BANK_TRANSFER, new Date(), 45567, cOrder);
				//BRepo.save(bill);
			}
		};
		
	}

	 

}
