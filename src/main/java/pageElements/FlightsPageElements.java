package pageElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import master.Main;

public class FlightsPageElements {

	WebDriver busesPageElemsdriver;
	Main main =new Main();
	public  FlightsPageElements(WebDriver driver) {
		PageFactory.initElements( driver, this);
		busesPageElemsdriver=driver;
		
	}

	String fare;	
@FindBy(id="fromCity")
public WebElement FromCitySearch;
@FindBy(xpath="//input[@placeholder=\"From\"]")
public WebElement FromSearchBox;
@FindBy(xpath="//div[contains(text(), 'TRV')]")
public WebElement FromSearchResult;
@FindBy(xpath="//input[@placeholder=\"To\"]")
public WebElement ToSearchBox;
@FindBy(xpath="//div[contains(text(), 'BOM')]")
public WebElement ToSearchResult;
@FindBy(xpath="//div[@aria-label='Mon Jun 14 2021']")
public WebElement DepartureDate;
@FindBy(xpath="//div[@data-cy=\"returnArea\"]")
public WebElement ReturnDrpDwn;
@FindBy(xpath="//div[@aria-label='Tue Jun 15 2021']")
public WebElement ReturnDate;
@FindBy(xpath="//label[@for=\"travellers\"]")
public WebElement TravellersAndClsDrpDwn;
@FindBy(xpath="//li[@data-cy=\"adults-2\"]")
public WebElement TwoAdults;
@FindBy(xpath="//li[@data-cy=\"children-1\"]")
public WebElement OneChild;
@FindBy(xpath="//button[@data-cy=\"travellerApplyBtn\"]")
public WebElement TravlrsApplyBtn;
@FindBy(xpath="//p[@data-cy=\"submit\"]")
public WebElement SearchBtn;
//Flight list page elements
@FindBy(className="splitVw")
public WebElement FlightLists;
@FindBy(xpath="(//div[@class='paneView'][1]//span[@class='customRadioBtn'])[1]")
public WebElement DepartFirstFlightRdBtn;
@FindBy(xpath="(//div[@class='paneView'][2]//span[@class='customRadioBtn'])[1]")
public WebElement ReturnFirstFlightRdBtn;

@FindBy(xpath="(//div[@class='paneView'][1]//div[@class='makeFlex priceInfo '])[1]")
public WebElement DepartFirstFlightPrice;
@FindBy(xpath="(//div[@class='paneView'][1]//div[@class='makeFlex priceInfo '])[1]")
public WebElement ReturnFirstFlightPrice;
@FindBy(xpath="(//div[@class='paneView'][1]//span[@class='pointer'])[4]")
public WebElement DepartPriceFilter;
@FindBy(xpath="(//div[@class='paneView'][2]//span[@class='pointer'])[4]")
public WebElement ReturnPriceFilter;

@FindBy(xpath="//button[contains(text(), 'Book Now')]")
public WebElement BookNowBtn;
@FindBy(xpath="//span[@class='whiteText fontSize22 boldFont']")
public WebElement TtlFare;
@FindBy(xpath="//div[@class=\"multifareFooter\"]/div/p[1]")
public WebElement PopUpTtlFare;
@FindBy(xpath="(//div[@class=\"multifareContentLeft\"])[1]/p[3]")
public WebElement PopUpDeptloc;
@FindBy(xpath="(//div[@class=\"multifareContentLeft\"])[2]/p[3]")
public WebElement PopUpRtnloc;
@FindBy(xpath="(//div[@class=\"multifareContentLeft\"])[1]/p[4]")
public WebElement PopUpDeptDte;
@FindBy(xpath="(//div[@class=\"multifareContentLeft\"])[2]/p[4]")
public WebElement PopUpRtnDte;

public void selectFromCity(String fromCity) throws InterruptedException {
	FromCitySearch.click();
	FromSearchBox.sendKeys(fromCity);  
	Thread.sleep(2000);
	FromSearchResult.click();
}

public void selectToCity(String toCity) throws InterruptedException {
	ToSearchBox.sendKeys(toCity); 
	Thread.sleep(2000);
	ToSearchResult.click();
}

public void selectDate() {   
	DepartureDate.click();
	ReturnDrpDwn.click();
	ReturnDate.click();
}

public void selectTravellers(){   
	TravellersAndClsDrpDwn.click();
	TwoAdults.click();
	OneChild.click();
	TravlrsApplyBtn.click();
}

public void clickSearchBtn() {   
	SearchBtn.click();
}

public void assertIndigoFlights() throws InterruptedException{ 
	Thread.sleep(2000);
	int a= busesPageElemsdriver.findElements(By.xpath("//span[@class=\"boldFont blackText\"]")).size();
	System.out.println(a);
	int i=1;
	while(i<=a) {
	WebElement indigoFlights=	busesPageElemsdriver.findElement(By.xpath("(//span[@class='boldFont blackText'])["+i+"]"));
		String text =indigoFlights.getText();
		String FlightName ="IndiGo";
		if(text.contains(FlightName))
		{
			Assert.assertEquals(text, FlightName);
			break;
		}
		else
		{
			i++;
			if(i==a) {
				Assert.assertEquals(text, FlightName);
			}else {
				continue;
			}
		}
	}
}
public void SlctLowPriceFlightsAndVerfySlction() throws InterruptedException{
	DepartFirstFlightRdBtn.click();
	Thread.sleep(2000);
	ReturnFirstFlightRdBtn.click();
	DepartFirstFlightRdBtn.isSelected();
	ReturnFirstFlightRdBtn.isSelected();
}

public void verifyandSelectLowPriceFlight() throws InterruptedException{ 

	Thread.sleep(1000);
	String deText1 =DepartFirstFlightPrice.getText();
	
	String x=deText1.split(" ")[1];
	String y = x. replace(",", "");
	int a=Integer.parseInt(y);
	
	DepartPriceFilter.click();
	String deText2 =DepartFirstFlightPrice.getText();
 
	String p=deText2.split(" ")[1];
	String q = p. replace(",", "");
	int b=Integer.parseInt(q);
	
	String reText1 =ReturnFirstFlightPrice.getText();

	String r=reText1.split(" ")[1];
	String s = r. replace(",", "");
	int c=Integer.parseInt(s);
	
	ReturnPriceFilter.click();
	String reText2 =ReturnFirstFlightPrice.getText();
	
	String u=reText2.split(" ")[1];
	String v = u. replace(",", "");
	int d=Integer.parseInt(v);
	
	ReturnPriceFilter.click();
	DepartPriceFilter.click();
	
	if(a < b && c < d) {
		Thread.sleep(3000);
		System.out.println(a+b+c+d);
		DepartFirstFlightRdBtn.click();
		ReturnFirstFlightPrice.click();
	}
	
}

public void clickBookNowBtn() throws InterruptedException {
	fare=TtlFare.getText();
	Thread.sleep(2000);
	BookNowBtn.click();
}

public void fareDetailVerification() throws InterruptedException {

	String u=fare.split(" ")[1];
	String v = u. replace(",", "");
	int a=Integer.parseInt(v);
	
	Thread.sleep(3000);
	String popUpFare=PopUpTtlFare.getText();
	String x=popUpFare.split(" ")[1];
	String y = x. replace(",", "");
	int b=Integer.parseInt(y);
	Assert.assertEquals(a, b);		
}

public void deptLocArriveLocDateVerification() {
	String depLoc = PopUpDeptloc.getText();
	Assert.assertEquals(depLoc, "Thiruvananthapuram to Mumbai");
	String rtnLoc = PopUpRtnloc.getText();
	Assert.assertEquals(rtnLoc, "Mumbai to Thiruvananthapuram");
	String depDte = PopUpDeptDte.getText();
	Assert.assertEquals(depDte, "Mon, 14 Jun");
	String rtnDte = PopUpRtnDte.getText();
	Assert.assertEquals(rtnDte, "Tue, 15 Jun");
}
}


