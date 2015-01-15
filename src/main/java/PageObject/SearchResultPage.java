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

    public int countResultEntry(){
        int numElement = driver.findElements(By.className("entry") ).size();
        return numElement;

    }


}
