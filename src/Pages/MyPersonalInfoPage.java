package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage
{
  WebDriver driver;
  WebElement lastNameField;
  WebElement passworsField;
  WebElement saveButton;
  WebElement updateInfoLabel;
  WebElement backToAccount;

  public MyPersonalInfoPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getLastNameField()
  {
    return driver.findElement(By.id("lastname"));
  }

  public WebElement getPassworsField()
  {
    return driver.findElement(By.id("old_passwd"));
  }

  public WebElement getSaveButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span"));
  }

  public WebElement getUpdateInfoLabel()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
  }

  public WebElement getBackToAccount()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a/span"));
  }

  public void insertLastName(String ln)
  {
    getLastNameField().clear();
    getLastNameField().sendKeys(ln);
  }

  public void insertPassword(String password)
  {
    getPassworsField().clear();
    getPassworsField().sendKeys(password);
  }

  public void saveButtonClick()
  {
    getSaveButton().click();
  }

  public String textUpdateInfoLabel()
  {
    return getUpdateInfoLabel().getText();
  }

  public void backToAccountClick()
  {
    getBackToAccount().click();
  }
}
