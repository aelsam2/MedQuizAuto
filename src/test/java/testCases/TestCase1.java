package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import data.ExcelDataProvider;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import master.Main;
import pageElements.FlightsPageElements;
import pageElements.HomePageElements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestCase1 {
	WebDriver driver;
	Main main =new Main();
	HomePageElements homePageElems;
	FlightsPageElements flightPageElems;
	ExcelDataProvider dP =new ExcelDataProvider();
	
  @Test( dataProvider="tD1" )
  public void f(String fromCity, String toCity) throws InterruptedException {
	  
//Step 1: Verify IndiGo flights are displayed between Trivandrum to Mumbai for two adults and one child
//passengers in round trip.
	  flightPageElems = new FlightsPageElements(driver);
	  flightPageElems.selectFromCity(fromCity);
	  flightPageElems.selectToCity(toCity);
	  flightPageElems.selectDate();
	  flightPageElems.selectTravellers();
	  flightPageElems.clickSearchBtn();
	  flightPageElems.assertIndigoFlights();
	  
//Step 2: Verify flights with less fare are selected and click book now
	  flightPageElems.SlctLowPriceFlightsAndVerfySlction();
	  flightPageElems.clickBookNowBtn();
	  
//Verify Fare details displayed near Book Now button is same as total price displayed in continue
//popup. Also, verify departure location, arrival location and date in the popup.	 
	  flightPageElems.fareDetailVerification();
	  flightPageElems.deptLocArriveLocDateVerification();
	  
  }

 

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  homePageElems = new HomePageElements(driver);
	  if(driver.findElements( By.xpath("//div[@data-cy='outsideModal']") ).size() != 0)
	   {
		  homePageElems.loginPopUpClose();
		  }else
		  {
			  homePageElems.FlightIcon.click();
		  }
	  homePageElems.clickFlightIcon();
	  Thread.sleep(2000);
  }

  @AfterMethod
  public void afterMethod() {
	  
  }


  @DataProvider(name="tD1")
  public Object[][] dp() throws IOException {
	  String excelPath="C:\\Users\\aelsa\\eclipse-workspace\\makemytrip\\DataSheet\\Data.xlsx";
		 String sheetName="Sheet1";
	  Object data[][]=dP.testData(excelPath,sheetName);	  
	return data;
   
  }
  @BeforeClass
  public void beforeClass() {
	
	 
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browser)throws IOException {
	  String url="https://www.makemytrip.com/";
	  driver= main.driver(browser, url);
  }

  @AfterTest
  public void afterTest() {
  }


}
