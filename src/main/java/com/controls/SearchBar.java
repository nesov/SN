package com.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

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

    @FindBy (xpath = "")
    private WebElement plusOption;

    @FindBy (xpath = "")
    private WebElement modeIcon;

    @Step ("Вводим строку запроса в поле поиска")
    public void typeTextIntoSearch(String text){
        searchInput.clear();
        searchInput.sendKeys(text);
        searchInput.click();
    }

    @Step ("Кликаем на кнопку переключения режима просмотра")
    public void clickToViewModeIcon(){
        modeIcon.click();
    }

    enum ViewModeOptions{

        LIST_VIEV,
        GRID_VIEW,
        LOCATION_VIEW
    }

}
