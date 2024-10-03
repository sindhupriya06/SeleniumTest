package selenium_test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Thread;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Day1 {
	
	static String brname = "chrome";
	static RemoteWebDriver WbDriver;

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
	/*	RemoteWebDriver Dr = new ChromeDriver();
		RemoteWebDriver Dr1 = new FirefoxDriver();
		RemoteWebDriver Dr2 = new EdgeDriver();
		Dr2.get(brname);
		Dr1.get(brname);
		
		Dr.get("https://google.com/");*/
	
		if(brname.equals("chrome")) 
		{
			 WbDriver = new ChromeDriver();

		}
		else if(brname.equals("Firefox"))
		{
			WbDriver = new FirefoxDriver();
		}
		else if(brname.equals("Edge"))
		{
			WbDriver = new EdgeDriver();
		}
		
		String url = "https://www.facebook.com/";
		String PageTitle;
		//WebDriver driver = WbDriver;
		
		WbDriver.get(url);
		
		String crnturl = WbDriver.getCurrentUrl();
		System.out.println("current url is " + crnturl);
		
		String str = new String(crnturl);
		
		boolean strfound = str.matches("(.*)facebook(.*)");
		if(strfound){
			System.out.println("URl contains facebook is PASS");
			
		}
		else{
			System.out.println("URl contains facebook is FAIL");
		}
		
		//verifying facebook text in url		
		String requrl = "facebook";
		Pattern patrn =  Pattern.compile(requrl,Pattern.CASE_INSENSITIVE);
		Matcher match = patrn.matcher(requrl);
		boolean matchfound = match.find();
		if(matchfound){
			System.out.println("URl contains facebook is PASS");
			
		}
		else{
			System.out.println("URl contains facebook is FAIL");
		}
				
		// maximize the window
		WbDriver.manage().window().maximize();
		
		//get title from the browser
		PageTitle = WbDriver.getTitle();
		System.out.println("Title of the page is " + PageTitle);
		
		//enter name and password
		
		WebElement userName = WbDriver.findElement(By.id("email"));
		userName.sendKeys("Test");
		Thread.sleep(4000);
		WbDriver.findElement(By.id("pass")).sendKeys("Pwd");
		
		WbDriver.close(); // it will close the current active tab
		WbDriver.quit(); // it will close the entire window

	}

}
