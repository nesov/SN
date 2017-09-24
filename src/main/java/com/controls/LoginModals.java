package com.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginModals {

    protected WebDriver driver;

    private FirstStepScreen firstStepScreen;

    private SecondStepScreen secondStepScreen;

    public LoginModals(WebDriver driver){
        this.driver = driver;
        firstStepScreen = new FirstStepScreen(driver);
//      secondStepScreen = new SecondStepScreen(driver);
        PageFactory.initElements(driver, this);

    }

    public FirstStepScreen getFirstStepScreen() {
        return firstStepScreen;
    }

    public SecondStepScreen getSecondStepScreen() {
        return secondStepScreen;
    }

    private class FirstStepScreen {

        @FindBy (className = "btnclose")
        private WebElement closeBtn;

        @FindBy (xpath = "//*[@id=\"username\"]")
        private WebElement emailInputField;

        @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[3]/button")
        private WebElement submitBtn;

        @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[3]/a")
        private WebElement forgotPasswordBtn;

        @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[2]/div/div[2]/label/div/span[2]")
        private WebElement errorMessage;

        FirstStepScreen(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

        public WebElement getCloseBtn() {
            return closeBtn;
        }

        public WebElement getEmailInputField() {
            return emailInputField;
        }

        public WebElement getForgotPasswordBtn() {
            return forgotPasswordBtn;
        }

        public WebElement getSubmitBtn() {
            return submitBtn;
        }

        @Step
        public FirstStepScreen setCursorIntoEmailField(){
            getEmailInputField().click();
            return this;
        }

        @Step
        public FirstStepScreen clickCloseBtn(){
            getCloseBtn().click();
            return this;
        }

        @Step
        public void clickForgotPasswordLink(){
            getForgotPasswordBtn().click();
        }

        @Step
        public SecondStepScreen clickToNextBtn() throws  NullPointerException{

            SecondStepScreen secondStepScreen = new SecondStepScreen();

            getSubmitBtn().click();

            if (secondStepScreen != null)
                return secondStepScreen;

            return null;
        }
    }


    private class SecondStepScreen {
    }
}
