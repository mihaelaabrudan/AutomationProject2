package utile;
import Pages.utile.ReportManager;
import Pages.utile.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Pages.pages.HomePage;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;
    protected HomePage homePage;
    private static ExtentReports extentReports;

    @BeforeClass  //inainte sa fie rulata o clasa o sa se faca setarile pentru driver din aceasta metoda
    public void setupClass(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //initializare driver
        screenshotUtils = new ScreenshotUtils(driver);

        // Initialize ExtentReports
        extentReports = ReportManager.getInstance();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://apptest.go.ro:9999/login");
        homePage = new HomePage(driver);
    }

   @AfterClass
    public void tearDown() {
       if (driver != null) { //daca istanta de driver nu este null/creat
           //driver.close(); //se inchide doar frontend
           driver.quit(); //se inchide tot procesul atat frontend cat si backend
       }

       // Flush the report
      if (extentReports != null) {
           extentReports.flush();
       }


   }

    /**
     * Aceasta metoda creeaza rezultatul testului
     * @param result
     */
   @AfterMethod
   public void afterMethod(ITestResult result) {
       if (extentTest != null) {

           if (result.getStatus() == ITestResult.FAILURE) {
               captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
               extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case Failed: " + result.getName(), ExtentColor.RED));
               extentTest.fail(result.getThrowable());
           } else if (result.getStatus() == ITestResult.SUCCESS) {
               extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case Passed: " + result.getName(), ExtentColor.GREEN));
           } else {
               extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case Skipped: " + result.getName(), ExtentColor.YELLOW));
           }
       }
   }

   public void initTest(String testName){
        extentTest = ReportManager.createTest(testName);

   }

   private void captureAndSaveFailureScreenshot(String testName){
        //Facem un folder nou, daca nu exista
       File screenshotDirectory = new File("Screenshots");
       if(!screenshotDirectory.exists()){
           screenshotDirectory.mkdir();
       }
       //capture and save screenshots

       screenshotUtils.captureAndSaveScreenshots(testName);
   }

    }

