package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {
        System.out.println("Ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        // System.out.println("Enter email");
        emailField.sendKeys("eu@fast.com");
        //System.out.println("Enter password");
        passField.sendKeys("eu.pass");
        //System.out.println("Click on login");
        loginBtn.click();


        try {
            // driver.findElement(By.id("loginButton")).click()
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            // System.out.println("Click on logout");
            logoutBtn.click();


        } catch (NoSuchElementException er) {
            Assert.fail("Could not Login. Logout button was not found");
        }
    }
}