package wiki_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
	//When click on search button information of searched element 
	
	@FindBy (xpath="(//table[@class='infobox vevent']//tr)[12]//td") 
	private WebElement dateRelease;
	
	@FindBy (xpath="(//table[@class='infobox vevent']//tr)[14]//td") 
	private WebElement country;
	
	public InformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getMovieReleaseDate(){
		String date=this.dateRelease.getText();
		return date;
	}
	
	public String getCountryName() {
		String countryName=country.getText();
		return countryName;
	}
}
