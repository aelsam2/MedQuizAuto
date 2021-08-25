package pageElements;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class BudgetPublishPageElems {
			WebDriver PageElemsdriver;
			public  BudgetPublishPageElems(WebDriver driver) {
				PageFactory.initElements( driver, this);
				PageElemsdriver=driver;
				
			}
			
			//button[contains(text(),"Enter Draw")]
			@FindBy(xpath="//span[contains(text(),\"Save and Publish\")]")
			public WebElement SaveAndPublishBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Enter Draw\")]")
			public WebElement EnterDrawBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Done\")]")
			public WebElement DoneBtn;
		}


