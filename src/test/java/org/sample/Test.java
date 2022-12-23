package org.sample;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
public static void main(String[] args) throws Throwable {
	//System.setProperty("Webdriver.edge.driver","C:\Users\Niranjanee\eclipse-workspace\MavenProject\target\selenium-edge-driver-4.7.1.jar");
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	//driver.get("https://www.facebook.com/");
	String url="https://www.facebook.com/";
	driver.navigate().to(url);
	driver.manage().window().maximize();
	
	driver.navigate().back();
	Thread.sleep(2000);
	
	driver.navigate().forward();
	Thread.sleep(2000);
	
	driver.navigate().refresh();
	
	String currenturl= driver.getCurrentUrl();
	if(currenturl.equals(url)) {
		System.out.println("Correct URL");
		}
	else {
		System.out.println("Incorrect URL");
	}
	
	String title= driver.getTitle();
	System.out.println(title);
	
	WebElement user=driver.findElement(By.id("email"));
	user.sendKeys("Selenium");
	
	WebElement pass=driver.findElement(By.name("pass"));
	pass.sendKeys("123456789");
	
	String attribute=pass.getAttribute("value");
	System.out.println(attribute);
	

	
	List<WebElement> itag =driver.findElements(By.tagName("a"));
	for(int i=0; i<itag.size(); i++) {
		WebElement x=itag.get(i);
		String text=x.getText();
		System.out.println(text);
		}
	
	//WebElement link=driver.findElement(By.linkText("Log in"));
	//String text=link.getText();
	//System.out.println(text);
	//link.click();
	
	WebElement link=driver.findElement(By.partialLinkText("log"));
	String text=link.getText();
	System.out.println(text);
	
	
	
	driver.quit();
	
}
}
