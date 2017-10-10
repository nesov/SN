package modals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WaitHelper;

public class SignUpModal {

    private class FinalStepModal{

        private WebDriver driver;

        @FindBy(className = "btnclose")
        private WebElement closeBnt;

        @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/final-signin/form/div/div[3]/button")
        private WebElement finishBtn;

        FinalStepModal(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public WebElement getCloseBnt() {
            return closeBnt;
        }

        public WebElement getFinishBtn() {
            return finishBtn;
        }

        @Step("click close button")
        public void closeModal(){
            getCloseBnt().click();
        }

        @Step("click Finish button")
        public void clickFinishBtn(){
            getFinishBtn().click();
        }

    }

    private WebDriver driver;

    private SignUpModal.FinalStepModal finalStepModal;

    @FindBy (id = "firstName")
    private WebElement firstName;

    @FindBy (id = "lastName")
    private WebElement lastName;

    @FindBy (id = "email")
    private WebElement email;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (className = "btnclose")
    private WebElement closeBtn;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/signup-signin/form/div/div[11]/button")
    private WebElement continueBtn;

    @FindBy (xpath = "/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/signup-signin/form/div/div[10]/div/md-checkbox/label/div")
    private WebElement agreeCheckBx;

    public SignUpModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCloseBtn() {
        return closeBtn;
    }
    public WebElement getAgreeCheckBx() {
        return agreeCheckBx;
    }
    public WebElement getContinueBtn() {
        return continueBtn;
    }
    public WebElement getEmailField() {
        return email;
    }
    public WebElement getFirstNameField() {
        return firstName;
    }
    public WebElement getLastNameField() {
        return lastName;
    }
    public WebElement getPasswordField() {
        return password;
    }

    @Step ("Заполнил имя пользователя")
    public SignUpModal fillOutFirstName(String firstname){
            WaitHelper.waitingWithPolling(driver, getFirstNameField());
            getFirstNameField().sendKeys(firstname);
        return this;
    }

    @Step ("Заполнил фамилию пользователя")
    public SignUpModal fillOutLastName(String lastName){
            WaitHelper.waitingWithPolling(driver, getFirstNameField());
            getLastNameField().sendKeys(lastName);
        return this;
    }

    @Step ("Заполнил имейл пользователя")
    public SignUpModal fillOutуEmail(String email){
        WaitHelper.waitingWithPolling(driver, getEmailField());
        getEmailField().sendKeys(email);
        return this;
    }

    @Step ("Заполнил пароль пользователя")
    public SignUpModal fillOutPassword(String password){
        WaitHelper.waitingWithPolling(driver, getPasswordField());
        getPasswordField().sendKeys(password);
        return this;
    }

    @Step ("Согласился с политикой пользователя")
    public SignUpModal agreeWithPrivacyPolicy() throws  NoSuchElementException{

        WaitHelper.waitingWithPolling(driver,getAgreeCheckBx());
        try {
            if (getAgreeCheckBx().isDisplayed())
                getAgreeCheckBx().click();
            return this;
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Step ("Клик на кнопрку продолжить")
    public FinalStepModal clickContinueBtn(){
        WaitHelper.waitingWithPolling(driver,getContinueBtn());
        getContinueBtn().click();
        return new FinalStepModal(driver);
    }

    @Step ("Закрыл модалку сайнапа")
    public void closeSignUpModal() throws NoSuchElementException{
        WaitHelper.waitingWithPolling(driver,getCloseBtn());
        try{
            if(getCloseBtn().isDisplayed())
                getCloseBtn().click();
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }
}
