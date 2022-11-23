package IMDB_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RatingAndReviewPage {
	@FindBy (xpath="//input[@id='suggestion-search']") 
	private WebElement searchText;
	
	@FindBy (xpath="(//div[contains(@class, 'constTitle')])[1]") 
	private WebElement suggestedMovieName;
			
	@FindBy (xpath="//button[@id='suggestion-search-button']") 
	private WebElement searchButton;
	
	public RatingAndReviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMovieName(String movieName){
		searchText.sendKeys(movieName);
	}
	
	public void clickOnsuggestedMovieName(){
		suggestedMovieName.click();
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
	}
}
