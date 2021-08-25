package pageAction;

import pageElements.FlightsPageElements;

public class LoginPageAction {
	FlightsPageElements flightPageElems;
	
	public void enter_UserName(String Username) {
		flightPageElems.BookNowBtn.sendKeys(Username);
	}
	public void enter_Password(String password) {
		flightPageElems.BookNowBtn.sendKeys(password);
	}
	public void click_LoginBtn() {
		flightPageElems.BookNowBtn.click();
	}
}
