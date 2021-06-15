package Test;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest
{
  @BeforeMethod
  public void preSvakogTesta()
  {
    driver.navigate().to(homeUrl);
    driver.manage().window().maximize();
  }

  @Test(priority = 0)
  public void addWishlist()
  {
    signIn();
    myAccountPage.myWishlistClick();
    String listName = readFromExcel.getStringData("TC9", 8, 3);
    myWishlistPage.insertWishlistName(listName);
    myWishlistPage.saveButtonClick();

    String textForAssertion = readFromExcel.getStringData("TC9", 20, 2);
    String actualText = myWishlistPage.textWishListNameLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 5)
  public void deleteWishlist()
  {
    signIn();
    myAccountPage.myWishlistClick();
    myWishlistPage.deleteButtonClick();

    try
    {
      Robot r = new Robot();
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);
      Thread.sleep(3000);

    } catch (Exception e1)
    {
      e1.printStackTrace();
    }

    WebElement actualResult = myWishlistPage.getWishlistNameLabel();
    assertEquals(actualResult, null);
  }

  @Test(priority = 0)
  public void addmultipleWishlist()
  {
    signIn();
    myAccountPage.myWishlistClick();
    String listName1 = readFromExcel.getStringData("TC11", 8, 3);
    myWishlistPage.insertWishlistName(listName1);
    myWishlistPage.saveButtonClick();

    String listName2 = readFromExcel.getStringData("TC11", 10, 3);
    myWishlistPage.insertWishlistName(listName2);
    myWishlistPage.saveButtonClick();

    String listName3 = readFromExcel.getStringData("TC11", 12, 3);
    myWishlistPage.insertWishlistName(listName3);
    myWishlistPage.saveButtonClick();

    String textForAssertion1 = readFromExcel.getStringData("TC11", 20, 2);
    String actualText1 = myWishlistPage.textLista1();
    assertEquals(actualText1, textForAssertion1);

    String textForAssertion2 = readFromExcel.getStringData("TC11", 20, 3);
    String actualText2 = myWishlistPage.textLista2();
    assertEquals(actualText2, textForAssertion2);

    String textForAssertion3 = readFromExcel.getStringData("TC11", 20, 4);
    String actualText3 = myWishlistPage.textLista3();
    assertEquals(actualText3, textForAssertion3);
  }

  @AfterMethod
  public void posleSvakogTesta()
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
