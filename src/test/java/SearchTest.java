import CodeAction.CommonAction;
import PageObject.SearchPage;
import PageObject.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

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
        super.exitAfterTest();
    }

    //------------------------------------------------------

    @Test//(priority = 0,enabled = false)
    public void search_AssertReturnText() throws InterruptedException {
        resultPage=searchPage.inputSearchString("hcm")
                .selectDay(5)
                .selectMonthYear(5)
                //.selectCalendarCheckIn()
                .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);

        //Assert nay danh cho search ma chon entry tu autocomplete search
        //Assert.assertEquals(resultPage.getTextOfSearchBox(), "Your Search Details");
        //Assert.assertTrue(resultPage.isSearchBoxPresent());

        //Assert nay khi ko chon autocomplete
        Assert.assertTrue(resultPage.getTextSearchFor().matches("Your search for hcm matched the following..."));
        super.goBackHomePage();

     }

    @Test//(priority = 1, enabled = false)
    public void search_AssertNumberResult() throws InterruptedException {
        resultPage=searchPage.inputSearchString("hcm")
                .selectDay(5)
                .selectMonthYear(5)
                        //.selectCalendarCheckIn()
                .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);

        int numResult=resultPage.countResultEntry("score");
        Assert.assertEquals(numResult,4);
        super.goBackHomePage();
    }

    @Test//(enabled = false)
    public void search_AssertSearchOptionPresent() throws InterruptedException {
        resultPage=searchPage.inputSearchString("hcm")
                .selectDay(5)
                .selectMonthYear(5)
                        //.selectCalendarCheckIn()
                .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);

        //Assert modify box is present in bottom of page search result
        Assert.assertTrue(resultPage.isAlternativeSearchOptionPresent());
        super.goBackHomePage();

    }

    @Test//(enabled = false)
     public void search_AssertColor() throws InterruptedException {
        resultPage=searchPage.inputSearchString("hcm")
                             .selectDay(5)
                             .selectMonthYear(5)
                                    //.selectCalendarCheckIn()
                             .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);
        String colorOfSearchString=resultPage.getColorOfSearchString();
        //Assert.assertTrue(colorOfSearchString.contains("#0283df"));
        Assert.assertEquals(colorOfSearchString, "rgba(2, 131, 223, 1)");
        super.goBackHomePage();
    }

    @Test//(enabled = false)
    public void search_AssertFontSize() throws InterruptedException {
        resultPage=searchPage.inputSearchString("hcm")
                             .selectDay(5)
                             .selectMonthYear(5)
                                    //.selectCalendarCheckIn()
                             .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);
        String sizeOfSearchString=resultPage.getFontSizeOfSearchString();
        Assert.assertEquals(sizeOfSearchString,"33.8px");
        super.goBackHomePage();
    }

    @Test
    public void search_AssertFiveButtonPresent() throws InterruptedException{
        resultPage=searchPage.inputSearchString("hcm")
                .selectDay(5)
                .selectMonthYear(5)
                        //.selectCalendarCheckIn()
                .clickSearch();
        sleep(5000);
        resultPage=PageFactory.initElements(driver, SearchResultPage.class);
        Assert.assertTrue(resultPage.isButtonAllPresent());
        Assert.assertTrue(resultPage.isButtonCitiesPresent());
        Assert.assertTrue(resultPage.isButtonHotelsPresent());
        Assert.assertTrue(resultPage.isButtonAirportsPresent());
        Assert.assertTrue(resultPage.isButtonLandmarksPresent());
        super.goBackHomePage();
    }



}