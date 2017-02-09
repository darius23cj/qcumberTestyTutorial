package org.fasttrackit.automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ElementsTest extends TestBase {

    private LoginView loginView = new LoginView();
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
}
