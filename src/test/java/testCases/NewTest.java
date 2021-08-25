package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import data.ExcelDataProvider;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import master.Main;
import pageElements.FlightsPageElements;
import pageElements.HomePageElements;
import pageElements.QuizDetailPageElems;
import pageElements.TargetsPageElems;
import pageElements.BudgetPublishPageElems;
import pageElements.CampaignDetailPageElems;
import pageElements.CampaignTypePageElems;
import pageElements.CommonPageElems;
import pageElements.CreateCampaignPageElems;
import utils.Support;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
	Main main =new Main();
	CreateCampaignPageElems createCampaignPageElems;
	CommonPageElems commonPageElems;
	CampaignDetailPageElems campaignDetailPageElems;
	QuizDetailPageElems quizDetailPageElems;
	CampaignTypePageElems campaignTypePageElems;
	TargetsPageElems targetsPageElems;
	BudgetPublishPageElems budgetPublishPageElems;
	Support support;
	Properties prop =new Properties();
	String projPath =System.getProperty("user.dir");


  @Test
  public void f() throws InterruptedException, AWTException {
	  createCampaignPageElems =new CreateCampaignPageElems(driver);
	  commonPageElems= new CommonPageElems(driver);
	  campaignDetailPageElems=new CampaignDetailPageElems(driver);
	  quizDetailPageElems=new QuizDetailPageElems(driver);
	  campaignTypePageElems=new CampaignTypePageElems(driver);
	  targetsPageElems= new TargetsPageElems(driver);
	  budgetPublishPageElems=new BudgetPublishPageElems(driver);	  
	  support = new Support();
	  createCampaignPageElems.UserNameFld.sendKeys("medqwiz012@gmail.com");
	  createCampaignPageElems.PasswordFld.sendKeys("Admin@!@#$%");
	  createCampaignPageElems.SignInBtn.click();
	  Thread.sleep(3000);
	  commonPageElems.PopUpOkBtn.click();
	  createCampaignPageElems.CreateCampaignBtn.click();
	  createCampaignPageElems.PharmaNameDrpdwn.click();
	  Thread.sleep(3000);
	  createCampaignPageElems.PharmaName.click();
	  createCampaignPageElems.CampaignName.sendKeys("Cancer Awareness");
	  createCampaignPageElems.DiseaseOptn.click();
	  createCampaignPageElems.DiseaseNameFld.sendKeys("Cancer");
	  createCampaignPageElems.CampaignTagFld.sendKeys("Free cancer");
	  createCampaignPageElems.KolNameDrpdwn.click();
	  createCampaignPageElems.KolNameValue.click();
	  createCampaignPageElems.DescriptionTitleFld.sendKeys("Make a cancer free society");
	  createCampaignPageElems.BrandColorRed.click();
	  createCampaignPageElems.UploadVideoFld.click();
	  support.fileUpload(projPath+"\\Files\\Video.mp4");
	  createCampaignPageElems.CardLogoUploadFld.click();
	  support.fileUpload(projPath+"\\Files\\Logo.png");
	  Thread.sleep(3000);
	  createCampaignPageElems.SaveAndContinueBtn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  commonPageElems.PopUpOkBtn.click();
	  
	  campaignDetailPageElems.TestCardOptn.click();
	  campaignDetailPageElems.TestCardHeader.clear();
	  campaignDetailPageElems.TestCardHeader.sendKeys("sam");
	  campaignDetailPageElems.TestCardText.clear();
	  campaignDetailPageElems.TestCardText.sendKeys("Automation Tester");
	  commonPageElems.SaveAndContinueBtn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  commonPageElems.PopUpOkBtn.click();
	  
	  quizDetailPageElems.QuestionFld.sendKeys("What is your name");
	  quizDetailPageElems.ExplanationFld.sendKeys("ael");
	  quizDetailPageElems.FalseOptn.click();
	  commonPageElems.SaveAndContinueBtn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  commonPageElems.PopUpOkBtn.click();
	  
	  campaignTypePageElems.NormalOptn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  commonPageElems.PopUpOkBtn.click();
	  
	  targetsPageElems.CreateAudianceBtn.click();
	  targetsPageElems.DemographicsOptn.click();
	  targetsPageElems.ContinueBtn.click();
	  Thread.sleep(3000);
	  commonPageElems.SaveAndContinueBtn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  commonPageElems.PopUpOkBtn.click();
	  
	  budgetPublishPageElems.SaveAndPublishBtn.click();
	  budgetPublishPageElems.EnterDrawBtn.click();
	  Thread.sleep(3000);
	  budgetPublishPageElems.DoneBtn.click();
  }

  @BeforeClass
  public void beforeClass() {
	
	 
  }

  @AfterClass
  public void afterClass() {
	// driver.quit();
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browser)throws IOException {
	  String url="https://medqwiz.devtomaster.com/";
	  driver= main.driver(browser, url);
  }

  @AfterTest
  public void afterTest() {
  }


}
