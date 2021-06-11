package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage
{
  WebDriver driver;
  WebElement myAccountLabel;
  WebElement signOut;
  WebElement myAddressButton;
  
  public MyAccountPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getMyAccountLabel()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
  }
  
  public WebElement getSignOut()
  {
    return driver.findElement(By.linkText("Sign out"));
  }  
  
  public WebElement getMyAddressButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
  }

  public String textSignInLabel()
  {
    return this.getMyAccountLabel().getText();
  }
  
  public void signOutClick()
  {
    getSignOut().click();
  }
  
  public void myAddressClick()
  {
    getMyAddressButton().click();
  }
}
