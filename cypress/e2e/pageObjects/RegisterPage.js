import BasePage from "./BasePage";
class RegisterPage extends BasePage{
    static get url(){
        return "http://localhost:8080/";
    }

    static get AccountDropDown(){
       return cy.get('[role="button"]');
    }

    static get Register(){
        return cy.get('[href="/register"]');
    }

    static get Name(){
        return cy.get('#name');
    }

    static get Surname(){
        return cy.get('#surname');
    }

    static get Email(){
        return cy.get('#email');
    }

    static get PhoneNr(){
        return cy.get('#phoneNumber');
    }

    static get Address(){
        return cy.get('#address');
    }

    static get Password(){
        return cy.get('#password');
    }

    static get Submit(){
        return cy.get("[type='submit']");
    }
}
export default RegisterPage