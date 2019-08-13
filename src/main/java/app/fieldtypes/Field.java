package app.fieldtypes;

import app.viewtypes.navigationviews.menuitems.Clickable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Field implements Clickable,Typable {

    private WebDriver driver;
    private WebElement element;

    private String title;
    private boolean isHidden;
    private String xpath;

    public Field(String title, String xpath){
        this.title = title;
        this.xpath = xpath;

    }

    public void click(){
        element.click();
    }

    @Override
    public void type(String text) {
        element.sendKeys(text);

    }
}
