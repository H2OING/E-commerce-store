
import BasePage from "./BasePage";
class CartPage extends BasePage{

    static get CartIcon(){
        return cy.get("[class='bi bi-cart']");
    }

    static get Cart(){
        return cy.get("[href='/user/cart']");
    }

    static get ItemValidation(){
        return cy.get('[data-th="Product"]');
    }

    static get QuantityValidation(){
        return cy.get('[type="number"]');
    }

    static get Checkout(){
        return cy.get('[href="/user/checkout"]');
    }
}
export default CartPage