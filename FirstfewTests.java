package testNGBasic;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(testNGBasic.MyListeners.class)
public class FirstfewTests extends BaseMethodTestNG {
	@BeforeMethod
	public void startup(Method method) 
	{
		System.out.println("Started testscript:" +method.getName());
		getDriverInstance("chrome");	
	}
	@AfterMethod 
	public void endup() {
		
	close();	
	}
	@Test(priority=1,enabled=true)
	public void missedpassword() throws InterruptedException, IOException{

		String expected="Please enter your password.";
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		By ob=By.id("username");
		WebElement username=driver.findElement(ob);
	    username.sendKeys("User@gmail.com");
		By ob1=By.id("Login");
		WebElement login=driver.findElement(ob1);
		login.click();
		WebElement text=driver.findElement(By.id("error"));
		String actual=text.getText();
		Assert.assertEquals(actual, expected);
		screenshot();
		}

	@Test(priority=3,enabled=true)
	private void checkRememberMe() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	String expected="hi@tekarch.com";
	driver.get("https://login.salesforce.com/");
	Thread.sleep(5000);
	By ob=By.id("username");
	WebElement username=driver.findElement(ob);
	username.sendKeys("hi@tekarch.com");
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("Tryhard2work");
	WebElement rememberme=driver.findElement(By.id("rememberUn"));
	rememberme.click();
	By ob1=By.id("Login");
	WebElement login=driver.findElement(ob1);
	login.click();
	Thread.sleep(5000);
	WebElement logout=driver.findElement(By.id("userNavLabel"));
	logout.click();
	WebElement logout1=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	logout1.click();
	Thread.sleep(5000);
	WebElement username1=driver.findElement(By.id("idcard-identity"));
	String actual =username1.getText();
	Assert.assertEquals(actual, expected);
	screenshot();
	}
	
	@Test(priority=4,enabled=true)
	private void forgotPasswordA() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		By ob=By.id("username");
		WebElement username=driver.findElement(ob);
	username.sendKeys("hi@tekarch.com");
	WebElement forgot =driver.findElement(By.id("forgot_password_link"));
	forgot.click();
	String expected="Forgot Your Password";
	WebElement Title=driver.findElement(By.id("header"));
	String actual=Title.getText();
	Assert.assertEquals(actual, expected);
	screenshot();
	}
	@Test(priority=5,enabled=true)
	private  void forgotpasswordB() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("123");
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("22131");
	WebElement login=driver.findElement(By.id("Login"));
	login.click();
	WebElement error=driver.findElement(By.id("error"));
	String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String actual=error.getText();
	Assert.assertEquals(actual, expected);}

}
