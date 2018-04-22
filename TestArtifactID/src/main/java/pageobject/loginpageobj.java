package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpageobj {

	public WebDriver driver;
	
	//By loginid=By.cssSelector("input[name='user[email]']");
	//By pass=By.id("user_password");
	//By passbtn=By.xpath("//input[@name='commit']");
	
	@FindBy(css="input[name='user[email]']")
		WebElement loginidemail;
		
	@FindBy(id="user_password")
	 	WebElement passid;
	
	
	@FindBy(xpath="//input[@name='commit']")
	  WebElement loginbtn;
	
	public loginpageobj(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement loginidemail(){
		return loginidemail;
	}
	
	public WebElement passid(){
		return passid;
	}
	
	public WebElement loginbtn(){
		return loginbtn;
	}
	
	
}
