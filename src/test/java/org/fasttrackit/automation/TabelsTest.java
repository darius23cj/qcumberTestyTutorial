package org.fasttrackit.automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TabelsTest extends TestBase {

    private ElementsView page = new ElementsView();
    Table table = new Table();


    @Test
    public void selectTableRowTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");


        //diferite versiuni de identificare , testie cu weblocator si WebElement

        // WebElement checkbox = driver.findElement(By.xpath("//table//input"));
        WebLocator checkbox = new WebLocator().setElPath("//table//input");

        checkbox.click();

    }

    @Test
    public void selectRowByEmailSetup(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

    }

    @Test (dependsOnMethods = "selectRowByEmailSetup",dataProvider = "emailsProvider")
    public void selectRowByName(String email) {



        Row row = table.getRow(new Cell(4, email));

        CheckBox checkBox = new CheckBox(row);

        checkBox.click();

//        WebLocator tableLocator = new WebLocator().setTag("table");
//        WebLocator firstNameLocator = new WebLocator().setText("Bob");
//        WebLocator lastNameLocator = new WebLocator().setText("Smith");
//        WebLocator rowLocator = new WebLocator(tableLocator).setTag("tr").setChildNodes(firstNameLocator,lastNameLocator);
//        WebLocator checkboxLocator=new WebLocator().setContainer(rowLocator).setTag("input");
//        checkboxLocator.click();



    }
@DataProvider
    public static Object[][] emailsProvider(){
        return new  Object[][]{
                {"nickwhite@mail.com"},
                {"davidmiller@mail.com"}
        };
    }
}
