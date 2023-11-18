package com.makemytrip;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Trains {
	public WebDriver driver;
	
	@Given("Launch the MakeMyTrip Application {string}")
	public void launch_the_MakeMyTrip_Application(String url) {
		WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@When("User closes the ad")
	public void user_closes_the_ad() {
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		
		WebElement close = driver.findElement(By.className("close"));
		close.click();
		driver.switchTo().defaultContent();
	}

	@When("User skips the login")
	public void user_skips_the_login() {
		
		WebElement loginClose = driver.findElement(By.className("commonModal__close"));
		loginClose.click();
	}

	@When("User clicks on train # Action")
	public void user_clicks_on_train_Action() throws InterruptedException {
//		Thread.sleep(5000);
		WebElement trains = driver.findElement(By.xpath("(//span[text()='Trains'])[1]"));
		trains.click();
	}

	@When("User enters the from place")
	public void user_enters_the_from_place() {
		WebElement fromPlace = driver.findElement(By.id("fromCity"));
		fromPlace.click();
		WebElement from = driver.findElement(By.xpath("//input[@title='From']"));
		from.sendKeys("Chennai");
		WebElement list = driver.findElement(By.xpath("//span[text()='Chennai - All Stations']"));
		list.click();
	}

	@When("User enters the to place")
	public void user_enters_the_to_place() {
		WebElement toPlace = driver.findElement(By.id("toCity"));
		toPlace.click();
		WebElement to = driver.findElement(By.xpath("//input[@title='To']"));
		to.sendKeys("Madurai");
		WebElement list = driver.findElement(By.xpath("//span[text()='Madurai - All Stations']"));
		list.click();
		
	}

	@When("User selects the travel date")
	public void user_selects_the_travel_date() {
		WebElement date = driver.findElement(By.id("travelDate"));
		date.click();
		WebElement travelDate = driver.findElement(By.xpath("(//p[text()='20'])[1]"));
		travelDate.click();
		
	}

	@And("User clicks on search")
	public void user_clicks_on_search() {
		WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
		search.click();
	}

	@Then("Verify the  from place, to place, travel data and class# Post condition, Validation purpose")
	public void verify_the_from_place_to_place_travel_data_and_class_Post_condition_Validation_purpose() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	
	@When("User clicks on hotel # Action")
	public void user_clicks_on_hotel_Action() {
		WebElement trains = driver.findElement(By.xpath("(//span[text()='Trains'])[1]"));
		trains.click();
	}

	@When("User enters the hotel")
	public void user_enters_the_hotel() {
		WebElement fromPlace = driver.findElement(By.id("fromCity"));
		fromPlace.click();
		WebElement from = driver.findElement(By.xpath("//input[@title='From']"));
		from.sendKeys();
		WebElement list = driver.findElement(By.xpath("//span[text()='Chennai - All Stations']"));
		list.click();
	}

	@When("User selects the booking date")
	public void user_selects_the_booking_date() {
		WebElement toPlace = driver.findElement(By.id("toCity"));
		toPlace.click();
		WebElement to = driver.findElement(By.xpath("//input[@title='To']"));
		to.sendKeys("Madurai");
		WebElement list = driver.findElement(By.xpath("//span[text()='Madurai - All Stations']"));
		list.click();
	}

	@Then("Verify the  hotel, booking date# Post condition, Validation purpose")
	public void verify_the_hotel_booking_date_Post_condition_Validation_purpose() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@When("User enters the from place with one dim list")
	public void user_enters_the_from_place_with_one_dim_list(DataTable dataTable) {
		List<String> li = dataTable.asList();
		String value = li.get(2);
		WebElement fromPlace = driver.findElement(By.id("fromCity"));
		fromPlace.click();
		WebElement from = driver.findElement(By.xpath("//input[@title='From']"));
		from.sendKeys(value);
		WebElement list = driver.findElement(By.xpath("//span[text()='"+value+" - All Stations']"));
		list.click();
	}

	@When("User enters the hotel with one dim list")
	public void user_enters_the_hotel_with_one_dim_list(DataTable dataTable) {
		List<String> li = dataTable.asList();
		String hotel = li.get(0);
		WebElement fromPlace = driver.findElement(By.id("fromCity"));
		fromPlace.click();
		WebElement from = driver.findElement(By.xpath("//input[@title='From']"));
		from.sendKeys(hotel);
		WebElement list = driver.findElement(By.xpath("//span[text()='"+hotel+" - All Stations']"));
		list.click();
	}
	
	@When("User enters the to place with one dim map")
	public void user_enters_the_to_place_with_one_dim_map(DataTable dataTable) throws InterruptedException {
		Map<String, String> mp = dataTable.asMap(String.class, String.class);
		String object =  mp.get("place2");
		System.out.println(object);
		WebElement toPlace = driver.findElement(By.id("toCity"));
		toPlace.click();
		Thread.sleep(5000);
		WebElement to = driver.findElement(By.xpath("//input[@title='To']"));
		to.sendKeys(object);
		WebElement list = driver.findElement(By.xpath("//span[text()='"+object+" - All Stations']"));
		list.click();
	}

	@When("User selects the booking date with one dim map")
	public void user_selects_the_booking_date_with_one_dim_map(DataTable dataTable) throws InterruptedException {
		Map<String, String> mp = dataTable.asMap(String.class, String.class);
		String toP =  mp.get("place3");
		System.out.println(toP);
		WebElement toPlace = driver.findElement(By.id("toCity"));
		toPlace.click();
		Thread.sleep(5000);
		WebElement to = driver.findElement(By.xpath("//input[@title='To']"));
		to.sendKeys(toP);
		WebElement list = driver.findElement(By.xpath("//span[text()='"+toP+" - All Stations']"));
		list.click();
	}


}
