package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.CommonMethods;
import stepDefinitions.Hooks;


public class HerokuappPage extends CommonMethods {

	WebDriver driver;

	public HerokuappPage() {
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='admin_user_submit_action']/input")
	WebElement login;

	@FindBy(xpath = "//*[@id='admin_user_email']")
	WebElement email;

	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div")
	WebElement messages;

	@FindBy(xpath = "//*[@id='admin_user_password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='products']/a")
	WebElement productsLink;

	@FindBy(xpath = "//*[@id=\"titlebar_right\"]/div/span/a")
	WebElement newProductButton;

	@FindBy(xpath = "//a[@title='View']")
	WebElement view;

	@FindBy(xpath = "//a[@title='Edit']")
	WebElement edit;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement delete;

	@FindBy(xpath = "//input[@id='product_title']")
	WebElement title;

	@FindBy(xpath = "//*[@id='product_sku']")
	WebElement sku;

	@FindBy(xpath = "//*[@value='Create Product']")
	WebElement createproduct;

	@FindBy(xpath = "//*[@id='product_description']")
	WebElement description;

	@FindBy(xpath = "//*[@value=\"Update Product\"]")
	WebElement updateProductButton;

	@FindBy(xpath = "//td[@class='col col-title']")
	List<WebElement> titlelist;

	@FindBy(xpath = "//*[@id='content_wrapper']/div[1]")
	WebElement erroMessageonLoginPage;
	
	@FindBy(xpath="//table//tbody/tr")
	List<WebElement> totalrows;
	
	@FindBy(xpath="//table//tbody/tr/td")
	List<WebElement> elements;
	
	@FindBy(xpath="//p[@class='inline-errors']")
	List<WebElement> fieldErrormessge;
	
	/*
	 * @login enter email id and password and click on login
	 */

	public void login(String emailid, String pwd) throws InterruptedException {
		email.clear();
		email.sendKeys(emailid);
		password.clear();
		password.sendKeys(pwd);
		login.click();

	}
	
	/*
	 * it will navigate to provided url
	 */

	public void getUrl(String url) {
		driver.get(url);
	}
	
	/*
	 * it will return  actual message 
	 */

	public String homepageMessage() {
		return messages.getText().trim();
	}

	
	/*
	 * it will return  actual message 
	 */
	public String verifyWrongCredentialsErrorMessage() {
		return erroMessageonLoginPage.getText().trim();
	}

	
	/*
	 * Method to get the title of  the page 
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOnProductsLink() {
		productsLink.click();
	}

	public void clickOnNewProduct() {
		newProductButton.click();
	}

	
	/*
	 * Providing data for the title sku and description  to create new product 
	 */
	public void createNewProduct(String title1, String sku1, String desc1) {

		title.sendKeys(title1);
		sku.sendKeys(sku1);
		description.sendKeys(desc1);

	}
	
	/*
	 * clicking on createproduct 
	 */

	public void clickOnCreateProdcut() {
		createproduct.click();
	}
	
	/*
	 * Clicking on edit button 
	 */

	public void clickOnEdit() {
		edit.click();
	}
	
	/*
	 * Updating product 
	 */

	public void updateProduct() {
		updateProductButton.click();
	}
	
	
	/*
	 * Deleting product 
	 */
	public void deleteProduct()
	{
	delete.click();
	Alert alt=driver.switchTo().alert();
	alt.accept();
	}
	
	
	/*
	 *  this will get and print all Products data
	 */
	public void getProductData()
	{
		int rowsize=totalrows.size();
		int elementssize=elements.size();
		int j=1;
		for(int i=0;i<=rowsize;i++)
		{
			
			System.out.print("Id:"+elements.get(1).getText()+" ");
			System.out.print("Title:"+elements.get(2).getText()+" ");
			System.out.print("Sku:"+elements.get(3).getText()+" ");
			System.out.print("Description:"+elements.get(4).getText()+" ");
			System.out.print("Created:"+elements.get(5).getText()+" ");
			System.out.print("Updated:"+elements.get(6).getText() +" ");
			System.out.println();
			}
		}
	
	
	
	/*
	 * It is verifying actual and expected error message when we \
	 * enter Blank data while creating product 
	 */
	public void verifyBlankFeldMessages()
	{
		for(int i=0;i<fieldErrormessge.size();i++)
		{
			Assert.assertEquals("can't be blank",fieldErrormessge.get(i).getText().trim() );
		}
	}
	
	/*
	 * It is verifying actual and expected error message when we 
	 * enter duplicate data while creating product 
	 */
	public void verifyDuplicateNameMessages(String msg)
	{
		for(int i=0;i<fieldErrormessge.size()-1;i++)
		{
			Assert.assertEquals(msg,fieldErrormessge.get(i).getText().trim() );
		}
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		

