package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest
{
  @BeforeMethod
  public void preSvakogTesta()
  {
    driver.navigate().to(homeUrl);
    driver.manage().window().maximize();
  }

  @Test(priority = 0)
  public void signInValidCredentials()
  {    
    String email = readFromExcel.getStringData("TC1", 9, 3);
    String password = readFromExcel.getStringData("TC1", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC1", 20, 2);
    logInFormFilling(email, password);    
    String actualText = myAccountPage.textSignInLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 5)
  public void signInInvalidEmailValidPassword()
  {
    String email = readFromExcel.getStringData("TC2", 9, 3);
    String password = readFromExcel.getStringData("TC2", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC2", 20, 2);
    logInFormFilling(email, password);
    String actualText = authenticationPage.texterrorInvalidEmailLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 15)
  public void signInValidEmailInvalidPassword()
  {
    String email = readFromExcel.getStringData("TC3", 9, 3);
    String password = readFromExcel.getStringData("TC3", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC3", 20, 2);
    logInFormFilling(email, password);
    String actualText = authenticationPage.texterrorInvalidPasswordLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 20)
  public void signInEmptyFields()
  {
    String email = readFromExcel.getStringData("TC4", 9, 3);
    String password = readFromExcel.getStringData("TC4", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC4", 20, 2);
    logInFormFilling(email, password);
    String actualText = authenticationPage.texterrorEmptyLabel();
    assertEquals(actualText, textForAssertion);
  }

  @Test(priority = 25)
  public void signOut()
  {
    String email = readFromExcel.getStringData("TC5", 9, 3);
    String password = readFromExcel.getStringData("TC5", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC5", 20, 2);
    logInFormFilling(email, password);
    myAccountPage.signOutClick();
    String actualText = authenticationPage.textSignInLabel();
    assertEquals(actualText, textForAssertion);
  }

  @AfterMethod
  public void posleSvakogTesta() throws InterruptedException
  {
    driver.manage().deleteAllCookies();
    driver.navigate().refresh();
  }
}
