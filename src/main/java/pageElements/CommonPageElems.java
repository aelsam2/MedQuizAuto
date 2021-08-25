package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class CommonPageElems {
		WebDriver PageElemsdriver;
		public  CommonPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//button[contains(text(),\"OK\")]")
		public WebElement PopUpOkBtn;
		
		@FindBy(xpath="//span[contains(text(),\"Save and Continue\")]")
		public WebElement SaveAndContinueBtn;
		
	}