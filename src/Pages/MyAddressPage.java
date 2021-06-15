package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressPage
{
  WebDriver driver;
  WebElement updateButton;
  WebElement addNewAddressButton;
  WebElement deleteButton;
  WebElement textChangeAddressLabel;
  WebElement textNewAddress;

  public MyAddressPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getUpdateButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]/span"));
  }

  public WebElement getAddNewAddressButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
  }

  public WebElement getDeleteButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]/span"));
  }

  public WebElement getTextChangeAddressLabel()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]/span[1]"));
  }

  public WebElement getTextNewAddress()
  {
    String putanja = "//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3";

    if (driver.findElements(By.xpath(putanja)).size() > 0)
    {
      return driver.findElement(By.xpath(putanja));
    }
    else
    {
      return null;
    }
  }

  public void updateButtonClick()
  {
    getUpdateButton().click();
  }

  public void addButtonClick()
  {
    getAddNewAddressButton().click();
  }

  public void deleteButtonClick()
  {
    getDeleteButton().click();
  }

  public String textChangeAddressLabel()
  {
    return getTextChangeAddressLabel().getText();
  }

  public String textNewAddressLabel()
  {
    return getTextNewAddress().getText();
  }
}
