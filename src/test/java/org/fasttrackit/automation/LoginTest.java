package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginTest extends TestBase {

    //private LoginPage page;
    private LoginView page = new LoginView();

   // public LoginTest() {
        //page = PageFactory.initElements(driver, LoginPage.class);
  //  }

    @Test
    public void validLoginTest() {
        openBrowser();

        page.login("eu@fast.com", "eu.pass");

        try {
            // driver.findElement(By.id("loginButton")).click()
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            // System.out.println("Click on logout");
            logoutBtn.click();


        } catch (NoSuchElementException er) {
            Assert.fail("Could not Login. Logout button was not found");
        }
    }


    @Test
    public void invalidPasswordTest() {
        openBrowser();

        page.login("eu@fast.com", "eu.pass1");


        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //doua tipuri de assert
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is("Invalid user or password!"));

    }



}