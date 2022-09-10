import BasePage from "./BasePage";
class LoginPage extends BasePage{

    static get LoginHere(){
        return cy.get("[href='/login']");
    }

    static get Username(){
        return cy.get("[name='username']");
    }

    static get Password(){
        return cy.get("[name='password']");
    }

    static get SubmitButton(){
        return cy.get("[type='submit']");
    }


}
export default LoginPage