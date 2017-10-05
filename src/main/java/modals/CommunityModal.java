package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunityModal {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/privacy-policy-modal/div/div/div/div[3]/button[1]")
    private WebElement aggreBtn;

    @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/privacy-policy-modal/div/div/div/div[3]/button[2]")
    private WebElement cancelBtn;

    @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/privacy-policy-modal/div/div/div/div[2]/div[2]/div[3]/md-checkbox/label/div")
    private WebElement agreeCheckBox;

    @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/privacy-policy-modal/div/div/div/div[1]/a")
    private WebElement closeBtn;

    @FindBy(xpath = "/html/body/app-synergy/dynamic-settings/root-component/privacy-policy-modal/div/div/div/div[2]/div[2]/div[3]/md-checkbox/label/span/gettext/span[9]/a")
    private WebElement privacyPolicy;

    public CommunityModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getCloseBtn() {
        return closeBtn;
    }

    public WebElement getAggreBtn() {
        return aggreBtn;
    }

    public WebElement getAgreeCheckBox() {
        return agreeCheckBox;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }
}
