
import LoginPage from "./pageObjects/LoginPage";
import RegisterPage from "./pageObjects/RegisterPage"
context("Accenstore page", () =>{

  context("Accenstore Homepage", () =>{
    beforeEach(()=>{
      RegisterPage.visit(); //visits homePage
   
    });
    /*it("Register", () => {
      RegisterPage.AccountDropDown.contains('Account').click()
      RegisterPage.Register.click();
      RegisterPage.Name.type('John');
      RegisterPage.Surname.type('Wick');
      const x = Math.floor(Math.random()*10);
      const y = (Math.random());
      let emails = 'John'+x+'@gmail.com';
      RegisterPage.Email.type(emails);
      RegisterPage.PhoneNr.type('27273737');
      let passwords = 'Oqwertyuio1!';
      RegisterPage.Address.type('Pumpik street '+y);
      RegisterPage.Password.type(passwords);
      RegisterPage.Submit.click();
      
      
    });*/

    it("Login",() =>{
      LoginPage.LoginHere.click();
      LoginPage.Username.type(emails);
      LoginPage.Password.type(passwords);
      LoginPage.SubmitButton.click();
    });
  });


});

