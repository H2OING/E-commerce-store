
import BasePage from "./BasePage";
class ProductPage extends BasePage{

   static get OneProduct(){
    return cy.get('[href="/product/3"]');
   }

   static get Quantity(){
    return cy.get('[class="row"]');
   }

   static get SubmitButton(){
    return cy.get('[type="submit"]');
   }
    
}
export default ProductPage