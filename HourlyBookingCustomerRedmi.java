package HourlyBookingBookingNew;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HourlyBookingCustomerRedmi {
	private AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void DeviceSetup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Redmi Note 12");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("appPackage", "com.moniic.customer.pp");
		capabilities.setCapability("appActivity", "com.moniic.customer.MainActivity");
		capabilities.setCapability("deviceID", "ef06a48c");

		driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("CUSTOMER APP LAUNCHED SUCCESSFULLY");

	}
	@Test
	public void testSkipBtn() throws InterruptedException {
		WebElement skipbtn=driver.findElement(By.className("android.widget.Button"));
		skipbtn.click();
		Thread.sleep(3000);
	}
	@Test (dependsOnMethods= {"testSkipBtn"})
	public void testOnLogin() throws InterruptedException {
		WebElement cDropDownBtn= driver.findElement(By.xpath("//android.widget.TextView[@bounds='[254,507][298,551]']"));
		cDropDownBtn.click();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods= {"testOnLogin"})
	public void testSearchCountry() throws InterruptedException {
		WebElement searchBtn = driver.findElement(By.className("android.widget.EditText"));
		searchBtn.sendKeys("india");
	
		WebElement indiaBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\r\n" ));
		indiaBtn.click();
		Thread.sleep(1000);
		WebElement numWidget= driver.findElement(By.className("android.widget.EditText"));
		numWidget.sendKeys("9443527443");
		Thread.sleep(5000);

		WebElement cnBtn1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
		cnBtn1.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test (dependsOnMethods= {"testSearchCountry"})
	public void testHourlyBtn() throws InterruptedException {
		WebElement allowMap=driver.findElement(By.xpath("//android.widget.Button[@text='WHILE USING THE APP']"));
		allowMap.click();
		Thread.sleep(3000);
	

		WebElement locBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[928,1149][969,1190]']"));
		locBtn.click();
		Thread.sleep(6000);

		WebElement hourlyBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Hourly']"));
		hourlyBtn.click();
		Thread.sleep(6000);
	}
	@Test(dependsOnMethods= {"testHourlyBtn"})
	public void testonBookNow()throws InterruptedException {

		WebElement bookNow = driver.findElement(By.xpath("//android.widget.TextView[@text='BOOK NOW']"));
		bookNow.click();
		Thread.sleep(3000);
		WebElement conpkp=driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		conpkp.click();
		Thread.sleep(3000);
		WebElement conpkpPoint=driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		conpkpPoint.click();
		Thread.sleep(3000);

	}
	@Test(dependsOnMethods= {"testonBookNow"})
	public void testAPUNote() throws InterruptedException {
		WebElement apuNotes = driver.findElement(By.xpath("//android.widget.TextView[@text='ADD PICK UP NOTES']"));
		apuNotes.click();
		Thread.sleep(3000);

		WebElement flNum = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your flight number']"));
		flNum.sendKeys("Boieng 757");
		Thread.sleep(1000);

		WebElement traName = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter the traveler name']"));
		traName.sendKeys("JUMBOJET ray");
		Thread.sleep(1000);

		WebElement othrNotes = driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Eg: I need a child seat, I need help with my bags...')]"));
		othrNotes.sendKeys("I need a CARRIER");
		Thread.sleep(1000);


		WebElement chfcnBtn = driver.findElement(By.xpath("//android.widget.Button[@index='1' and @clickable='true' and @enabled='true']"));
		chfcnBtn.click();
		Thread.sleep(6000);

	}
	@Test(dependsOnMethods= {"testAPUNote"})
	public void testOnCarChose() throws InterruptedException {
		WebElement carChoose = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[42,742][1038,1221]']"));
		carChoose.click();
		Thread.sleep(3000);


		WebElement bookclassBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[87,2164][993,2176]']"));
		bookclassBtn.click();
		Thread.sleep(3000);

		WebElement clCashWdt = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[83,1639][166,1722]']"));
		clCashWdt.click();
		Thread.sleep(3000);

		WebElement cnfrmCashBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		cnfrmCashBtn.click();
		Thread.sleep(3000);

		WebElement bookclassBtn2 = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[87,2164][993,2176]']"));
		bookclassBtn2.click();
		Thread.sleep(3000);



	}
	@Test (dependsOnMethods= {"testOnCarChose"})
	public void testSelectDuration() throws InterruptedException {
		WebElement hoursBlk = driver.findElement(By.xpath("(//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"])[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"));
		hoursBlk.click();
		Thread.sleep(3000);
		WebElement bookHr=driver.findElement(By.xpath("//android.widget.TextView[@bounds='[351,2141][730,2176]']"));
		bookHr.click();
		Thread.sleep(10000);

		
	}
	@Test (dependsOnMethods= {"testSelectDuration"})
	public void testOnSwipeOTPPage() throws InterruptedException {
		new TouchAction<>(driver)
		.press(PointOption.point(714, 2167))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(718, 1921))
		.release()
		.perform();

		Thread.sleep(1500);
		new TouchAction<>(driver)
		.press(PointOption.point(673, 2136))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(680, 1658))
		.release()
		.perform();

		Thread.sleep(1500);
		new TouchAction<>(driver)
		.press(PointOption.point(673, 2136))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
		.moveTo(PointOption.point(680, 1658))
		.release()
		.perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
		WebElement wheretoBlk=driver.findElement(By.xpath("//android.widget.TextView[ @text='Where To?']"));
		wheretoBlk.click();
		Thread.sleep(3000);

						
	}
	
	@Test (dependsOnMethods= {"testOnSwipeOTPPage"})
	
	public void testOnAddStops() throws InterruptedException {
		WebElement addBtn=driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[69,809][124,920]']"));
		addBtn.click();
		WebElement searLoc=driver.findElement(By.xpath("//android.widget.EditText[@text='Search for location']"));
		searLoc.sendKeys("Airport Terminal 3");
		Thread.sleep(1000);
		WebElement addLoc1=driver.findElement(By.xpath("//android.widget.TextView[@text='Airport Terminal 3']"));
		addLoc1.click();
		Thread.sleep(1000);
		WebElement addBtn2=driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[69,959][124,1070]']"));
		addBtn2.click();
		WebElement searLoc2=driver.findElement(By.xpath("//android.widget.EditText[@text='Search for location']"));
		searLoc2.sendKeys("Sahara Centre Overpass");
		Thread.sleep(1000);
		WebElement addLoc2=driver.findElement(By.xpath("//android.widget.TextView[@text='Sahara Centre Overpass']"));
		addLoc2.click();
		Thread.sleep(1000);
		WebElement addBtn3=driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[69,1109][124,1220]']"));
		addBtn3.click();
		WebElement searLoc3=driver.findElement(By.xpath("//android.widget.EditText[@text='Search for location']"));
		searLoc3.sendKeys("lulu Hypermarket");
		Thread.sleep(1000);
		WebElement addLoc3=driver.findElement(By.xpath("//android.widget.TextView[@text='LuLu Hypermarket - Al Barsha']"));
		addLoc3.click();
		Thread.sleep(1000);
		WebElement conBtn= driver.findElement(By.xpath("//android.widget.TextView[@text='CONFIRM']"));
		conBtn.click();
		Thread.sleep(180000);
		
	}
	
	
	@Test (dependsOnMethods= {"testOnAddStops"})
	public void testOnFeedBack() throws InterruptedException {

		WebElement skipBtn1 = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[926,346][1011,404]']"));
		skipBtn1.click();
		System.out.println("CUSTOMER COMPLETES THE RIDE");
		Thread.sleep(1000);
	}
	
	
}
