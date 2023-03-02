package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cartFeature {
	WebDriver driver;
	@Given("user is on homepage")
	public void user_is_on_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		WebElement loginText = driver.findElement(By.cssSelector(".title"));
		String actualText = loginText.getText();
		
		System.out.println(actualText);
		
		String expText = "Products";
		Assert.assertEquals(actualText, expText);
	}
	@When("user navigates to the product needed")
	public void user_navigates_to_the_product_needed() {
		WebElement prodButton;

		prodButton = driver.findElement(By.cssSelector("button[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
		prodButton.click();
	}
	@When("user clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();

	}
	@Then("user can see the product is added into application")
	public void user_can_see_the_product_is_added_into_application() {
		WebElement quantity = driver.findElement(By.cssSelector(".cart_quantity"));
		String actualQuantity = quantity.getText();
		String expectedQunatity = "1";
		
		System.out.println(actualQuantity);
		
		Assert.assertEquals(actualQuantity, expectedQunatity);

		WebElement productText = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
		String actualText = productText.getText();
		String expectedText = "Sauce Labs Bolt T-Shirt";
		Assert.assertEquals(actualText, expectedText);
		driver.close();
	}
	
}
