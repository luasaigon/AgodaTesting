package CodeAction;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        boolean isExist=true;
        switch (type){
            case 1:{
                try {
                    driver.findElement(By.id(locator));
                    //isExist=true;
                } catch (NoSuchElementException e) {
                    isExist=false;
                }

                break;
            }
            case 2:{
                try {
                    driver.findElement(By.name(locator));
                    //isExist= true;
                } catch (NoSuchElementException e) {
                    isExist=false;
                }

                break;

            }
            case 3:{
                try {
                    driver.findElement(By.xpath(locator));
                    //isExist= true;
                } catch (NoSuchElementException e) {
                    isExist=false;
                }

                break;
            }
        }
        return isExist;
    }

//    public String getStringOfElement(WebElement element){
//        return element.getText();
//    }

    public boolean isExistsWebElement(WebElement element){
        if(element==null)
            return false;
        return true;
    }

    public void goBackHomePage(){
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div/a/img")).click();
    }
}