
import CodeAction.CommonAction;
import PageObject.LoginPage;
import PageObject.MyBookingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends CommonAction {

    private WebDriver driver;
    private String url = "https://www.agoda.com/rewards/login.html";
    LoginPage loginPage;
    MyBookingPage myBookingPage;

    @BeforeClass
    public void setup() {
        driver = super.setupBeforeTest(url);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginFail() {
        loginPage = loginPage.inputEmail("test@yopmail.com")
                .inputPasswork("12345678")
                .clickSignInFail();
        //Reporter.log("click loginFail", 2, true);
        Assert.assertEquals(loginPage.errorNotificationSignIn(), "Email or Password is incorrect.");
    }

    @Test//(enabled = false)
    public void loginPass() throws InterruptedException {
        myBookingPage = loginPage.inputEmail("agoda_acc@yopmail.com")
                .inputPasswork("12345678")
                .clickSignInPass();
        //Reporter.log("click loginPass", 1, true);
        //myBookingPage= PageFactory.initElements(driver,MyBookingPage.class);
        //myBookingPage=initElements(MyBookingPage);
        sleep(5000);
        Assert.assertEquals(myBookingPage.title(), "My Bookings");
    }

    @Test
    public void loginLock(){

    }

    @AfterClass
    public void exit() {
        super.exitAfterTest();
    }
}