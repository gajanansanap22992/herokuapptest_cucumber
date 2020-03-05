package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HerokuappPage;

/*
 * This step definition contains function call which call the method in page class
 * and return result and check if it is expected behavior.
 * 
 * it describes the functionality of the each step of feature file
 * 
 */

public class Herokuapp_StepDefinition extends TestBase {

	
	HerokuappPage dealpage = new HerokuappPage();
	String title;
	String sku;
	String description;

	public Herokuapp_StepDefinition() throws IOException {
		super();

	}

	@io.cucumber.java.en.Given("^user is on the page$")
	public void user_is_on_the_page() throws Throwable {
		// dealpage.getUrl("https://ajinkya-hiwale.herokuapp.com/admin");
		System.out.println("Test case to be failed");
		Assert.assertEquals(true, false);

	}
	
	@Given("^user is on the website$")
	public void user_is_on_the_website() throws Throwable {
		// dealpage.getUrl("https://ajinkya-hiwale.herokuapp.com/admin");
		String url = TestBase.getPropertyValue("url");
		dealpage.getUrl(url);

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String email, String password) throws Throwable {
		dealpage.login(TestBase.getPropertyValue(email), TestBase.getPropertyValue(password));
	}

	@When("^User enters invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_invalid_and(String arg1, String arg2) throws Throwable {

		dealpage.login("email", "pwd");
	}

	@When("^user enter blank user Id and password$")
	public void user_enter_blank_user_Id_and_password() throws Throwable {
		dealpage.login("", "");
	}

	@Then("^should be navigated to home page$")
	public void he_should_be_navigated_to_home_page() throws Throwable {
		Assert.assertEquals("Signed in successfully.", dealpage.homepageMessage());
	}

	@Then("^Error message \"([^\"]*)\" should get displayed$")
	public void error_message_should_get_displayed(String msg) throws Throwable {

		Assert.assertEquals(msg, dealpage.verifyWrongCredentialsErrorMessage());
	}

	@When("^Click on Products$")
	public void click_on_Products() throws Throwable {
		dealpage.clickOnProductsLink();
	}

	@When("^Click on New Product button$")
	public void click_on_New_Product_button() throws Throwable {
		dealpage.clickOnNewProduct();
	}

	@When("^Enter Title,Sku and Description value as Blank$")
	public void enter_Title_Sku_and_Description_value_as_Blank() throws Throwable {
		dealpage.createNewProduct("", "", "");
		dealpage.clickOnCreateProdcut();
	}

	@Then("^Error message should be visible for all three fields$")
	public void error_message_should_be_visible_for_all_three_fields() throws Throwable {

		dealpage.verifyBlankFeldMessages();
	}

	@When("^User Enters duplicate Title or sku$")
	public void user_Enters_duplicate_Title_or_sku() throws Throwable {
		// dealpage.clickOnNewProduct();
		dealpage.createNewProduct("ajinkya", "ajinkya", "ajinkya");
		dealpage.clickOnCreateProdcut();

	}

	@Then("^Error message for duplicate \"([^\"]*)\" should be displayed$")
	public void error_message_for_duplicate_should_be_displayed(String msg) throws Throwable {
		dealpage.verifyDuplicateNameMessages(msg);

	}

	@When("^Enter Unique values of Title,Sku and Description$")
	public void enter_Unique_values_of_Title_Sku_and_Description() throws Throwable {

		String Text = CommonMethods.uniqueElement();
		title = "Title of the product is " + Text;
		sku = "sku" + Text;
		description = "Produt name is " + Text;
		dealpage.createNewProduct(title, sku, description);
	}

	@When("^click on Create Product$")
	public void click_on_Create_Product() throws Throwable {
		dealpage.clickOnCreateProdcut();
	}

	@Then("^Update the product by updating values of Title,Sku and Description$")
	public void update_the_product_by_updating_values_of_Title_Sku_and_Description() throws Throwable {
		dealpage.clickOnProductsLink();
		dealpage.clickOnEdit();
		String Text = CommonMethods.uniqueElement();
		title = "Title of the product is " + Text;
		sku = "sku" + Text;
		description = "Produt name is " + Text;
		dealpage.updateProduct();
	}

	@Then("^check Products are listed and get all values$")
	public void check_Products_are_listed_and_get_all_values() throws Throwable {
		dealpage.clickOnProductsLink();
		dealpage.getProductData();
	}

	@Then("^click on Delete$")
	public void click_on_Delete() throws Throwable {
		dealpage.clickOnProductsLink();
		dealpage.deleteProduct();
	}

	@Then("^click on Logout$")
	public void click_on_Logout() throws Throwable {

	}

	@Then("^New Prodcut gets created and verify it \"([^\"]*)\"$")
	public void new_Prodcut_gets_created_and_verify_it(String msg) throws Throwable {
		Assert.assertEquals(msg, dealpage.homepageMessage());
	}

	@Then("^check if value got updated \"([^\"]*)\"$")
	public void check_if_value_got_updated(String msg) throws Throwable {
		Assert.assertEquals(msg, dealpage.homepageMessage());
	}

	@Then("^check if product got deleted \"([^\"]*)\"$")
	public void check_if_product_got_deleted(String msg) throws Throwable {
		Assert.assertEquals(msg, dealpage.homepageMessage());
	}

}
