package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.AuthenticationPage;
import Pages.MainNavigation;
import Pages.MyAccountPage;
import Pages.MyAddressPage;
import Pages.UpdateAddressPage;

public class BaseTest
{
  WebDriver driver;
  MainNavigation mainNavigation;
  AuthenticationPage authenticationPage;
  String homeUrl;
  ExcelReader readFromExcel;
  MyAccountPage myAccountPage;
  MyAddressPage myAddressPage;
  UpdateAddressPage updateAddressPage;
  
  @BeforeClass
  public void preSihTestova() throws IOException
  {
    System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    mainNavigation = new MainNavigation(driver);
    authenticationPage = new AuthenticationPage(driver);
    homeUrl = "http://automationpractice.com/index.php";
    readFromExcel =  new ExcelReader("Tests/Project.xlsx");    
    myAccountPage = new MyAccountPage(driver);
    myAddressPage = new MyAddressPage(driver);
    updateAddressPage = new UpdateAddressPage(driver);
  }
  
  public void logInFormFilling(String email, String password)
  {
    mainNavigation.LogInClick();
    authenticationPage.insertEmail(email);
    authenticationPage.insertPassword(password);
    authenticationPage.signInClick();
  }
  
  public void signIn()
  {
    String email = readFromExcel.getStringData("TC1", 9, 3);
    String password = readFromExcel.getStringData("TC1", 10, 3);
    String textForAssertion = readFromExcel.getStringData("TC1", 20, 2);
    logInFormFilling(email, password);    
    String actualText = myAccountPage.textSignInLabel();
    assertEquals(actualText, textForAssertion);
  }
  
  @AfterClass
  public void posleSihTestova() 
  {
      driver.close();
  }
}
