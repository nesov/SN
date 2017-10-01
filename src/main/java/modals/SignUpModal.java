package modals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class SignUpModal {

    private WebDriver driver;

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
    public SignUpModal fillOutFirstName(String password){
        getFirstNameField().sendKeys(password);
        return this;
    }

    @Step ("Заполнил фамилию пользователя")
    public SignUpModal fillOutLastName(String lastName){
        getLastNameField().sendKeys(lastName);
        return this;
    }

    @Step ("Заполнил имейл пользователя")
    public SignUpModal fillOutуEmail(String email){
        getEmailField().sendKeys(email);
        return this;
    }

    @Step ("Заполнил пароль пользователя")
    public SignUpModal fillOutPassword(String password){
        getPasswordField().sendKeys(password);
        return this;
    }

    @Step ("Согласился с политикой пользователя")
    public SignUpModal agreeWithPrivacyPolicy() throws  NoSuchElementException{
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
    public SignUpModal clickContinueBtn(){
        getContinueBtn().click();
        return this;
    }

    @Step ("Закрыл модалку сайнапа")
    public void closeSignUpModal() throws NoSuchElementException{
        try{
            if(getCloseBtn().isDisplayed())
                getCloseBtn().click();
        } catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }


}
