package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage
{
  WebDriver driver;
  WebElement textBlouseLabel;
  WebElement textPrintedDressLabel;
  WebElement textPrintedSummerDressLabel;
  WebElement plusSignQty;
  WebElement QtyLabel;
  WebElement deleteButton;
  WebElement textEmptyCartLabel;

  public CartPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getTextBlouseLabel()
  {
    return driver.findElement(By.linkText("Blouse"));
  }

  public WebElement getTextPrintedDressLabel()
  {
    return driver.findElement(By.linkText("Printed Dress"));
  }

  public WebElement getTextPrintedSummerDressLabel()
  {
    return driver.findElement(By.linkText("Printed Summer Dress"));
  }

  public WebElement getPlusSignQty()
  {
    return driver.findElement(By.className("icon-plus"));
  }

  public WebElement getQtyLabel()
  {
    return driver.findElement(By.xpath("//*[@id=\"product_2_7_0_520461\"]/td[5]/input[1]"));
  }

  public WebElement getDeleteButton()
  {
    return driver.findElement(By.className("icon-trash"));
  }

  public WebElement getTextEmptyCartLabel()
  {
    return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
  }

  public String textBlouseLabel()
  {
    return getTextBlouseLabel().getText();
  }

  public String textPrintedDressLabel()
  {
    return getTextPrintedDressLabel().getText();
  }

  public String textPrintedSummerDressLabel()
  {
    return getTextPrintedSummerDressLabel().getText();
  }

  public void plusSignQtyClick()
  {
    getPlusSignQty().click();
  }

  public String textQtyLabel()
  {
    return getQtyLabel().getAttribute("value");
  }

  public void deleteButtonClick()
  {
    getDeleteButton().click();
  }

  public String textEmptyCartLabel()
  {
    return getTextEmptyCartLabel().getText();
  }
}
