
import BasePage from "./BasePage";
class CheckoutPage extends BasePage{

    static get CardNumber(){
        return cy.get("[id='number']");
    }

    static get CardName(){
        return cy.get("[id='ownerName']");
    }

    static get CardDate(){
        return cy.get("[id='date']");
    }

    static get CardCv(){
        return cy.get("[id='cvvCode']")
    }

    static get Terms(){
        return cy.get("[id='tnc']");
    }

    static get Subscribe(){
        return cy.get("[id='subscribe']");
    }

    static get Submit(){
        return cy.get("[type='submit']");
    }

}
export default CheckoutPage