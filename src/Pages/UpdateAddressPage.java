package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateAddressPage
{
  WebDriver driver;
  WebElement addressField;
  WebElement saveButton;
  WebElement cityField;
  WebElement stateField;
  WebElement zipField;
  WebElement mobPhpneField;
  WebElement addressTitle;

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
    return driver.findElement(By.id("id_state"));
  }

  public WebElement getZipField()
  {
    return driver.findElement(By.id("postcode"));
  }

  public WebElement getMobPhpneField()
  {
    return driver.findElement(By.id("phone_mobile"));
  }

  public WebElement getAddressTitle()
  {
    return driver.findElement(By.id("alias"));
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

  public void insertCity(String city)
  {
    getCityField().clear();
    getCityField().sendKeys(city);
  }

  public void insertState(String st)
  {
    Select state = new Select(getStateField());
    state.selectByVisibleText(st);
  }

  public void insertZip(String zip)
  {
    getZipField().clear();
    getZipField().sendKeys(zip);
  }

  public void insertMobilePhone(String mp)
  {
    getMobPhpneField().clear();
    getMobPhpneField().sendKeys(mp);
  }

  public void insertAddressTitle(String title)
  {
    getAddressTitle().clear();
    getAddressTitle().sendKeys(title);
  }
}
