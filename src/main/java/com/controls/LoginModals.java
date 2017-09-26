package com.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginModals {

    private WebDriver driver;

    private LoginModals.FirstStepScreen firstStepScreen;

    private LoginModals.SecondStepScreen secondStepScreen;

    public LoginModals(WebDriver driver){
        this.driver = driver;
        firstStepScreen = new FirstStepScreen(driver);
        secondStepScreen = new SecondStepScreen(driver);
        PageFactory.initElements(driver, this);
    }

    public FirstStepScreen getFirstStepScreen() {
        return firstStepScreen;
    }

    public SecondStepScreen getSecondStepScreen() {
        return secondStepScreen;
    }

    public class FirstStepScreen {

        private WebDriver driver;

        @FindBy (className = "btnclose")
        private WebElement closeBtn;

        @FindBy (xpath = "//*[@id=\"username\"]")
        private WebElement emailInputField;

        @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[3]/button")
        private WebElement submitBtn;

        @FindBy (className = "\"at_card-form-link at_link pointer\"\n")
        private WebElement forgotPasswordBtn;

        @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[2]/div/div[2]/label/div/span[2]")
        private WebElement errorMessage;

        public FirstStepScreen(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        private WebElement getCloseBtn() {
            return closeBtn;
        }

        private WebElement getEmailInputField() {
            return emailInputField;
        }

        private WebElement getForgotPasswordBtn() {
            return forgotPasswordBtn;
        }

        private WebElement getSubmitBtn() {
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
        public FirstStepScreen clickForgotPasswordLink(){
            getForgotPasswordBtn().click();
            return this;
        }

        @Step
        public SecondStepScreen clickToNextBtn() throws  NullPointerException{

            SecondStepScreen secondStepScreen = new SecondStepScreen(driver);

            getSubmitBtn().click();

            if (secondStepScreen != null)
                return secondStepScreen;

            return null;
        }
    }

    public class SecondStepScreen {

        private WebDriver driver;

        @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/password-signin/a")
        WebElement backBtn;

        @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[1]/a" )
        WebElement closeBtn;

        @FindBy(xpath = "//*[@id=\"password\"]")
        WebElement passwordInput;

        @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/password-signin/form/div/a")
        WebElement forgotPasswordLink;

        @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/password-signin/form/div/div[5]/button")
        WebElement loginBtn;

        public SecondStepScreen(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public WebElement getCloseBtn() {
            return closeBtn;
        }

        public WebElement getBackBtn() {
            return backBtn;
        }

        public WebElement getForgotPasswordLink() {
            return forgotPasswordLink;
        }

        public WebElement getLoginBtn() {
            return loginBtn;
        }

        public WebElement getPasswordInput() {
            return passwordInput;
        }

        @Step
        public SecondStepScreen clickCloseBtn(){
            getCloseBtn().click();
            return this;
        }

        @Step
        public SecondStepScreen clickLoginBtn(){
            getLoginBtn().click();
            return this;
        }

        @Step
        public SecondStepScreen clickAndTypePassword(String password){
            getPasswordInput().clear();
            getPasswordInput().sendKeys(password);
            return this;
        }

        @Step
        public SecondStepScreen clickForgotPasswordLink(){
            getForgotPasswordLink().click();
            return this;
        }

        @Step
        public FirstStepScreen clickBackBtn(){
            getBackBtn().click();
            FirstStepScreen firstStepScreen = new FirstStepScreen(driver);
            return firstStepScreen;
        }
    }
}
