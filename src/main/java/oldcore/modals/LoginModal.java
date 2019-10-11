package oldcore.modals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public class LoginModal {

    private WebDriver driver;
    private LoginModal.FirstStepScreen firstStepScreen;
    private LoginModal.SecondStepScreen secondStepScreen;

    public LoginModal(WebDriver driver){
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

        public boolean isLoginModalShown(){

                if (closeBtn.isDisplayed() & emailInputField.isDisplayed() & submitBtn.isDisplayed() & forgotPasswordBtn.isDisplayed())
                    return true;
                else
                    return false;
        }

        public FirstStepScreen setCursorAndWriteIntoEmailField(String email){

            try {
                    WaitHelper.waitingWithPolling(driver,getEmailInputField());
                    getEmailInputField().sendKeys(email);
                } catch (NoSuchElementException ex){
                ex.printStackTrace();
            }
            return this;
        }

        public FirstStepScreen clickCloseBtn(){
            WaitHelper.waitingWithPolling(driver, getCloseBtn());
            getCloseBtn().click();
            return this;
        }

        public FirstStepScreen clickForgotPasswordLink()throws Exception {
            WaitHelper.waitingForFiveSeconds(driver,getForgotPasswordBtn());
            getForgotPasswordBtn().click();
            return this;
        }

        public SecondStepScreen clickToNextBtn() {
            try {
                WaitHelper.waitingWithPolling(driver, getSubmitBtn());
                getSubmitBtn().click();
                if (secondStepScreen != null)
                    return secondStepScreen;
            } catch (NoSuchElementException ex){}

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
        /****************************************/
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
        /****************************************/

        public SecondStepScreen clickCloseBtn(){
            getCloseBtn().click();
            return this;
        }

        public SecondStepScreen clickLoginBtn(){
            getLoginBtn().click();
            return this;
        }

        public SecondStepScreen clickAndTypePassword(String password){
            WaitHelper.waitingWithPolling(driver, getPasswordInput());
                getPasswordInput().sendKeys(password);

            return this;
        }


        public SecondStepScreen clickForgotPasswordLink(){
            getForgotPasswordLink().click();
            return this;
        }

        public FirstStepScreen clickBackBtn(){
            getBackBtn().click();
            FirstStepScreen firstStepScreen = new FirstStepScreen(driver);
            return firstStepScreen;
        }
    }
}