package org.fasttrackit.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.sql.Driver;


public class ChangePasswordPage {
        @FindBy(name = "password")
        private WebElement currentPasswordField;

        @FindBy(name = "newPassword")
        private WebElement newPasswordField;

        @FindBy(name = "newPasswordRepeat")
        private WebElement repeatPasswordField;

        @FindBy(xpath = "//*[@id='preferences-win']//button[normalize-space(text())='Save']")
        private WebElement saveBtn;

        @FindBy(className = "status-msg")
        private  WebElement statusMsg;


        public void changePassword(String currentPassword,String newPass){
               changePassword(currentPassword,newPass,newPass);

        }






        public void changePassword(String currentPassword,String newPass, String newPassRepeat){
                currentPasswordField.sendKeys(currentPassword);
                newPasswordField.sendKeys(newPass);
                repeatPasswordField.sendKeys(newPassRepeat);
                saveBtn.click();

        }

        public String getStatusMessage() {
                String msg =statusMsg.getText();
                System.out.println(msg);
                return msg;
        }
}
