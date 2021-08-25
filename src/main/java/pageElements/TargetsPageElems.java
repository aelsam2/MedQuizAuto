package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class TargetsPageElems {
		WebDriver PageElemsdriver;
		public  TargetsPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//span[contains(text(),\"Create Audience\")]")
		public WebElement CreateAudianceBtn;
		
		@FindBy(xpath="//div[contains(text(),\"Demographics\")]")
		public WebElement DemographicsOptn;
		
		@FindBy(xpath="//span[contains(text(),\"Continue\")]")
		public WebElement ContinueBtn;
	}