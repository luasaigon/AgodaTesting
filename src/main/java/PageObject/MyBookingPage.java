package PageObject;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dave on 12/28/2014.
 */
public class MyBookingPage {

    private WebDriver driver;

    public MyBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String title(){
        return driver.getTitle();
    }
}
