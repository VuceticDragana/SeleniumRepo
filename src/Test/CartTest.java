package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest
{
  @BeforeMethod
  public void preSvakogTesta()
  {
    driver.navigate().to(homeUrl);
    driver.manage().window().maximize();
  }

  @Test(priority = 0)
  public void AddOneProductToCart()
  {
    signIn();
    myAccountPage.homeButtonClick();
    mainNavigation.addBlouseToCartClick();
    mainNavigation.proceedToCheckoutClick();
    String textForAssertion = readFromExcel.getStringData("TC13", 20, 2);
    String actualText = cartPage.textBlouseLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 5)
  public void AddTreeProductToCart() throws InterruptedException
  {
    signIn();
    myAccountPage.homeButtonClick();
    mainNavigation.addBlouseToCartClick();
    mainNavigation.proceedToCheckoutClick();
    cartPage.plusSignQtyClick();
    cartPage.plusSignQtyClick();
    Thread.sleep(5000);
    String textForAssertion = readFromExcel.getStringData("TC14", 20, 2);
    boolean actualText = cartPage.textQtyLabel().contains(textForAssertion);
    assertEquals(actualText, true);
  }

  @Test(priority = 10)
  public void AddMultipleProductToCart()
  {
    signIn();
    myAccountPage.homeButtonClick();
    mainNavigation.addBlouseToCartClick();
    mainNavigation.continueShoppingClick();
    mainNavigation.addPrintedDressClick();
    mainNavigation.continueShoppingClick();
    mainNavigation.addPrintedSummerDressClick();
    mainNavigation.proceedToCheckoutClick();

    String textForAssertion1 = readFromExcel.getStringData("TC15", 20, 2);
    String actualText1 = cartPage.textBlouseLabel();
    assertEquals(actualText1, textForAssertion1);

    String textForAssertion2 = readFromExcel.getStringData("TC15", 20, 3);
    String actualText2 = cartPage.textPrintedDressLabel();
    assertEquals(actualText2, textForAssertion2);

    String textForAssertion3 = readFromExcel.getStringData("TC15", 20, 4);
    String actualText3 = cartPage.textPrintedSummerDressLabel();
    assertEquals(actualText3, textForAssertion3);
  }

  @Test(priority = 15)
  public void DeleteProductToCart() throws InterruptedException
  {
    signIn();
    myAccountPage.homeButtonClick();
    mainNavigation.addBlouseToCartClick();
    mainNavigation.proceedToCheckoutClick();
    cartPage.deleteButtonClick();
    Thread.sleep(1000);
    String textForAssertion = readFromExcel.getStringData("TC16", 20, 2);
    String actualText = cartPage.textEmptyCartLabel();
    assertEquals(actualText, textForAssertion);
  }

  @AfterMethod
  public void posleSvakogTesta()
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
