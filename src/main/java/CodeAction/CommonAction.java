package CodeAction;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonAction {

    private static WebDriver driver;
    private int timelimit = 20;

    public static Object initElements(Object Class) {
        return PageFactory.initElements(driver, Class.class);
    }

    public WebDriver setupBeforeTest(String url) {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timelimit, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    public void exitAfterTest() {
        driver.quit();
    }

    public void sleep(int time) throws InterruptedException {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            ex.getCause();
        }
    }

    public boolean existsElement(String locator,int type) {
        /*
        type:
        1: id
        2: name
        3: xpath
         */
        boolean isFail=false;
        switch (type){
            case 1:{
                try {
                    driver.findElement(By.id(locator));
                } catch (NoSuchElementException e) {
                    return isFail;
                }
                isFail=true;
                break;
            }
            case 2:{
                try {
                    driver.findElement(By.name(locator));
                } catch (NoSuchElementException e) {
                    return isFail;
                }
                isFail= true;
                break;

            }
            case 3:{
                try {
                    driver.findElement(By.xpath(locator));
                } catch (NoSuchElementException e) {
                    return isFail;
                }
                isFail= true;
                break;

            }
        }
        return isFail;
    }
}