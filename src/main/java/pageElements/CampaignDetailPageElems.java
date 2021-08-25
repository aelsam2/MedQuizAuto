package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class CampaignDetailPageElems {
		WebDriver PageElemsdriver;
		public  CampaignDetailPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
	@FindBy(xpath="//p[contains(text(),\"Text Card\")]")
	public WebElement TestCardOptn;
	
	@FindBy(xpath="//input[@name=\"textHeader\"]")
	public WebElement TestCardHeader;
	
	@FindBy(xpath="//textarea[@name=\"text\"]")
	public WebElement TestCardText;
	
}

