import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	
	WebDriver driver =new ChromeDriver();
	String username= "standard_user";
	String password ="secret_sauce";
	String Thewebsite ="https://www.saucedemo.com";
	
	
	@BeforeTest
	public void SetUp () {
		driver.get(Thewebsite);
		driver.manage().window().maximize();
	}
	
	
	
	
    @Test(priority=1)
	public void LogIn() throws InterruptedException{
    	
    	WebElement TheUserName=  driver.findElement(By.id("user-name"));
    	TheUserName.sendKeys(username);
    	Thread.sleep(1000);
    	WebElement ThePassWord=driver.findElement(By.id("password"));
    	ThePassWord.sendKeys(password);
		Thread.sleep(1000);
		WebElement EnterButton =driver.findElement(By.id("login-button"));
		EnterButton.click();
		
    }
	
    @Test(priority=2)
  
    public void AddTocart() throws InterruptedException {
    	
    	List<WebElement> AddElements= driver.findElements(By.className("btn"));
    	
    	for (int i=0 ; i<AddElements.size() ;i++) 
    	{
    		AddElements.get(i).click();
    		Thread.sleep(1000);
    		
    	}
    	
    	
    	
    }
    @Test(priority=3)
    public void Cart() {
    	
    	WebElement MyCart= driver.findElement(By.className("shopping_cart_link"));
    	MyCart.click();
    	
    }
    
    @Test(priority=4)
    public void RemoveFromCart () throws InterruptedException {
    	List<WebElement> RemoveElements= driver.findElements(By.className("btn"));
    	
    	for (int r=0 ; r <RemoveElements.size() ; r++) {
    		RemoveElements.get(r).click();
    		Thread.sleep(1000);
    	}
    }
    
    
	@AfterTest
	public void PostTesting() {
		
		
	}
	
	
	
	
	
	
	
	
	

}
