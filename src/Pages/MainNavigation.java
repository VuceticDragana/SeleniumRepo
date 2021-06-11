package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation
{
  WebDriver driver;
  WebElement logInTab;
  
  public MainNavigation(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getLogInTab()
  {
    return driver.findElement(By.linkText("Sign in"));
  }
  
  public void LogInClick()
  {
    getLogInTab().click();
  }
}
