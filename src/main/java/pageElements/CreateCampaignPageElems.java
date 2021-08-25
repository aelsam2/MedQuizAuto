package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPageElems {
	WebDriver PageElemsdriver;
	public  CreateCampaignPageElems(WebDriver driver) {
		PageFactory.initElements( driver, this);
		PageElemsdriver=driver;
		
	}
	
@FindBy(xpath="//input[@name='username']")
public WebElement UserNameFld;

@FindBy(xpath="//input[@name='password']")
public WebElement PasswordFld;

@FindBy(xpath="//button[@type='submit']")
public WebElement SignInBtn;

@FindBy(xpath="//button[@class=\"contentCampaign\"]")
public WebElement CreateCampaignBtn;

@FindBy(xpath="//input[@name=\"pharmaName\"]")
public WebElement PharmaNameDrpdwn;

@FindBy(xpath="//div[@id=\"pharmaoptionsTab\"]//p[contains (text(),\"Yety\")]")
public WebElement PharmaName;

@FindBy(xpath="//input[@placeholder=\"Enter campaign name\"]")
public WebElement CampaignName;

@FindBy(xpath="//p[contains(text(),\"Disease\")]")
public WebElement DiseaseOptn;

@FindBy(xpath="//input[@name=\"disease\"]")
public WebElement DiseaseNameFld;

@FindBy(xpath="//input[@placeholder=\"Ex: Drug class\"]")
public WebElement CampaignTagFld;

@FindBy(xpath="//input[@name=\"kolName\"]")
public WebElement KolNameDrpdwn;

@FindBy(xpath="(//div[@id=\"koloptionsTab\"]//p[@class=\"pharmaOptions\"])[1]")
public WebElement KolNameValue;

@FindBy(xpath="//input[@name=\"kollink\"]")
public WebElement DescriptionTitleFld;

@FindBy(xpath="//div[@title=\"#EB5757\"]")
public WebElement BrandColorRed;

@FindBy(xpath="//label[contains(text(),\"Upload Video\")]/div[@class=\"fake-uploader\"]")
public WebElement UploadVideoFld;

@FindBy(xpath="//label[contains(text(),\"Card Logo\")]/div[@class=\"fake-uploader\"]")
public WebElement CardLogoUploadFld;

@FindBy(xpath="//button[@type=\"submit\"]")
public WebElement SaveAndContinueBtn;
}