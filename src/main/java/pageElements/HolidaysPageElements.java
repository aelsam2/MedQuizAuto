package pageElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HolidaysPageElements {
	WebDriver holidaysPageElemsdriver;
	
	public  HolidaysPageElements(WebDriver driver) {
		PageFactory.initElements( driver, this);
		holidaysPageElemsdriver=driver;
		
	}
	Actions actions;
@FindBy(xpath="//ul [@class=\"subMenu\"]/li[1]/a")
public WebElement DestinationOptn;

@FindBy(xpath="//span[contains(text(),\"Domestic\")]")
public WebElement DomesticOptn;

@FindBy(xpath="//li[@class=\"deeplink\"]/a[contains(text(), \"Kerala\")]")
public WebElement KeralaOptn;

@FindBy(xpath="(//div[@class=\"imageLoaderContainer\"])[2]")
public WebElement BestEverGateWayDetailsOptn;

@FindBy(xpath="//a[contains(text(),\"Next\")]")
public WebElement GuideNxtBtn;

@FindBy(xpath="//a[contains(text(),\"GOT IT\")]")
public WebElement GuideGotItBtn;

@FindBy(xpath="(//li[@class=\"Selection \"])[2]")
public WebElement fourStarFilteroptn;
@FindBy(xpath="(//button[@class=\"multiSelect filterBtn \"])[2]")
public WebElement fourStarFilteroptn1;

@FindBy(className="textCenter")
public WebElement addMoreFilterBtn;

@FindBy(xpath="//li[contains(text(),'Cultural')]/img")
public WebElement culturalCloseBtn;
@FindBy(xpath="//label[@for='Allepey']")
public WebElement allepyOption;
@FindBy(xpath="//label[@for='Allepey_1_22']")
public WebElement allepyOption1;

@FindBy(xpath="//li[contains(text(),\"With Flights\")]")
public WebElement withFlightsOption;

@FindBy(xpath="//div[@data-cy=\"outsideModal\"]")
public WebElement logInPopUp;
@FindBy(xpath="//button[contains(text(),\"With Flights\")]")
public WebElement withFlightsOption1;

@FindBy(xpath="(//div[@class=\"sliderCardShadow\"])[1]")
public WebElement firstDeal;
@FindBy(xpath="(//div[@class=\"appendBottom15\"])[5]")
public WebElement firstDeal1;

@FindBy(xpath="(//div[@class=\"sliderCardShadow\"])[1]")
public WebElement locationInList;
@FindBy(xpath="(//div[@class=\"appendBottom15\"])[1]")//
public WebElement locationInList1;

@FindBy(xpath="//a[contains(text(),\"Flights\")]")
public WebElement flightOptn;

@FindBy(xpath="(//a[contains(text(),\"REMOVE\")])[1]")
public WebElement flightList;

@FindBy(xpath="//a[contains(text(),\"Hotels\")]")
public WebElement hotelOptn;

@FindBy(xpath="(//p/span[contains(text(),\"4\")])[1]")
public WebElement fourStrHotelList;


public void AssertKeralaUndrDomstcDestn() throws InterruptedException {
	actions = new Actions(holidaysPageElemsdriver);
	
	actions.moveToElement(DestinationOptn).perform();
	holidaysPageElemsdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	actions.moveToElement(DomesticOptn).perform();
	Assert.assertEquals(true, KeralaOptn.isDisplayed());

}
public void ClickKeralaOption() {
	actions = new Actions(holidaysPageElemsdriver);
	actions.moveToElement(DestinationOptn).perform();
	actions.moveToElement(DomesticOptn).perform();
	KeralaOptn.click();
}

public void selectBestEverGateWayDetailsOptn() throws InterruptedException {
	Thread.sleep(2000);
	GuideNxtBtn.click();
	GuideNxtBtn.click();
	GuideGotItBtn.click();
	BestEverGateWayDetailsOptn.click();
}

public void selectFourStarFilter() throws InterruptedException {
	Thread.sleep(2000);
	fourStarFilteroptn.click();
	Thread.sleep(2000);
}
public void selectWithFlightFilter() throws InterruptedException {
	addMoreFilterBtn.click();
	Thread.sleep(3000);
	JavascriptExecutor executor = (JavascriptExecutor)holidaysPageElemsdriver;
	executor.executeScript("arguments[0].click();", logInPopUp);
	//logInPopUp.click();
	Thread.sleep(2000);
	addMoreFilterBtn.click();
	Thread.sleep(2000);
	withFlightsOption.click();
	Thread.sleep(2000);
}
public void selectAllepyPlace() throws InterruptedException {
	addMoreFilterBtn.click();
	allepyOption.click();
	Thread.sleep(2000);
}

public void selectAPackage() throws InterruptedException {
	firstDeal.click();
	Thread.sleep(2000);
}

public void verifyThePackageListedPerFilters() throws InterruptedException {
	if ( holidaysPageElemsdriver.getPageSource().contains("Allepey")){
        System.out.println("Allepey: is present. ");
     } else {
        System.out.println("Allepey: is not present. ");
     }
	flightOptn.click();
	Thread.sleep(1000);
	Assert.assertEquals(true, flightList.isDisplayed());
	Thread.sleep(1000);
	hotelOptn.click();
	Assert.assertEquals(true, fourStrHotelList.isDisplayed());
	
}

public void selectAPackage1() throws InterruptedException {
	firstDeal1.click();
	Thread.sleep(2000);
}

public void selectFourStarFilter1() throws InterruptedException {
	fourStarFilteroptn1.click();
	Thread.sleep(2000);
}
public void selectWithFlightFilter1() throws InterruptedException {
	withFlightsOption1.click();
	Thread.sleep(2000);
}

public void selectAllepyPlace1() throws InterruptedException {
	culturalCloseBtn.click();
	allepyOption1.click();
	Thread.sleep(2000);
}
}

