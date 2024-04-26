package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;


public class TestCases
 {
    ChromeDriver driver;


    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }







    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }



    
    public  void testCase01() throws InterruptedException
    {
        System.out.println("Start Test case: testCase01");

        //opening LeetCode URl
        driver.get("https://leetcode.com/");
        Thread.sleep(3000);

        //getting Leetcode site URL
        String leetCodeURl=driver.getCurrentUrl();


        //Verifying if URL contains "leetcode"
        if(leetCodeURl.contains("leetcode"))
        {
            System.out.println("leetCode URL contains leetCode");
        }

        else
        {
           System.out.println("leetCode URL does NOT contains leetCode"); 
        }

        //clicking on 'Sign in'
        WebElement signIn=driver.findElement(By.xpath("//div[@class='nav-menu']/child::a[5]"));
        signIn.click();
        Thread.sleep(3000);


        System.out.println("end Test case: testCase02");
    }




    public  void testCase02() throws InterruptedException
    {

        System.out.println("Start Test case: testCase02");

        //clicking on tab ' Problrm' field
        WebElement problemsTab=driver.findElement(By.xpath("//a[text()='Problems']"));
        problemsTab.click();
        Thread.sleep(3000);


        //Verifying if we are into ProblemSet URL
        String problemSetUrl=driver.getCurrentUrl();
        if(problemSetUrl.contains("problemset"))
        {
            System.out.println("we are into problemSet Url now");
        }
        else
        {
            System.out.println("we are NOT  into problemSet Url now");

        }


        //getting ALL Questions
        List<WebElement> questionn=new ArrayList<WebElement>();
        questionn = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]/child::div/child::div[2]/child::div/child::div/child::div/child::div/child::a"));

       


        //Printing FIRST 5 questions
        for(WebElement q1:questionn)
        {
            if(q1.getText().contains("6. Zigzag Conversion"))
            {
                break;
            }
            System.out.println(q1.getText());
        }
        Thread.sleep(2000);

        List<WebElement> questionn2=new ArrayList<WebElement>();
        questionn2 = driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]/child::div/child::div[2]/child::div/child::div/child::div/child::div/child::a"));


        //clicking on question ' Two sum'
        for(WebElement q2:questionn2)
        {
            if(q2.getText().contains("1. Two Sum"))
            {
                q2.click();
                break;
            }
        }
        Thread.sleep(3000);

        

        System.out.println("End Test case: testCase02");

    }


    public  void testCase03() throws InterruptedException
    {

        System.out.println("Start Test case: testCase03");



        //Verifying if 'Two Sum' question opened
        String twoSumUrl=driver.getCurrentUrl();
        if(twoSumUrl.contains("two-sum"))
        {
            System.out.println(" Two-sum page opened");
        }
        else
        {
            System.out.println(" Two-sum page NOT opened");

        }

        Thread.sleep(3000);
        System.out.println("End Test case: testCase03");

    }




    public  void testCase04() throws InterruptedException
    {

        System.out.println("Start Test case: testCase04");

        //clicking on 'submissions' tab
        WebElement submissionTab=driver.findElement(By.xpath("//div[@class='flex h-full flex-row gap-8']/child::a[4]"));
        submissionTab.click();

        Thread.sleep(5000);

       

        //Verfiying 'Register or Sign in ' is Displayed
         WebElement signInMessage = driver.findElement(By.xpath("//a[@class='px-3 py-1.5 font-medium inline-flex items-center whitespace-nowrap transition-all focus:outline-none text-label-r hover:text-label-r rounded-lg bg-green-s dark:bg-dark-green-s hover:bg-green-3 dark:hover:bg-dark-green-3']"));
        String messageText = signInMessage.getText();
    
        if (messageText.contains("Register or Sign In")) 
        {
            System.out.println("Pass : The Submissions tab displays 'Register or Sign In'");
        }
         else
          {
            System.out.println("Fail : The Submissions tab does not display 'Register or Sign In'");
        }





         System.out.println("End Test case: testCase04");

    }





}
