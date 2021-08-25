package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class QuizDetailPageElems {
		WebDriver PageElemsdriver;
		public  QuizDetailPageElems(WebDriver driver) {
			PageFactory.initElements( driver, this);
			PageElemsdriver=driver;
			
		}
		
		@FindBy(xpath="//span[contains(text(),\"True or false\")]")
		public WebElement TrueOrFalseQuizStyle;
		
		@FindBy(xpath="//textarea[@name=\"question\"]")
		public WebElement QuestionFld;
		
		@FindBy(xpath="//textarea[@name=\"text\"]")
		public WebElement ExplanationFld;
		
		@FindBy(xpath="//div[@class=\"trueOrFalseOpitions\"]/span/p[contains(text(),\"True\")]")
		public WebElement FalseOptn;
		
	}