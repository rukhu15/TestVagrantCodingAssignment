package IMDB_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsPage {
	
	@FindBy (xpath="(//a[text()='Release date']/following::div)[1]") 
	private WebElement date;
	
	@FindBy (xpath="(//div[@data-testid='title-details-section']//a)[4]") 
	private WebElement country;
			
	public MovieDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
			
	public String getMovieReleaseDate(){
		return date.getText();
	}
	
	public String getCountry(){
		return country.getText();
	}
}
