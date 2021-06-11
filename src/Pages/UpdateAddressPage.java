package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateAddressPage
{
  WebDriver driver;
  WebElement addressField;
  WebElement saveButton;
  WebElement cityField;
  WebElement stateField;
  WebElement zipField;
  WebElement mobPhpneField;
  
  public UpdateAddressPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getAddressField()
  {
    return driver.findElement(By.id("address1"));
  }  
  
  public WebElement getSaveButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"submitAddress\"]/span"));
  }  

  public WebElement getCityField()
  {
    return driver.findElement(By.id("city"));
  }

  public WebElement getStateField()
  {
    return stateField;
  }

  public WebElement getZipField()
  {
    return driver.findElement(By.id("postcode"));
  }

  public WebElement getMobPhpneField()
  {
    return driver.findElement(By.id("phone_mobile"));
  }

  public void insertAddress(String address)
  {
    getAddressField().clear();
    getAddressField().sendKeys(address);
  }
  
  public void saveButtonClick()
  {
    getSaveButton().click();
  }
}
