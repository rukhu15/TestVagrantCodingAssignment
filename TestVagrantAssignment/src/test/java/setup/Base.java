package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver launchChromeBrowser(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	public static WebDriver launchEdgeBrowser(){
		System.setProperty("webdriver.edge.driver", "src/test/resources/browsers/msedgedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}


}
