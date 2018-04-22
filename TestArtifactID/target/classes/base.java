package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializebrowser() throws Exception{
		
		prop = new Properties();
		FileInputStream filein= new FileInputStream("C:\\Users\\shashikiran\\workspace1\\TestArtifactID\\src\\main\\java\\resources\\data.properties");
		prop.load(filein);
		String browsername=prop.getProperty("browser");
		
		if (browsername.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browsername.equals("firefox")){
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}

	
	public void getscreenshot(String result) throws Exception{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = String.format(result+"Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		FileUtils.copyFile(scr,new File("C:\\Selenium\\"+fileName));
		//FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}
	
	
}
