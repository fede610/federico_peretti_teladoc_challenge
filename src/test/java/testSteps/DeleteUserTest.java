package testSteps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTablePage;

public class DeleteUserTest {

	WebDriver driver = null;
	WebTablePage wTablePage = new WebTablePage(driver);
	final String url="https://www.way2automation.com/angularjs-protractor/webtables/";
	
	
	@Given("^Webtable page open$")
	public void openWebtablePage ()  {
		String currentUrl = wTablePage.openConection(url);
		Assertions.assertTrue(url.equals(currentUrl),"url dos not match");

	}
	
	@And("^The user name (.*) exists$")
	public void validateUserNameExistOnTable(String userName) {
	    Assertions.assertTrue(wTablePage.getValueOnTable(userName, 3), 
	    		"User name " + userName + " was found");		
	}
	
	@When("^The user delete the user (.*)$")
	public void deleteUserfromTable (String username) {
		wTablePage.click(wTablePage.getValueAndDeleteFromTable(username));
		wTablePage.click(wTablePage.getConfirmDeleteBtn());
	}

	@Then("^The user (.*) is deleted from the table$")
	public void validateUserNameWasDeleted(String userName) {
		Assertions.assertFalse(wTablePage.getValueOnTable(userName, 3),"UserName "+userName+" was deleted");
		wTablePage.closeConection();
	}
	

}
