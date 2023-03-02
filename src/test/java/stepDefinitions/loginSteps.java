package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver;
	@Given("user is on loginpage")
	public void user_is_on_loginpage() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	   }

	@When("user enters correct username and password")
	public void user_enters_correct_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		
	}
	@When("user enters correct {string} and {string}")
	public void user_enters_correct_and(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		
	    }

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.cssSelector("#login-button")).click();
	}

	@Then("user is logged into application")
	public void user_is_logged_into_application() {
		WebElement lableEle=driver.findElement(By.cssSelector(".app_logo"));
		System.out.println("Homepage logo "+lableEle.isDisplayed());
		driver.close();
	}
	
	@Then("user validates the login functionality based on the {string}")
	public void user_validates_the_login_functionality_based_on_the(String testDataType) {
		if(testDataType.equals("valid")) {
			WebElement loginText=driver.findElement(By.cssSelector(".title"));
			String actualText=loginText.getText();
			String expText="PRODUCTS";
			Assert.assertEquals(actualText, expText);
			
		}
		else {
			WebElement errText=driver.findElement(By.xpath("//h3[@data-test='error']"));
			String errTextActual=errText.getText();
			String errTextExpected="Epic sadface: Username and password do not match any user in this service";
			Assert.assertEquals(errTextActual, errTextExpected);
			
		}
		driver.quit();
	   }
	}
