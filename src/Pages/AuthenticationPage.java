package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage
{
  WebDriver driver;
  WebElement emailField;
  WebElement passwordField;
  WebElement signInButton;
  WebElement errorInvalidEmail;
  WebElement errorInvalidPassword;
  WebElement errorEmpty;

  public AuthenticationPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getEmailField()
  {
    return driver.findElement(By.id("email"));
  }

  public WebElement getPasswordField()
  {
    return driver.findElement(By.id("passwd"));
  }

  public WebElement getSignInButton()
  {
    return driver.findElement(By.id("SubmitLogin"));
  }

  public WebElement getErrorInvalidEmail()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
  }

  public WebElement getErrorInvalidPassword()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
  }

  public WebElement getErrorEmpty()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
  }

  public void insertEmail(String email)
  {
    getEmailField().clear();
    getEmailField().sendKeys(email);
  }

  public void insertPassword(String password)
  {
    getPasswordField().clear();
    getPasswordField().sendKeys(password);
  }

  public void signInClick()
  {
    getSignInButton().click();
  }

  public String texterrorInvalidEmailLabel()
  {
    return this.getErrorInvalidEmail().getText();
  }

  public String texterrorInvalidPasswordLabel()
  {
    return this.getErrorInvalidPassword().getText();
  }

  public String texterrorEmptyLabel()
  {
    return this.getErrorEmpty().getText();
  }

  public String textSignInLabel()
  {
    return this.getSignInButton().getText();
  }
}
