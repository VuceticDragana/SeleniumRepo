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
  WebElement myWishlistButton;
  WebElement myPersonalInfotButton;
  WebElement homeButton;

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

  public WebElement getMyWishlistButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
  }

  public WebElement getMyPersonalInfotButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
  }

  public WebElement getHomeButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a/span"));
  }

  public String textSignInLabel()
  {
    return getMyAccountLabel().getText();
  }

  public void signOutClick()
  {
    getSignOut().click();
  }

  public void myAddressClick()
  {
    getMyAddressButton().click();
  }

  public void myWishlistClick()
  {
    getMyWishlistButton().click();
  }

  public void myPersonalInfoClick()
  {
    getMyPersonalInfotButton().click();
  }

  public void homeButtonClick()
  {
    getHomeButton().click();
  }
}
