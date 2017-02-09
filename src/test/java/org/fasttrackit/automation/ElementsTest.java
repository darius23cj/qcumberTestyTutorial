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

    private CheckBox stopProcessCheckBox = new CheckBox().setElPath("/html/body/form[1]/div[3]/label/input");
    private CheckBox labelWithEnterCheckBox = new CheckBox().setElPath("/html/body/form[1]/div[4]/label/input");
    private WebLocator dropDown = new WebLocator().setClasses("pull-left");
    private WebLocator dropDownOption = new WebLocator().setElPath("/html/body/form[1]/div[2]/div/div/ul/li[2]/a/span");
    private WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    private WebLocator labelWithEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);




    @Test
    public void checkBox() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");


        stopProcessCheckBox.click();
        labelWithEnterCheckBox.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        labelWithEnterLabel.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        labelWithEnterLabel.click();

        assertThat("Stop the process is not selected",stopProcessCheckBox.isSelected(), is(true));
        assertThat("Label with Enter is not selected",labelWithEnterCheckBox.isSelected(), is(true));

        dropDown.click();
        dropDownOption.click();

    }

}
