package testSteps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.WebTablePage;


public class AddUserTest {

	WebDriver driver = null;
	WebTablePage wTablePage = new WebTablePage(driver);
	final String url="https://www.way2automation.com/angularjs-protractor/webtables/";


	
	@Given("^Webtable page is open$")
	public void openWebtablePage ()  {
		wTablePage.openConection(url);
	}
		@When("^The user add a new user (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
	public void theUserAddANewUser (
			String firstName,
			String lastName,
			String userName,
			String password,
			String customer,
			String role,
			String email,
			String cellphone) {		   
		   
		wTablePage.getAddUserBtn().click();
		//TODO ver si es visible
		
		wTablePage.setFirstName(firstName);
		wTablePage.setLastName(lastName);
		wTablePage.setUserName(userName);
		wTablePage.setPassword(password);
		wTablePage.setCustomer(customer);
		wTablePage.setRol(role);
		wTablePage.setEmail(email);
		wTablePage.setMobilePhone(cellphone);
		
		//TODO Validar boton isEnable
		wTablePage.getSaveBtn().click();		
	    
	}
	
	
	//validateThatUserWasAddedTotheTable
	@Then("^The user is displayed on the table (.*)$")
	public void validateThatUserWasAddedTotheTable(String userName) {
		//TODO Agregar assertion
		System.out.println("userName is present= " + wTablePage.getValueOnTable(userName, 3));
	    
	}
	
	@After
	public void tearDown() {
		wTablePage.closeConection(driver);
	}

	
	}

	