package com.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexnesov on 27/03/2017.
 */
public class SearchBar {

    private final WebDriver driver;

    public SearchBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"event-search\"]")
    private WebElement searchInput;

    @FindBy (xpath = "MODE_ICON")
    private WebElement modeIcon;

    @Step
    public void typeTextIntoSearch(String text){
        searchInput.clear();
        searchInput.sendKeys(text);
        searchInput.click();
    }

    @Step
    public void clickToViewModeIcon(){
        modeIcon.click();
    }

}
