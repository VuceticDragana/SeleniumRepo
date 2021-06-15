package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTest extends BaseTest
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
    myAccountPage.myPersonalInfoClick();
    String lastName = readFromExcel.getStringData("TC12", 9, 3);
    myPersonalInfoPage.insertLastName(lastName);
    String password = readFromExcel.getStringData("TC12", 10, 3);
    myPersonalInfoPage.insertPassword(password);
    myPersonalInfoPage.saveButtonClick();
    
    String textForAssertion = readFromExcel.getStringData("TC12", 20, 2);
    String actualText = myPersonalInfoPage.textUpdateInfoLabel();
    assertEquals(actualText, textForAssertion);
    
    myPersonalInfoPage.backToAccountClick();
    
    myAccountPage.myPersonalInfoClick();
    String lastName2 = readFromExcel.getStringData("TC12", 15, 3);
    myPersonalInfoPage.insertLastName(lastName2);
    String password2 = readFromExcel.getStringData("TC12", 16, 3);
    myPersonalInfoPage.insertPassword(password2);
    myPersonalInfoPage.saveButtonClick();
  }
  
  @AfterMethod
  public void posleSvakogTesta()
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
