package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTest extends BaseTest
{
  @BeforeMethod
  public void preSvakogTesta()
  {
    driver.navigate().to(homeUrl);
    //driver.manage().window().maximize();
  }
  
//  @Test(priority = 0)
//  public void updateAddress()
//  {
//    signIn();
//    myAccountPage.myAddressClick();
//    myAddressPage.updateButtonClick();
//    String address = readFromExcel.getStringData("TC6", 10, 3);
//    updateAddressPage.insertAddress(address);
//    updateAddressPage.saveButtonClick();
//    String textForAssertion = readFromExcel.getStringData("TC6", 20, 2);
//    String actualText = myAddressPage.textChangeAddressLabel();
//    assertEquals(actualText, textForAssertion);
//  }
  
  @Test(priority = 0)
  public void addNewAddress()
  {
    signIn();
    myAccountPage.myAddressClick();
    myAddressPage.addButtonClick();
    String address = readFromExcel.getStringData("TC7", 10, 3);
    updateAddressPage.insertAddress(address);
//    updateAddressPage.saveButtonClick();
//    String textForAssertion = readFromExcel.getStringData("TC6", 20, 2);
//    String actualText = myAddressPage.textChangeAddressLabel();
//    assertEquals(actualText, textForAssertion);
  }
  
  @AfterMethod
  public void posleSvakogTesta() throws InterruptedException
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
