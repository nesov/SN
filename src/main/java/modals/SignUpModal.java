package modals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    };

    private final int TIMEOUT = 100;

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

    protected WebElement getCloseBtn() {
        return closeBtn;
    }

    protected WebElement getAgreeCheckBx() {
        return agreeCheckBx;
    }

    protected WebElement getContinueBtn() {
        return continueBtn;
    }

    protected WebElement getEmailField() {
        return email;
    }

    protected WebElement getFirstNameField() {
        return firstName;
    }

    protected WebElement getLastNameField() {
        return lastName;
    }

    protected WebElement getPasswordField() {
        return password;
    }

    @Step ("Заполнил имя пользователя")
    public SignUpModal fillOutFirstName(String firstname){
            WaitHelper.waitingFor(driver,getFirstNameField(),TIMEOUT);
            getFirstNameField().sendKeys(firstname);
        return this;
    }

    @Step ("Заполнил фамилию пользователя")
    public SignUpModal fillOutLastName(String lastName){
            WaitHelper.waitingFor(driver, getFirstNameField(),TIMEOUT);
            getLastNameField().sendKeys(lastName);
        return this;
    }

    @Step ("Заполнил имейл пользователя")
    public SignUpModal fillOutуEmail(String email){
        WaitHelper.waitingFor(driver, getEmailField(),TIMEOUT);
        getEmailField().sendKeys(email);
        return this;
    }

    @Step ("Заполнил пароль пользователя")
    public SignUpModal fillOutPassword(String password){
        WaitHelper.waitingFor(driver, getPasswordField(),TIMEOUT);
        getPasswordField().sendKeys(password);
        return this;
    }

    @Step ("Согласился с политикой пользователя")
    public SignUpModal agreeWithPrivacyPolicy() throws  NoSuchElementException{

        WaitHelper.waitingFor(driver,getAgreeCheckBx(),TIMEOUT);
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
        WaitHelper.waitingForFiveSeconds(driver,getContinueBtn());
        getContinueBtn().click();
        return new FinalStepModal(driver);
    }

    @Step ("Закрыл модалку сайнапа")
    public void closeSignUpModal() throws NoSuchElementException{
        WaitHelper.waitingForFiveSeconds(driver,getCloseBtn());
        try{
            if(getCloseBtn().isDisplayed())
                getCloseBtn().click();
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }


}
