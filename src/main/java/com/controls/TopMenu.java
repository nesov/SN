package com.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexnesov on 21/03/2017.
 */

public class TopMenu{

    private WebDriver driver;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/a")
    private WebElement logo;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[1]/uni-carousel/div/div/div[3]/div/s-style/div/a")
    private WebElement events;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[1]/uni-carousel/div/div/div[3]/div/s-style/div/a")
    private WebElement companies;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[1]/uni-carousel/div/div/div[4]/div/s-style/div/a")
    private WebElement products;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[1]/uni-carousel/div/div/div[5]/div/s-style/div/a")
    private WebElement people;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[1]/uni-carousel/div/div/div[6]/div/s-style/div/a")
    private WebElement news;

    public TopMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step ("Кликаем на логотип")
    public TopMenu clickToLogo() throws InterruptedException {
        logo.click();
        return this;
    }

    @Step ("Кликаем на Собития")
    public TopMenu clickToEvents() throws InterruptedException{
        events.click();
        return this;
    }

    @Step ("Кликаем на Компании")
    public TopMenu clickToCompanies() throws InterruptedException {
        companies.click();
        return this;
    }

    @Step ("Кликаем на Продукты")
    public TopMenu clickToProducts()throws InterruptedException{
        products.click();
        return this;
    }

    @Step ("Кликаем на Людей")
    public TopMenu clickToPeople() throws InterruptedException {
        people.click();
        return this;
    }

    @Step ("Кликаем на Новости")
    public TopMenu clickToNews() throws InterruptedException {
        news.click();
        return this;
    }
}
