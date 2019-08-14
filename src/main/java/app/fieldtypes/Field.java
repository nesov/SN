package app.fieldtypes;

import app.viewtypes.navigationviews.menuitems.Clickable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Field implements Clickable,Typable {

    private WebDriver driver;
    private WebElement element;

    private String title;
    private boolean isHidden = false;
    private String xpath;

    public Field(String title, String xpath){
        this.title = title;
        this.xpath = xpath;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public void click(){
        element.click();
    }

    @Override
    public void type(String text) {
        element.sendKeys(text);

    }
}
