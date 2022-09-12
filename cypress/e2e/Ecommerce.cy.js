
import LoginPage from "./pageObjects/LoginPage";
import RegisterPage from "./pageObjects/RegisterPage";
import ProductPage from "./pageObjects/ProductPage";
import CartPage from "./pageObjects/CartPage";
import CheckoutPage from "./pageObjects/CheckoutPage";
Cypress.config("waitAfterEachCommand", 4000);
//Cypress.config('experimentalSessionAndOrigin', true);

Cypress.Commands.add('login', (username, password) => {
  //cy.session([username, password], () => {
  cy.visit('http://localhost:8080/login')
  cy.get("[name='username']").type(emails)
  cy.get("[name='password']").type(passwords)
  cy.get("[type='submit']").click()
 // cy.url().should('contain', '/login-successful')
 // })
})

const x = Math.floor(Math.random()*1000);
const y = (Math.random());
let emails = 'John'+x+'@gmail.com';
let passwords = 'Oqwertyuio1!';
context("Accenstore page", () =>{

  context("Accenstore Homepage, Register,Login", () =>{
    beforeEach(()=>{
      RegisterPage.visit(); //visits homePage
      
    });
    it("Register", () => {
      RegisterPage.AccountDropDown.contains('Account').click()
      RegisterPage.Register.click();
      RegisterPage.Name.type('John');
      RegisterPage.Surname.type('Wick');
      // const x = Math.floor(Math.random()*100);
      // const y = (Math.random());
      // let emails = 'John'+x+'@gmail.com';
      RegisterPage.Email.type(emails);
      RegisterPage.PhoneNr.type('27273737');
      //let passwords = 'Oqwertyuio1!';
      RegisterPage.Address.type('Pumpik street '+y);
      RegisterPage.Password.type(passwords);
      cy.wait(1500);
      RegisterPage.Submit.click();
      
      context("Login",() =>{
        cy.wait(1500);
        LoginPage.LoginHere.contains("Login here").click();
        LoginPage.Username.type(emails);
        LoginPage.Password.type(passwords);
        LoginPage.SubmitButton.click();
        cy.wait(1500);
      });
      
    });
  });

  context("Accenstore Homepage, AddPRoduct, Cart, Checkout", () =>{
    beforeEach(()=>{
      cy.login(emails,passwords);
      RegisterPage.visit();
    });
    it("AddProduct",() =>{
      cy.wait(1500);
      ProductPage.OneProduct.click()
      ProductPage.Quantity.should('contain', '1') ;
      ProductPage.SubmitButton.click();
      cy.wait(1500);
    //});

   // it("CartPage, CheckoutPAge",() =>{
      //CartPage.CartIcon.click();
      //cy.wait(1500);
      CartPage.Cart.contains('Shop Now').click();
      CartPage.ItemValidation.should('contain','Samsung S21');
      CartPage.QuantityValidation.should('have.attr', 'value', '1') ;
      cy.wait(1500);
      CartPage.Checkout.click();
    //});
      cy.wait(2000);
    //it("CheckoutPAge",() =>{
      CheckoutPage.CardNumber.type("1456894623841569");
      CheckoutPage.CardName.type("William Shakespear");
      CheckoutPage.CardDate.type("03/25");
      CheckoutPage.CardCv.type("123");
      CheckoutPage.Terms.click();
      CheckoutPage.Subscribe.click();
      CheckoutPage.Submit.click();
      
    });
  });


});

