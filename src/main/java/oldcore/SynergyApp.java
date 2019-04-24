package oldcore;

import oldcore.modals.SignUpModal;
import oldcore.modals.LoginModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by alexnesov on 27/03/2017.
 */

public class SynergyApp {


    private static final String URL ="https://synergy.net";
    //private final WebDriver driver;
    private BottomMenu bottomMenu;
    private TopMenu topMenu;
    private SearchBar searchBar;
    private LoginModal loginModal;
    private SignUpModal signUpModal;

//    private HambMenu hambMenu;

    public SynergyApp(WebDriver driver){
  //      this.driver = driver;
        this.bottomMenu = new BottomMenu(driver);
        this.topMenu = new TopMenu(driver);
        this.searchBar = new SearchBar(driver);
        this.loginModal = new LoginModal(driver);
        this.signUpModal = new SignUpModal(driver);

//        this.hambMenu = new HambMenu(driver);
        PageFactory.initElements(driver, this);
    }

    SynergyApp(){}


    public BottomMenu bottomBar(){
        return bottomMenu;
    }

    public TopMenu topMenu(){
        return topMenu;
    }

    public SearchBar searchBar() {
        return searchBar;
    }

    public LoginModal loginModals() {
        return loginModal;
    }

    public SynergyApp open(){
 //       driver.get(URL);
        return this;
    }

    public SignUpModal signUpModal() {
        return signUpModal;
    }

//    public static void main(String[] args) {
//
////        WebDriver driver = new ChromeDriver();
//        SynergyApp app = new SynergyApp();
//        Method[] tests = AuthTests.getMethods();
//
//        for(Method i : tests)
//            System.out.println(tests);
//
//    }
}
