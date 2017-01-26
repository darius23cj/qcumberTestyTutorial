package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {
    private LoginPage loginPage;
    private  ChangePasswordPage page;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        page = PageFactory.initElements(driver, ChangePasswordPage.class);
    }


    @Test
    public void changePasswordWithInvalidCurrentPassword() {
        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        changePasswordFields("eu.pass", "new.pass", "new.pass");


    }


    private void changePasswordFields(String currentPassword, String newPassword, String confirmPassword) {



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.changePassword("wrong.pass", "new.pass", "new.pass");

    }
}
