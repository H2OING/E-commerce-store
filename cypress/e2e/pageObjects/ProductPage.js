
import BasePage from "./BasePage";
class ProductPage extends BasePage{

   static get OneProduct(){
    return cy.get("#product-2");
   }

   static get Quantity(){
    return cy.get('[placeholder="quantity"]');
   }

   static get SubmitButton(){
    return cy.get('[type="submit"]');
   }
    
}
export default ProductPage