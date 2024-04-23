package testSteps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.WebTablePage;

public class AddUserTest {

	WebDriver driver = null;
	WebTablePage wTablePage = new WebTablePage(driver);
	final String url = "https://www.way2automation.com/angularjs-protractor/webtables/";

	@Given("^Webtable page is open$")
	public void openWebtablePage() {
		String currentUrl = wTablePage.openConection(url);
		Assertions.assertTrue(url.equals(currentUrl), "url dos not match");
	}

	@When("^The user add a new user (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
	public void theUserAddANewUser(String firstName, String lastName, String userName, String password, String customer,
			String role, String email, String cellphone) {
		
		Assertions.assertTrue(wTablePage.getVisibility(wTablePage.getAddUserBtn()));
		wTablePage.click(wTablePage.getAddUserBtn());

		wTablePage.setFirstName(firstName);
		wTablePage.setLastName(lastName);
		wTablePage.setUserName(userName);
		wTablePage.setPassword(password);
		wTablePage.setCustomer(customer);
		wTablePage.setRol(role);
		wTablePage.setEmail(email);
		wTablePage.setMobilePhone(cellphone);
		
		Assertions.assertTrue(wTablePage.getVisibility(wTablePage.getSaveBtn()));
		Assertions.assertTrue(wTablePage.getState(wTablePage.getSaveBtn()));
		wTablePage.click(wTablePage.getSaveBtn());

	}

	@Then("^The user is displayed on the table (.*)$")
	public void validateThatUserWasAddedTotheTable(String userName) {
		Assertions.assertTrue(wTablePage.getValueOnTable(userName, 3), "userName " + userName + "was inserted");
		wTablePage.closeConection();
	}

}
