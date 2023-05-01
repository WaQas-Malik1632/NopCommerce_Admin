package Base_Package;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Browser
{
	static  WebDriver driver;
	String Url="https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	
//	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	LocalDateTime date = LocalDateTime.now();
	
	 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH-mm-ss");
	 String formattedDate = date.format(myFormatObj);
	
	public WebDriver Setup_Browser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		
		//Just click on Login button on the Admin Login page
		 WebElement LoginClick=driver.findElement(By.xpath("//button[@type='submit']"));
		 LoginClick.click();
		 return driver;
	}
 	public WebDriver Setup_HeadlessBrowser()
	{
 		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("-incognito");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get(Url);
		driver.manage().window().maximize();  
		return driver;
	}
 	//Take Screenshot
 	public WebDriver TakeScreenshot(WebDriver webdriver, String filename) throws IOException
	{   
		TakesScreenshot src=((TakesScreenshot)webdriver);
		File srcfile =src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File(".//Screenshot//" +formattedDate+filename+".png"));
		return webdriver;
	}

}
