package testCases;

import org.testng.annotations.Test;

import master.Main;
import pageElements.HolidaysPageElements;
import pageElements.HomePageElements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestCase2 {
	WebDriver driver;
	Main main =new Main();
	HomePageElements homePageElems;
	HolidaysPageElements holidaysPageElems;
	 
  @Test
  public void f() throws InterruptedException {
	  //Verify Kerala is displayed under Domestic Destinations in Holidays functionality.
	  holidaysPageElems =new HolidaysPageElements(driver);
	  holidaysPageElems.AssertKeralaUndrDomstcDestn();
	  
      //Click on Kerala and choose “Best Ever Getaway Deals!”
	  holidaysPageElems.ClickKeralaOption();
	  
	  //Apply filters like 4*, With Flights and Allepey (in places)
	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(newTab.get(1));
	
	  Thread.sleep(7000);
	  if(driver.findElements( By.xpath("//a[contains(text(),'Next')]") ).size() != 0) {

		 holidaysPageElems.selectBestEverGateWayDetailsOptn();
		  holidaysPageElems.selectFourStarFilter1();

		  holidaysPageElems.selectWithFlightFilter1();
		  holidaysPageElems.selectAllepyPlace1();
           holidaysPageElems.selectAPackage1();
           ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(newTab1.get(2));
		  Thread.sleep(3000);
		  holidaysPageElems.verifyThePackageListedPerFilters();

		  
		  }
	  else {

		  Assert.assertEquals(true, holidaysPageElems.addMoreFilterBtn.isDisplayed());
		  holidaysPageElems.selectFourStarFilter();
		/*  holidaysPageElems.selectWithFlightFilter();
		  holidaysPageElems.selectAllepyPlace();
		  holidaysPageElems.selectAPackage();
		  
		  driver.switchTo().window(newTab.get(2));
		  Thread.sleep(3000);
		  holidaysPageElems.verifyThePackageListedPerFilters(); */
			

	  }
	  //Verify displayed result is as per filter selection
	    }
	
	    

  @BeforeMethod
  public void beforeMethod() throws InterruptedException{
	  homePageElems = new HomePageElements(driver);
	  if(driver.findElements( By.xpath("//div[@data-cy='outsideModal']") ).size() != 0)
	   {
		  homePageElems.loginPopUpClose();
		  }else
		  {
			  homePageElems.FlightIcon.click();
		  }
	 
	  homePageElems.HolidaysIcon.click();

	  Thread.sleep(4000);
		  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  @BeforeClass
  public void beforeClass() {
	
	 
  }
  public void afterClass() {
	
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browser)throws IOException {
	  String url="https://www.makemytrip.com/";
	  driver= main.driver(browser, url);
  }

}
