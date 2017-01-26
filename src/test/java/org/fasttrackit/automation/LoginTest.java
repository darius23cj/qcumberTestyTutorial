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

    private LoginPage loginPage;

    public LoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void validLoginTest() {
        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

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

        loginPage.login("eu@fast.com", "eu.pass1");


        WebElement errorElement = driver.findElement(By.className("error-msg"));
        System.out.println(errorElement.getText());
        //doua tipuri de assert
        //Assert.assertEquals(errorElement.getText(), "Invalid user or password!");
        assertThat(errorElement.getText(), is("Invalid user or password!"));

    }

    @Test
    public void changePasswordWithInvalidCurrentPassword() {
        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        changePasswordFields("eu.pass", "new.pass", "new.pass");

    }

    private void changePasswordFields(String currentPassword, String newPassword, String confirmPassword) {

        WebElement currentPasswordField = driver.findElement(By.name("password"));
        WebElement newPasswordField = driver.findElement(By.name("newPassword"));
        WebElement repeatPasswordField = driver.findElement(By.name("newPasswordRepeat"));


        currentPasswordField.sendKeys(currentPassword);
        newPasswordField.sendKeys(newPassword);
        repeatPasswordField.sendKeys(confirmPassword);
    }

    private void openBrowser() {
        System.out.println("Ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        //ca sa folosim multiple url uri
        //driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");


    }
}