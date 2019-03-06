package app.controls;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexnesov on 21/03/2017.
 */

public class TopMenu {

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

    public WebElement getCompanies() {
        return companies;
    }
    public WebElement getEvents() {
        return events;
    }
    public WebElement getLogo() {
        return logo;
    }
    public WebElement getNews() {
        return news;
    }
    public WebElement getPeople() {
        return people;
    }
    public WebElement getProducts() {
        return products;
    }

//    @Step ("Кликаем на логотип")
    public TopMenu clickToLogo(){
        try{
            logo.click();
            return this;
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
        return null;
    }

//    @Step ("Кликаем на Собития")
    public TopMenu clickToEvents() {
        try {
            events.click();
            return this;
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
        return null;
    }

//    @Step ("Кликаем на Компании")
    public TopMenu clickToCompanies() {
        companies.click();
        return this;
    }

//    @Step ("Кликаем на Продукты")
    public TopMenu clickToProducts(){
        products.click();
        return this;
    }

//    @Step ("Кликаем на Людей")
    public TopMenu clickToPeople(){
        people.click();
        return this;
    }

//    @Step ("Кликаем на Новости")
    public TopMenu clickToNews() {
        news.click();
        return this;
    }
}
