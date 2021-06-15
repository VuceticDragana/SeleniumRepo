package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage
{
  WebDriver driver;
  WebElement wishlistNameField;
  WebElement saveButton;
  WebElement wishlistNameLabel;
  WebElement deleteButton;
  WebElement lista1;
  WebElement lista2;
  WebElement lista3;

  public MyWishlistPage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public WebElement getWishlistNameField()
  {
    return driver.findElement(By.id("name"));
  }

  public WebElement getSaveButton()
  {
    return driver.findElement(By.xpath("//*[@id=\"submitWishlist\"]/span"));
  }

  public WebElement getWishlistNameLabel()
  {
    String putanja = "Moja lista zelja";

    if (driver.findElements(By.linkText(putanja)).size() > 0)
    {
      return driver.findElement(By.linkText(putanja));
    }
    else
    {
      return null;
    }
  }

  public WebElement getDeleteButton()
  {
    return driver.findElement(By.className("icon"));
  }

  public WebElement getLista1()
  {
    return driver.findElement(By.linkText("Lista1"));
  }

  public WebElement getLista2()
  {
    return driver.findElement(By.linkText("Lista2"));
  }

  public WebElement getLista3()
  {
    return driver.findElement(By.linkText("Lista3"));
  }

  public void insertWishlistName(String name)
  {
    getWishlistNameField().clear();
    getWishlistNameField().sendKeys(name);
  }

  public void saveButtonClick()
  {
    getSaveButton().click();
  }

  public String textWishListNameLabel()
  {
    return getWishlistNameLabel().getText();
  }

  public void deleteButtonClick()
  {
    getDeleteButton().click();
  }

  public String textLista1()
  {
    return getLista1().getText();
  }

  public String textLista2()
  {
    return getLista2().getText();
  }

  public String textLista3()
  {
    return getLista3().getText();
  }
}
