import CodeAction.CommonAction;
import PageObject.SearchPage;
import PageObject.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends CommonAction {

    private WebDriver driver;
    String url="http://www.agoda.com/index.html";
    SearchPage searchPage;
    SearchResultPage resultPage;

    @BeforeClass
    private void setup(){
        driver=super.setupBeforeTest(url);
        searchPage= PageFactory.initElements(driver,SearchPage.class);

    }

    @AfterClass
    private void exit(){
        //driver.close();
    }

    @Test
    public void search() throws InterruptedException {
        resultPage=searchPage.inputSearchString("Bacolod")
                .selectDay(5)
                .selectMonthYear(5)
                .selectCalendarCheckIn()
                .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);

        //Assert nay danh cho search ma chon entry tu autocomplete search
        //Assert.assertEquals(resultPage.getTextOfSearchBox(), "Your Search Details");
        //Assert.assertTrue(resultPage.isSearchBoxPresent());


        //Assert nay khi ko chon autocomplete
        //Assert.assertTrue(resultPage.getTextSearchFor().matches("Your search.*"));

        //Assert modify box is present in bottom of page search result
        Assert.assertTrue(resultPage.isAlternativeSearchOptionPresent());

        System.out.println("total has "+resultPage.countResultEntry()+" results");
    }



}