
package Base_Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage
{
	public WebDriver driver;
	
	By Login=By.xpath("//button[@type='submit']");
	
	By CategoryDropdown=By.xpath("/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]");
	By CategoryMenuClick=By.xpath("//p[normalize-space()='Categories']");
	
	By AddNewCategory=By.xpath("//a[@class='btn btn-primary']");
	By ToggleButtonBasic=By.xpath("//span[@class='onoffswitch-inner']");
	By CategoryName=By.xpath("//input[@id='Name']");
	
	
	public CategoriesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnCatalogMenuAndCategory()
	{
		WebElement CatDropdown=driver.findElement(CategoryDropdown);
		CatDropdown.click();
		WebElement CategoryMenu=driver.findElement(CategoryMenuClick);
		CategoryMenu.click();
	}
	public void AddNewCategoryAsBasic()
	{
	
		//First Click on Add New button for adding new catgory
		WebElement ClickAddNew=driver.findElement(AddNewCategory);
		ClickAddNew.click();
		
		//Click on Toggle button to switch Basic Mode first
		WebElement ToggleBasic=driver.findElement(ToggleButtonBasic);
		ToggleBasic.click();
		
		WebElement name=driver.findElement(CategoryName);
		name.sendKeys("TestProduct");
	}
	public void AddNewCategoryAsAdvacnced()
	{
		//By Default, its New Category as Advance so no ned to click on toggle button
		
	}
	
	
}
