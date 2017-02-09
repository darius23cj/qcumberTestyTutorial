package org.fasttrackit.automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

/**
 * Created by dserdean on 09.02.2017.
 */
public class ElementsView {
    public WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    public WebLocator labelWithEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);

    public CheckBox stopProcessCheckBox = new CheckBox(stopProcessLabel);
    public CheckBox labelWithEnterCheckBox = new CheckBox(labelWithEnterLabel);

    public WebLocator dropDown = new WebLocator().setClasses("pull-left");
    public WebLocator dropDownOption = new WebLocator().setElPath("/html/body/form[1]/div[2]/div/div/ul/li[2]/a/span");

    public static void main(String[] args) {
        ElementsView test = new ElementsView();
        System.out.println(test.stopProcessLabel.getSelector());
        System.out.println(test.labelWithEnterLabel.getSelector());
        System.out.println(test.stopProcessCheckBox.getSelector());
        System.out.println(test.labelWithEnterCheckBox.getSelector());
    }
}
