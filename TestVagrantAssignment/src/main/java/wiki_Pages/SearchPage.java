package wiki_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindBy (xpath="//input[@id='searchInput']")
	private WebElement searchInput;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy (xpath="(//h3[@class='suggestion-title'])[1]")
	private WebElement suggestedName;
			
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterMovieName(String movieName) {
		searchInput.sendKeys(movieName);
	}
	
	public void clickOnSearchButton(){
		searchButton.click();
	}
	
	public void clickOnSuggestedName(){
		suggestedName.click();
	}
}
