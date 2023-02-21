package testNGBasic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethodTestNG {
protected WebDriver driver=null;
	public void getDriverInstance(String BrowserName) {
		switch(BrowserName) {
		case "chrome":  WebDriverManager.chromedriver().setup();
		                driver=new ChromeDriver();
		                driver.manage().window().maximize();
		                break;
		case "firefox":   WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    break;              
		  default: System.out.println("please enter the correct Browser");              }
	}
	public void correctlogin() {
		
		getDriverInstance("chrome");
		driver.get("https://login.salesforce.com/");
			//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("hi@tekarch.com");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Tryhard2work");
		By ob1=By.id("Login");
		WebElement login=driver.findElement(ob1);
		login.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	public  void close() {
		//driver=new ChromeDriver();
		driver.close();
	}
	public void url(String url) {
		driver.get(url);
	}
public void screenshot() throws IOException {
String date= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
String curdir=System.getProperty("user.dir");
	TakesScreenshot obj=(TakesScreenshot)driver;
	File image=obj.getScreenshotAs(OutputType.FILE);
	File file=new File(curdir+"/Screenshots/"+date+".png");
	FileHandler.copy(image, file);
}
	}
		



		




