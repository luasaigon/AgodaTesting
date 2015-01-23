package PageObject;

import CodeAction.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage extends CommonAction {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, SearchResultPage.class);
    }

    @FindBy(how= How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div[1]/aside/div[1]/div/h3")
    public WebElement boxSearchDetails;

    @FindBy(how=How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/h1")
    public  WebElement textSearchFor;

    @FindBy(how=How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/h1/strong")
    public WebElement searchString;

    @FindBy(how=How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/div/div[1]")
    public WebElement searchOption;

    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/ul/li[1]/a")
    public WebElement bntAll;

    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/ul/li[2]/a")
    public WebElement bntCities;

    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/ul/li[3]/a")
    public WebElement bntHotels;

    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/ul/li[4]/a")
    public WebElement bntAirports;

    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/article/div/div/ul/li[5]/a")
    public WebElement bntLandmarks;

    public String getTextOfSearchBox(){
        return boxSearchDetails.getText();
    }

    public String getTextSearchFor(){
        return textSearchFor.getText();
        //return getStringOfElement(textSearchFor);
    }

    public boolean isSearchBoxPresent(){
        return super.existsElement("/html/body/div[1]/div[2]/article/div/div[1]/aside/div[1]/div/h3",3);
    }

    public boolean isAlternativeSearchOptionPresent(){
        return super.existsElement("/html/body/div[1]/div[2]/article/div/div/div/div[1]",3);
    }

    public int countResultEntry(String locator){
        int numElement = driver.findElements(By.className(locator) ).size();
        return numElement;

    }

    public String getColorOfSearchString(){
        String colorOfString=searchString.getCssValue("color");
        //System.out.println(colorOfString);
        return colorOfString;
    }

    public String getFontSizeOfSearchString(){
        String fontSizeOfString=searchString.getCssValue("font-size");
        return fontSizeOfString;
    }

    public boolean isButtonAllPresent(){
        return super.isExistsWebElement(bntAll);
    }

    public boolean isButtonCitiesPresent(){
        return super.isExistsWebElement(bntCities);
    }

    public boolean isButtonHotelsPresent(){
        return super.isExistsWebElement(bntHotels);
    }

    public boolean isButtonAirportsPresent(){
        return super.isExistsWebElement(bntAirports);
    }

    public boolean isButtonLandmarksPresent(){
        return super.isExistsWebElement(bntLandmarks);
    }

}
