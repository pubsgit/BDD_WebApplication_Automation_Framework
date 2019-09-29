package pageobjects;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

@RunWith(Cucumber.class)
public class TwoItemmsCheckout extends base {

	public WebDriver driver;
	public 
	Properties prop = new Properties();
	
    @Before
    public void setup() throws IOException {
    	System.out.println("Setup");
    	driver =initializeDriver();
    }
    
    
    @Given("^User is on \"([^\"]*)\" home page$")
    public void user_is_on_home_page(String arg1)  throws Throwable {
    	System.out.println("user_is_on_home_page");
		System.out.println("goToNswHomePage: HELLLOEEEE");
		FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);		
		String homepageurl = arg1;
		driver.get(homepageurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		String homepagetitle = prop.getProperty("sitehomepage");
		Assert.assertEquals(driver.getTitle(), homepagetitle);
		System.out.println("Done with user_is_on_home_page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String FullHomepageloaded=prop.getProperty("Homepageloaded");
		WebDriverWait waitsearchnumberplatelink=new WebDriverWait(driver, 30);
		waitsearchnumberplatelink.until(ExpectedConditions.elementToBeClickable(By.xpath(FullHomepageloaded)));
	}
    		     	
    
    @When("^Adds two items to the cart and proceeds to checkout$")
    public void adds_two_items_to_the_cart_and_proceeds_to_checkout() throws Throwable {
    	System.out.println("adds_two_items_to_the_cart_and_proceeds_to_checkout");
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		WebDriverWait itemswait=new WebDriverWait(driver, 3);		
		String item1=prop.getProperty("itemone");
		String item2=prop.getProperty("itemtwo");
		String checkout=prop.getProperty("prcd_checkout");
		String con_shp_btn=prop.getProperty("cont_shop_btn");
		Actions movemouse = new Actions(driver);		
		System.out.println("Select item1");
		movemouse.moveToElement(driver.findElement(By.xpath(item1))).build().perform();
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(item1)));						
		String item1button=prop.getProperty("itemonebutton");		
		movemouse.moveToElement(driver.findElement(By.xpath(item1button))).click().build().perform();
		System.out.println("Selected item1button before");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(con_shp_btn)));
		movemouse.moveToElement(driver.findElement(By.xpath(con_shp_btn))).click().build().perform();
		System.out.println("Selected item1button after");		
		System.out.println("Select item2");	
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(item2)));
		movemouse.moveToElement(driver.findElement(By.xpath(item2))).build().perform();
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(item2)));
		String item2button=prop.getProperty("itemtwobutton");		
		movemouse.moveToElement(driver.findElement(By.xpath(item2button))).click().build().perform();
		System.out.println("Selected item2button after");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkout)));
		movemouse.moveToElement(driver.findElement(By.xpath(checkout))).click().build().perform();		
    }

    
    @And("^Verify shopping cart summary contains two items and proceeds to checkout$")
    public void verify_shopping_cart_summary_contains_two_items_and_proceeds_to_checkout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("verify_shopping_cart_summary_contains_two_items_and_proceeds_to_checkout");
    	WebDriverWait itemswait=new WebDriverWait(driver, 3);    	
    	FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
    	String checkout=prop.getProperty("chkout_btn");
		prop.load(webelementsfile);
		String two_items=prop.getProperty("no_of_prodcts");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(two_items)));
    	String no_of_items=driver.findElement(By.xpath(two_items)).getText();
    	FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		String exp_no_products=prop.getProperty("twoitemsadded");
    	Assert.assertEquals(no_of_items, exp_no_products);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
    	itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkout)));
		driver.findElement(By.xpath(checkout)).click();
    }

    @And("^Authenticates using existing login credentials username (.+) and password (.+)$")
    public void authenticates_using_existing_login_credentials_username_and_password(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("authenticates_using_existing_login_credentials_username_and_password");
		
		
    	FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		String pagetitle = prop.getProperty("lpg_title");
		Assert.assertEquals(driver.getTitle(), pagetitle);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		WebDriverWait itemswait=new WebDriverWait(driver, 3);
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String email_id = prop.getProperty("emailid");
		String paswd = prop.getProperty("password");
		String signin_btn = prop.getProperty("signin_btn");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(email_id)));
		driver.findElement(By.xpath(email_id)).sendKeys(username);
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(paswd)));
		driver.findElement(By.xpath(paswd)).sendKeys(password);
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(signin_btn)));
		driver.findElement(By.xpath(signin_btn)).click();

		
    }

    @And("^Use default address and proceed to checkout$")
    public void use_default_address_and_proceed_to_checkout() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("use_default_address_and_proceed_to_checkout");
    	FileInputStream datafile = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(datafile);
		String pagetitle = prop.getProperty("adr_pg_title");
		Assert.assertEquals(driver.getTitle(), pagetitle);
		
		WebDriverWait itemswait=new WebDriverWait(driver, 3);
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String adr_checkout_btn = prop.getProperty("adr_ckt_btn");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(adr_checkout_btn)));
		driver.findElement(By.xpath(adr_checkout_btn)).click();
    }

    @And("^Agrees to Shipping terms of service$")
    public void agrees_to_Shipping_terms_of_service() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("agrees_to_Shipping_terms_of_service");   	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");		
		WebDriverWait itemswait=new WebDriverWait(driver, 10);
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String shp_tick = prop.getProperty("shp_chk_box");
		Actions movemouse = new Actions(driver);
		movemouse.moveToElement(driver.findElement(By.xpath(shp_tick))).click().build().perform();
		System.out.println("Checkbox: " +  driver.findElement(By.xpath(shp_tick)).isSelected());		
		String shp_checkout = prop.getProperty("shp_checkout");
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(shp_checkout)));
		driver.findElement(By.xpath(shp_checkout)).click();		
    }

    @And("^Selects Pay by bank wire as the payment method$")
    public void selects_Pay_by_bank_wire_as_the_payment_method() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("selects_Pay_by_bank_wire_as_the_payment_method");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");		
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String pay_wire_select=prop.getProperty("bnk_wire");	
		WebDriverWait itemswait=new WebDriverWait(driver, 10);
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(pay_wire_select)));
		driver.findElement(By.xpath(pay_wire_select)).click();
		
    }

    @And("^Confirms the order$")
    public void confirms_the_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("confirms_the_order");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String smr_ckt=prop.getProperty("ord_smry_chkt");
		WebDriverWait itemswait=new WebDriverWait(driver, 10);
		itemswait.until(ExpectedConditions.elementToBeClickable(By.xpath(smr_ckt)));
		driver.findElement(By.xpath(smr_ckt)).click();
    }

    @Then("^Gets the Order Confirmation$")
    public void gets_the_Order_Confirmation() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("gets_the_Order_Confirmation");
    	FileInputStream webelementsfile = new FileInputStream("src\\main\\java\\resources\\webelementlocations.properties");
		prop.load(webelementsfile);
		String order_confirmation=prop.getProperty("ord_cnfrm");
		driver.getPageSource().contains(order_confirmation);

    }
    
    @After
    public void Teardown() {
    	System.out.println("Teardown");
    	driver.quit();
    }

}
