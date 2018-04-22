package TestGroupID.TestArtifactID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.loginpageobj;
import resources.base;

public class homepage extends base{

	//public WebDriver driver;
	public static Logger log =LogManager.getLogger(homepage.class.getName());
	
	@Test
	public void homepage_01_initilize() throws Exception{
		
		driver=initializebrowser();
		log.info("homepage_01_initilize");
		//driver.get(prop.getProperty("url"));
		
	}
	
	
	
	@Test(dataProvider="getdata")
	public void homepage_02_basepagenavigation(String email,String pass,String text) throws Exception{
		
		
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		loginpageobj lg=new loginpageobj(driver);
		
		l.getLogin().click();
		lg.loginidemail().sendKeys(email);
		lg.passid().sendKeys(pass);
		System.out.println(text);
		lg.loginbtn().click();
		log.info("homepage_02_basepagenavigation");
		log.info("Login Button clicked in HomePage TestCase"+email+" Password "+pass+" for user "+text);
		
	}
	
	@Test
	public void homepage_03_teardown(){
		driver.close();
		driver=null;
		log.info("homepage_03_teardown");
	}
	
@DataProvider
public Object[][] getdata(){
	
	Object[][] data=new Object[2][3];
	data[0][0]="test@test.com";
	data[0][1]="test";
	data[0][2]="restrcited user";
	
	data[1][0]="test1@test.com";
	data[1][1]="test1";
	data[1][2]="non restrcited user";
	
	return data;
}
	
}
