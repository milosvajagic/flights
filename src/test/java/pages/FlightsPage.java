package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG Actionable-module__focus-inset___3TZbM\"]")
    WebElement flights;
    @FindBy(xpath = "//div[@data-testid=\"searchbox_origin\"]")
    WebElement startingPoint;
    @FindBy(xpath ="//div[@data-testid=\"searchbox_destination\"]")
    WebElement endingPoint;
    @FindBy(css = "//div[@class=\"css-164c9py\"]//..")
    List<WebElement> dates;
   // @FindBy(css = ".xp__guests__count")
   // WebElement guestCount;
    @FindBy(xpath = "//button[@data-testid=\"searchbox_submit\"]")
    WebElement search;

    public void addStartingPoint(String startingPointText) throws InterruptedException {
        typeText(startingPoint, startingPointText);
    }

    public void addEndingPoint(String endingPointText) throws InterruptedException {
        typeText(endingPoint, endingPointText);
    }

    public void addDates(String departureDate, String returnDate) throws InterruptedException {
        //Check is date today's date or futures date
        //check is check out after check in date
        //Check is date displayed if not click next
        clickElement(dates.get(0));
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell="+departureDate+"]")));
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell="+returnDate+"]")));
    }

    public void clickSearch() throws InterruptedException {
        clickElement(search);
    }

    public void clickFlights() throws  InterruptedException{
        clickElement(flights);
    }
}
