package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import util.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageSteps extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	
	@Given("user opens browser")
	public void user_opens_browser() throws IOException {
		TestBase.initialization();
		loginpage = new LoginPage();
	    
	}
	
	
	@Then("user is on login page")
	public void user_is_on_login_page() {
	   String title = loginpage.validationLoginPageTitle();
	   Assert.assertEquals("Cogmento CRM", title);
	}
	
	
	@Then("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException, IOException {
	 
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Then("validate home page title")
	public void validate_home_page_title() {
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("Cogmento CRM", homeTitle);
	}
	
	
	@Then("validate logged in username")
	public void validate_logged_in_username() {
	    boolean flag = homePage.verifyCorrectUserName();
	    Assert.assertTrue(flag);
	}
	
	@Then("^user quit$")
	public void user_quit() throws Throwable {
	  loginpage.closeBrowser();
	}
}
