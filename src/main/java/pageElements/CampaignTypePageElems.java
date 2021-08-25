package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class CampaignTypePageElems {
		WebDriver PageElemsdriver;
		public  CampaignTypePageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//span[contains(text(),\"Normal\")]")
		public WebElement NormalOptn;
		
		
	}