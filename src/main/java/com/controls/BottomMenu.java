package com.controls;

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

    @Step
    public void clickToExplore() {
        explore.click();
    }

    @Step
    public void clickToChat() {
        chat.click();
    }

    @Step
    public void clickToMail() {
        mail.click();
    }

    @Step
    public void clickToAppMode() {
        appmode.click();
    }

    public WebElement getAppmodeElement() {
        return appmode;
    }

    public WebElement getChatElement() {
        return chat;
    }

    public WebElement getExploreElement() {
        return explore;
    }

    public WebElement getMailElement() {
        return mail;
    }
}
