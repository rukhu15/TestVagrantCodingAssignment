package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import IMDB_Pages.MovieDetailsPage;
import IMDB_Pages.RatingAndReviewPage;
import setup.Base;
import wiki_Pages.InformationPage;
import wiki_Pages.SearchPage;

public class VarifyReleaseDateAndOriginCountry {
	WebDriver driver;
	RatingAndReviewPage ratingAndReviewPage;
	MovieDetailsPage movieDetailsPage;
	SearchPage searchPage;
	InformationPage informationPage;
	String releaseDateWiki;
	String originCountryWiki;
	
	@BeforeTest
	public void launchBrouser(){
		driver=Base.launchChromeBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObjectReference() {
		//first page after entering wiki url
		searchPage = new SearchPage(driver);
		
		//movie detail information
		informationPage= new InformationPage(driver);
		
		//first page after entering IMDB url
		ratingAndReviewPage = new RatingAndReviewPage(driver);	

		//movie detail information
		movieDetailsPage =new MovieDetailsPage(driver);
	}
	
	@Test
	public void getDateAndCountryFromWiki() throws InterruptedException {
		//Get the release date and country from wikipedia
		driver.get("https://www.wikipedia.org/");
		
		//search movie name
		searchPage.enterMovieName("Pushpa");
		searchPage.clickOnSearchButton();
		
		//To get release date
		releaseDateWiki=informationPage.getMovieReleaseDate();
		
		//To get origin country
		originCountryWiki=informationPage.getCountryName();
	}
	
	@Test(dependsOnMethods="getDateAndCountryFromWiki")
	public void varifyDateAndCountryFromWikiAndIMDB() throws InterruptedException {
		//Get the release date and country from IMDB and comapare with wikipedia
		driver.get("https://www.imdb.com/");
		
		//search movie name
		ratingAndReviewPage.enterMovieName("Pushpa The Rise");
		
		//To select movie name from suggestions
		ratingAndReviewPage.clickOnsuggestedMovieName();
		
		//To get release date
		String releaseDateIMDB=movieDetailsPage.getMovieReleaseDate();
		
		//To get origin country
		String originCOuntryIMDB=movieDetailsPage.getCountry();
		
		//Assertaion Applied to compare Origin Country in IMDB and Wiki
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(originCOuntryIMDB, originCountryWiki);
		
		// To Apply assertions on release date
		//split ReleaseDateWiki from space(" ") and check same present in releaseDateIBDM or not
		String [] dateSplit=releaseDateWiki.split(" ");
		for(int index=0; index<dateSplit.length; index++) {
			softAssert.assertTrue(releaseDateIMDB.contains(dateSplit[index]));
		}
		softAssert.assertAll();
		driver.navigate().back();
	}
	
	@AfterMethod
	public void navigateBack() {
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@AfterClass
	public void nullObjectReferences() {
		ratingAndReviewPage = null;	
		movieDetailsPage = null;
		searchPage =null;
		informationPage= null;
	}
	
	@AfterTest
	public void closebrowser(){
		driver.close();
	}
}
