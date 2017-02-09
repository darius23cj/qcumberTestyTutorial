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

    public WebLocator autoOption = new WebLocator().setText("Auto").setClasses("filter-option");
    public WebLocator menuDropDown = new WebLocator().setClasses("dropdown-menu");
    public WebLocator manualOption = new WebLocator().setContainer(menuDropDown).setText("Manual");

    public static void main(String[] args) {
        ElementsView test = new ElementsView();
        System.out.println(test.stopProcessLabel.getSelector());
        System.out.println(test.labelWithEnterLabel.getSelector());
        System.out.println(test.stopProcessCheckBox.getSelector());
        System.out.println(test.labelWithEnterCheckBox.getSelector());
        System.out.println(test.autoOption.getSelector());
    }
}
