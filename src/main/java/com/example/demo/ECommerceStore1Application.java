package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceStore1Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceStore1Application.class, args);
	}
	/*
	@Bean
	public CommandLineRunner runner(Bill_Repository BRepo, Cart_Repository CRepo, Customer_Order_Repository CORepo, Customer_Repository CuRepo, Product_Repository ProdRepo, Web_User_Repository WRepo, Category_Repository catRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				//Web_User user = new Web_User("Tyson@gmail.com", "12345", Role.CUSTOMER);
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

	 */

}
