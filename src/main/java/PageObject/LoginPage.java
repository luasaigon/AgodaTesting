package PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dave on 12/28/2014.
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "ctl00_ctl00_MainContent_ContentMain_RewardLogin1_txtEmail")
    private WebElement txtEmail;

    @FindBy(id = "ctl00_ctl00_MainContent_ContentMain_RewardLogin1_txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "ctl00_ctl00_MainContent_ContentMain_RewardLogin1_btnSignIn")
    private WebElement btnSignIn;

    @FindBy(id = "notification_sign_in")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputEmail(String email){
        txtEmail.sendKeys(email);
        return this;
    }

    public LoginPage inputPasswork(String password){
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInFail(){
        btnSignIn.click();
        return this;
    }

    public MyBookingPage clickSignInPass(){
        btnSignIn.click();
        return new MyBookingPage(driver);
    }

    public String errorNotificationSignIn(){
        return errorMessage.getText();
    }


}
