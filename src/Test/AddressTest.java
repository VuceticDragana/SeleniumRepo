package Test;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTest extends BaseTest
{
  @BeforeMethod
  public void preSvakogTesta()
  {
    driver.navigate().to(homeUrl);
    driver.manage().window().maximize();
  }

  @Test(priority = 0)
  public void updateAddress()
  {
    signIn();
    myAccountPage.myAddressClick();
    myAddressPage.updateButtonClick();
    String address = readFromExcel.getStringData("TC6", 10, 3);
    updateAddressPage.insertAddress(address);
    updateAddressPage.saveButtonClick();
    String textForAssertion = readFromExcel.getStringData("TC6", 20, 2);
    String actualText = myAddressPage.textChangeAddressLabel();
    assertEquals(actualText, textForAssertion);    
    
    myAddressPage.updateButtonClick();
    address = readFromExcel.getStringData("TC6", 15, 3);
    updateAddressPage.insertAddress(address);
    updateAddressPage.saveButtonClick();
  }

  @Test(priority = 5)
  public void addNewAddress()
  {
    signIn();
    myAccountPage.myAddressClick();
    myAddressPage.addButtonClick();
    String address = readFromExcel.getStringData("TC7", 9, 3);
    String city = readFromExcel.getStringData("TC7", 10, 3);
    String state = readFromExcel.getStringData("TC7", 11, 3);
    String zip = readFromExcel.getStringData("TC7", 12, 3);
    String mobilePhone = readFromExcel.getStringData("TC7", 14, 3);
    String title = readFromExcel.getStringData("TC7", 15, 3);
    updateAddressPage.insertAddress(address);
    updateAddressPage.insertCity(city);
    updateAddressPage.insertState(state);
    updateAddressPage.insertZip(zip);
    updateAddressPage.insertMobilePhone(mobilePhone);
    updateAddressPage.insertAddressTitle(title);
    updateAddressPage.saveButtonClick();
    String textForAssertion = readFromExcel.getStringData("TC7", 20, 2);
    String actualText = myAddressPage.textNewAddressLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 10)
  public void deleteAddress()
  {
    signIn();
    myAccountPage.myAddressClick();
    myAddressPage.deleteButtonClick();

    try
    {
      Robot r = new Robot();
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);
      Thread.sleep(1000);

    } catch (Exception e1)
    {
      e1.printStackTrace();
    }    

    WebElement asd = myAddressPage.getTextNewAddress();    
    assertEquals(asd, null);
  }

  @AfterMethod
  public void posleSvakogTesta()
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
