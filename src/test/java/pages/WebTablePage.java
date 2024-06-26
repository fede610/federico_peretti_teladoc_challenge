package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebTablePage extends Base {

	public WebTablePage(WebDriver driver) {
		super(driver);
	}

	By firstName = By.name("FirstName");
	By lastName = By.name("LastName");
	By userName = By.name("UserName");
	By password = By.name("Password");
	By email = By.name("Email");
	By cellPhone = By.name("Mobilephone");
	By selectRol = By.name("RoleId");
	By close = By.xpath("//button[@class='btn btn-danger']");
	By save = By.xpath("//button[@class='btn btn-success']");
	By addUser = By.xpath("//button[@type='add']");
	By NextPageParent = By.xpath("//li/a[text()='>']/..");
	By NextPage = By.xpath("//li/a[text()='>']/..");
	By fullTable = By.xpath("//tbody");
	By userNameCol = By.xpath("//tr/td[3]");

	By confirmDeleteBtn = By.xpath("//button[@class='btn ng-scope ng-binding btn-primary']");
	By cancelDeleteBtn = By.xpath("//button[@class='btn ng-scope ng-binding']");

	public String openConection(String url) {
		browserDriverConnection();
		String currentUrl = getPage(url);
		return currentUrl;
	}

	public WebElement getAddUserBtn() {
		WebElement addBtn = findElement(addUser);
		return addBtn;
	}

	public void setFirstName(String fName) {
		clear(firstName);
		sendKeys(fName, firstName);
	}

	public void setLastName(String lName) {
		clear(lastName);
		sendKeys(lName, lastName);
	}

	public void setUserName(String uName) {
		clear(userName);
		sendKeys(uName, userName);
	}

	public void setPassword(String pass) {
		clear(password);
		sendKeys(pass, password);
	}

	public void setEmail(String mail) {
		clear(email);
		sendKeys(mail, email);
	}

	public void setMobilePhone(String cel) {
		clear(cellPhone);
		sendKeys(cel, cellPhone);
	}

	public void setCustomer(String customer) {
		clickElement(By.xpath("//label[normalize-space()='" + customer + "']"));
	}

	public void setRol(String rol) {
		Select selectRolObject = new Select(findElement(selectRol));
		List<WebElement> allElements = selectRolObject.getOptions();
		for (WebElement option : allElements) {
			if (option.getText().equalsIgnoreCase(rol))
				option.click();
		}
	}

	public WebElement getSaveBtn() {
		WebElement saveBtn = findElement(save);
		return saveBtn;
	}
	
	public void click(WebElement element) {
		clickElement(element);
	}

	public String getNextPageBtnParent() {
		String NextPageParentBtnAttribute = findElement(NextPageParent).getAttribute("class");
		return NextPageParentBtnAttribute;
	}

	public WebElement getNextPage() {
		WebElement NextPageBtn = findElement(NextPage);
		return NextPageBtn;
	}

	public WebElement getTable() {
		WebElement table = findElement(fullTable);
		return table;
	}

	public List<WebElement> getElementsTableRows(WebElement table, int colNumber) {
		List<WebElement> rows = table.findElements(By.xpath("//tr/td[" + colNumber + "]"));
		return rows;
	}

	public WebElement getRowBtn(WebElement row, int colNumber) {
		WebElement rowBtn = row.findElement(By.xpath("//tr[]/td[" + colNumber + "]/button"));
		return rowBtn;
	}

	public boolean getValueOnTable(String userName, Integer colum) {
			do{
			List<WebElement> rows = getElementsTableRows(getTable(), colum);
			for (WebElement row : rows) {
				System.out.println(row.getText());
				if (row.getText().equals(userName)) {
					System.out.println("User name '" + row.getText() + "' found on table");
					return true;
				}
			}
			if (getNextPageBtnParent().equals("ng-scope")) {
				clickElement(getNextPage());
				System.out.println("Next page");
				}
				else {
					System.out.println("User name '" + userName + "' not found on table");
					return false;
				}
		}while (true);
	}

	public WebElement getValueAndDeleteFromTable(String username) {
		WebElement userFoundElement = findElement(By
				.xpath("//table/tbody/tr/td[3][normalize-space()='" + username + "']/following-sibling::td[8]/button"));
		return userFoundElement;
	}

	public WebElement getConfirmDeleteBtn() {
		WebElement confirmBtn = findElement(confirmDeleteBtn);
		return confirmBtn;
	}
	
	public Boolean isDisplayed(WebElement element) {
		return isDisplayed(element);
	}
	
	public Boolean isEnabled(WebElement element) {
		return isEnabled(element);
	}

	public void closeConection() {
		closeBrowser();
	}

}
