package app.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexnesov on 21/03/2017.
 */
public class BottomMenu {

    private final WebDriver driver;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/footer/div/a[1]")
    private WebElement explore;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/footer/div/a[2]")
    private WebElement chat;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/footer/div/a[3]")
    private WebElement mail;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/footer/div/a[4]")
    private WebElement appmode;

    public BottomMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step ("Кликаем на елемент боттом бара Explore")
    public void clickToExplore() {
        getExploreElement().click();
    }

    @Step ("Кликаем на елемент боттом бара Chat")
    public void clickToChat() {
        getChatElement().click();
    }

    @Step ("Кликаем на елемент боттом бара Mail")
    public void clickToMail() {
        getMailElement().click();
    }

    @Step ("Кликаем на елемент боттом бара App Mode")
    public void clickToAppMode() {
        getAppmodeElement().click();
    }

    private WebElement getAppmodeElement() {
        return appmode;
    }

    private WebElement getChatElement() {
        return chat;
    }

    private WebElement getExploreElement() {
        return explore;
    }

    private WebElement getMailElement() {
        return mail;
    }
}
