package org.fasttrackit.automation;

import com.sdl.selenium.bootstrap.button.Upload;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ElementsTest extends TestBase {

    private ElementsView page = new ElementsView();


    @Test
    public void checkBox() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");


        page.stopProcessCheckBox.click();
        page.labelWithEnterCheckBox.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.labelWithEnterLabel.click();

        Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.labelWithEnterLabel.click();

        assertThat("Stop the process is not selected", page.stopProcessCheckBox.isSelected(), is(true));
        assertThat("Label with Enter is not selected", page.labelWithEnterCheckBox.isSelected(), is(true));


    }

    @Test
    public void dropDownTest() {

        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        page.autoOption.click();
        page.manualOption.click();
    }

    @Test

    public void dropDownComponentTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        DropDown dropDown = new DropDown();
        dropDown.select("Manual");

        Utils.sleep(2000);
        dropDown.select("Auto");

        MultiSelect source = new MultiSelect().setClasses("multiselect");
        {
            source.select(" Tomatoes", " Mozzarella");

            DatePicker datePiker = new DatePicker();

            datePiker.setDate("9", "Apr", "2017");
            Utils.sleep(1000);
            datePiker.select("11/03/2016", "dd/MM/yyyy", Locale.ENGLISH);
        }
    }

    private Form form = new Form("Form Title");
    private UploadFile uploadFile = new UploadFile(form);

    @Test

    public void uploadTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

       uploadFile.upload(PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\feature\\login\\login.feature");
    }


}
