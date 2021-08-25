package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {
	WebDriver homePageElemsdriver;
	public  HomePageElements(WebDriver driver) {
		PageFactory.initElements( driver, this);
		homePageElemsdriver=driver;
		
	}
	
@FindBy(xpath="//div[@data-cy='outsideModal']")
public WebElement LoginPopUpClose;

@FindBy(className="menu_Flights")
public WebElement FlightIcon;

@FindBy(className="menu_Holidays")
public WebElement HolidaysIcon;

@FindBy(xpath="//li[@data-cy=\"account\"]")
public WebElement LoginDrpDwn;

@FindBy(xpath="//input[@data-cy=\"userName\"]")
public WebElement EmailField;

@FindBy(xpath="//input[@data-cy=\"userName\"]")
public WebElement EmailContinueBtn;

@FindBy(xpath="//input[@data-cy=\"password\"]")
public WebElement PasswordField;

@FindBy(xpath="//button[@data-cy=\"login\"]")
public WebElement LoginBtn;

public void loginPopUpClose() {
	if(LoginPopUpClose.isDisplayed()) {
		LoginPopUpClose.click();
	}
	else {
		HolidaysIcon.click();
	}
	
}

public void clickFlightIcon() {
	FlightIcon.click();
}
public void clickHolidaysIcon() {
	HolidaysIcon.click();
}

}

