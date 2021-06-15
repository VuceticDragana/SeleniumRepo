package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation
{
  WebDriver driver;
  WebElement logInTab;
  WebElement addBlouse;
  WebElement printedDress;
  WebElement printedSummerDress;
  WebElement proceedToCheckout;
  WebElement continueShopping;

  public MainNavigation(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getLogInTab()
  {
    return driver.findElement(By.linkText("Sign in"));
  }

  public WebElement getAddBlouse()
  {
    return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));
  }

  public WebElement getPrintedDress()
  {
    return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span"));
  }

  public WebElement getPrintedSummerDress()
  {
    return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span"));
  }

  public WebElement getProceedToCheckout()
  {
    return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
  }

  public WebElement getContinueShopping()
  {
    return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
  }

  public void LogInClick()
  {
    getLogInTab().click();
  }

  public void addBlouseToCartClick()
  {
    getAddBlouse().click();
  }

  public void addPrintedDressClick()
  {
    getPrintedDress().click();
  }

  public void addPrintedSummerDressClick()
  {
    getPrintedSummerDress().click();
  }

  public void proceedToCheckoutClick()
  {
    getProceedToCheckout().click();
  }

  public void continueShoppingClick()
  {
    getContinueShopping().click();
  }

}
