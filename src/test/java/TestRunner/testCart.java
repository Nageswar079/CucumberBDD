package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Pavilion\\eclipse-workspace-Selenium\\cucumberBDDPractice\\src\\test\\resources\\Feature\\Cart.feature",
		glue="stepDefinitions", // here we can give no.of packages as per the requirement as glue={"packageName1","pn2","pn3",..}
		plugin= {"pretty","html:target/HTMLreports/report.html"} //used to generate cucumber test reports
		)
public class testCart {

}
