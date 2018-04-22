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

public class validatetitleTest extends base{
	
	public static Logger log =LogManager.getLogger(validatetitleTest.class.getName());
	@Test
	public void validatetitle_01_initilize() throws Exception{
		
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
		log.info("validatetitle_01_initilize");
		
	}
	
	@Test
	public void validatetitle_02_landingpagetextvalidation(){
		
		LandingPage lz=new LandingPage(driver);
		//lz.textvlida().getText();
		Assert.assertEquals(lz.textvlida().getText(), "Featured Cources");
		//Assert.assertEquals(l.textvlida().getText(), "Featured Course");
		log.info("validatetitle_02_landingpagetextvalidation");
	}
	
	@Test
	public void validatetitle_03_teardown(){
		driver.close();
		driver=null;
		log.info("validatetitle_03_teardown");
	}

}
