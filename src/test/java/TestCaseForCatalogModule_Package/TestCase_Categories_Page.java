package TestCaseForCatalogModule_Package;

import org.testng.annotations.Test;
import Base_Package.BaseClass_Browser;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestCase_Categories_Page extends BaseClass_Browser
{
	public WebDriver driver;
  @Test
  public void TestcaseForAddNewCategory()
  {
    CategoriesPage Cat1=CategoriesPage(driver);
	 // CategoriesPage Cat=new CategoriesPage(driver);
	  Cat.ClickOnCatalogMenuAndCategory();
	  Cat.AddNewCategoryAsBasic();
    
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  BaseClass_Browser Base=new BaseClass_Browser();
	  Base.Setup_Browser();
  }

  @AfterMethod
  public void afterMethod()
  {
  }

}
