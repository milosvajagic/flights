package steps;

import excel_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.FlightsPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BookingSteps extends BaseTest {

    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String BROWSER_VERSION = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER_VERSION");
    String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");
    String ENV = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ENV");

    Map<String, String> data;
    String testDataPath = "/Users/milosvajagic/IdeaProjects/BookingFlight/src/test/java/test_data/";

    @Before
    public void setUp() throws Exception {
        setUPTest(BROWSER, BROWSER_VERSION, Integer.parseInt(WAIT));
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        reportScreenshot("end", "screenshot on end or fail");
//        quit();
    }

    @Given("I load test data from {string} {string} {string}")
    public void iLoadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
        ExcelUtilities excelUtilities = new ExcelUtilities();
        data = excelUtilities.getRowData(testDataPath+fileName+".xlsx", sheetName, rowNum);
        System.out.println(data.get("StartingPoint"));
        System.out.println(data.get("EndingPoint"));
    }

    @And("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startApplication(ENV);
    }

    @And("I click on Flights")
    public void iClickOnFlights() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickFlights();
    }

    @When("I add starting point")
    public void iAddStartingPoint() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addStartingPoint(data.get("StartingPoint"));
    }


    @And("I add ending point")
    public void iAddEndingPoint() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addEndingPoint(data.get("EndingPoint"));
    }


    @And("I add departure date and return date")
    public void iAddDepartureDateAndReturnDate() throws InterruptedException, IOException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addDates(data.get("DepartureDate"), data.get("ReturnDate"));
        takeScreenshot("DateScreenshot");
    }

    @And("I click search")
    public void iClickSearch() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSearch();
    }

    @When("I change first stop filter")
    public void iChangeFirstStopFilter() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectStopCheckBox();
    }

    @And("I select departs time")
    public void iSelectDepartsTime() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectDepartTimeheckBox();
    }

    @And("I click on See flight button")
    public void iClickOnSeeFlightButton() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSeeFlights();
    }

    @And("I click on Select button")
    public void iClickOnSelectButton() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSelectButton();

    }

    @When("I click Next button")
    public void iClickNextButton() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickNextButton();
    }

    @Then("I populate Contact Details")
    public void iPopulateContactDetails() throws InterruptedException, IOException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.enterContactDetails(data.get("Email"),data.get("FirstName"),data.get("LastName"), data.get("Gender"), data.get("Phone"));
        takeScreenshot("ContactDetailsScreenshot");
    }
}




