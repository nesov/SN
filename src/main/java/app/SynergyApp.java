package app;

import modals.SignUpModal;
import com.controls.BottomMenu;
import modals.LoginModals;
import com.controls.SearchBar;
import com.controls.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexnesov on 27/03/2017.
 */

public class SynergyApp {

    private final WebDriver driver;
    private BottomMenu bottomMenu;
    private TopMenu topMenu;
    private SearchBar searchBar;
    private LoginModals loginModals;
    private SignUpModal signUpModal;
//    private HambMenu hambMenu;

    public SynergyApp(WebDriver driver){
        this.driver = driver;
        this.bottomMenu = new BottomMenu(driver);
        this.topMenu = new TopMenu(driver);
        this.searchBar = new SearchBar(driver);
        this.loginModals = new LoginModals(driver);
        this.signUpModal = new SignUpModal(driver);
//        this.hambMenu = new HambMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public BottomMenu getBottomBar(){
        return bottomMenu;
    }

    public TopMenu getTopMenu(){
        return topMenu;
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public LoginModals getLoginModals() {
        return loginModals;
    }

    public SignUpModal getSignUpModal() {
        return signUpModal;
    }
}
