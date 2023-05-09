package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests{
    

    @Test
    public void checkIfUserCanLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToLoginUrl();
        loginPage.login(email, password);
        homePage.checkIfUserIsOnHomePage(); // login sa validnim kredencijalima
    }

    @Test 
    public void checkIfUserCanLogOut (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToLoginUrl();
        loginPage.login(email, password);

        homePage.clickOnExpand();
        homePage.clickOnLogout();
        homePage.checkIfUserCanLogout(); // logout ***test ponekad prodje, ponekad ne. Welcome poruka u gornjem desnom uglu nekad
                                         // personalizovana, a nekad ne, u zavisnosti od toga nekad se otvori expand, nekad ne
       }
}
