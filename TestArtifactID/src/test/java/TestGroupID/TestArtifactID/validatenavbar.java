package TestGroupID.TestArtifactID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import resources.base;

public class validatenavbar extends base{
	
	public static Logger log =LogManager.getLogger(validatenavbar.class.getName());
	@Test
	public void validatenavbar_01_initilize() throws Exception{
		
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
		log.info("validatenavbar_01_initilize");
		
	}

	@Test
	public void validatenavbar_02_landingpagenavvalidation(){
		
		LandingPage lg=new LandingPage(driver);	
		Assert.assertTrue(lg.getNavigationBar().isDisplayed());
		log.info("validatenavbar_02_landingpagenavvalidation");
		
	}
	
	@Test
	public void validatenavbar_03_teardown(){
		driver.close();
		driver=null;
		log.info("validatenavbar_03_teardown");
	}
	
}



