package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {
    private LoginPage loginPage;
    private ChangePasswordPage page;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        page = PageFactory.initElements(driver, ChangePasswordPage.class);
    }


    @Test
    public void changePasswordWithInvalidCurrentPassword() {
        openPage();
        page.changePassword("wrong.pass", "new.pass", "new.pass");

        assertThat(page.getStatusMessage(), is("Your preview password is incorrect!"));


    }

    @Test
    public void changePasswordWithInvalidRepeatPassword() {
        openPage();
        page.changePassword("eu.pass", "new1.pass", "new.pass");

        assertThat(page.getStatusMessage(), is("Password does not match the confirm password!"));

    }

    @Test
    public void successfullyChangePassword() {
        openPage();
        page.changePassword("eu.pass", "new1.pass");

        assertThat(page.getStatusMessage(), is("Your password has been successfully changed."));


    }

    private void openPage() {
        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        com.sdl.selenium.web.utils.Utils.sleep(1000);
    }

}
