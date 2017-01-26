package org.fasttrackit.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ChangePasswordPage {
        @FindBy(name = "password")
        private WebElement currentPasswordField;

        @FindBy(name = "newPassword")
        private WebElement newPasswordField;

        @FindBy(name = "newPasswordRepeat")
        private WebElement repeatPasswordField;


        public void changePassword(String currentPassword,String newPass, String newPassRepeat){
                currentPasswordField.sendKeys(currentPassword);
                newPasswordField.sendKeys(newPass);
                repeatPasswordField.sendKeys(newPassRepeat);
        }

}
