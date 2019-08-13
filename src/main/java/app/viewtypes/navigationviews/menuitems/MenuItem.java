package app.viewtypes.navigationviews.menuitems;

import app.fieldtypes.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuItem extends Field implements Clickable{

    private WebDriver driver;
    private WebElement element;
    private String xpath;
    private String title;
    boolean hidden = false;

    MenuItem (String title,String xpath){

        super(title,xpath);

        element = driver.findElement(By.xpath(xpath));
        this.title = title;
    }

    public void click(){
        super.click();
    }

}
