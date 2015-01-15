package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "SearchInput")
    private WebElement txtSearchbox;

    @FindBy(how= How.XPATH,using = "/html/body/div[1]/div[1]/div[1]/div[1]/div[2]/div/form/fieldset/dl[1]/dd/ul/li[2]/a/ul/li/strong/span")
    private WebElement firstItemInSearch;

    @FindBy(id = "CheckInDay")
    private WebElement checkInDay;

    @FindBy(id = "CheckInMonthYear")
    private WebElement CheckInMonthYear;

    @FindBy(id = "search-datepicker-check-in")
    private WebElement calendarCheckIn;

    @FindBy(id = "search-datepicker-check-out")
    private WebElement calendarCheckOut;

    @FindBy(id = "NightCount")
    private WebElement cmbNightCount;

    @FindBy(how=How.XPATH,using = "/html/body/div[1]/div[1]/div[1]/div[1]/div[2]/div/form/fieldset/dl[5]/dd/input")
    private WebElement bntSearch;

    public SearchPage inputSearchString(String text){
        txtSearchbox.sendKeys(text);
        return this;
    }

    public SearchPage inputAndSelectSearchString(String text){
        txtSearchbox.sendKeys(text);
        firstItemInSearch.click();
        return this;
    }

    public SearchPage selectDay(int index){
        Select cmbCheckInDay=new Select(checkInDay);
        cmbCheckInDay.selectByIndex(index);
        return this;
    }

    public SearchPage selectMonthYear(int index){
        Select cmbCheckInMonthYear=new Select(CheckInMonthYear);
        cmbCheckInMonthYear.selectByIndex(index);
        return this;
    }

    public SearchPage selectCalendarCheckIn(){
        calendarCheckIn.click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[5]/td[3]/a")).click();
        return this;
    }

    public SearchResultPage clickSearch(){
        bntSearch.click();
        return new SearchResultPage(driver);
    }
}
