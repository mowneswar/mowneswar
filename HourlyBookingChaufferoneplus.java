package HourlyBookingBookingNew;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class HourlyBookingChaufferoneplus {
	private AndroidDriver<MobileElement> driver;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "OnePlus 7T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("appPackage", "com.moniic.chauffeur.pp");
		capabilities.setCapability("appActivity", "com.ourlane.driver.MainActivity");
		capabilities.setCapability("deviceID", "a36a1285");

		driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("CHAUFFER APP LAUNCHED IN OnePlus 7T");
		Thread.sleep(3000);

	}
	@Test
	public void testOnLocAccess() throws InterruptedException {
		WebElement locsharAlw = driver.findElement(By.xpath("//android.widget.TextView[@text='ALLOW']"));
		locsharAlw.click();
		Thread.sleep(3000);

		WebElement allowLoc = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
		allowLoc.click();
		Thread.sleep(1000);

		WebElement allowphyActi = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		allowphyActi.click();
		Thread.sleep(500);
		
		}
	@Test (dependsOnMethods= {"testOnLocAccess"})
	public void testOnSkipBtnPage() throws InterruptedException {
		WebElement skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='SKIP']"));
		skipBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test (dependsOnMethods= {"testOnSkipBtnPage"})
	public void testOnLogin() throws InterruptedException {
		WebElement numBlk = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Phone Number']"));
		numBlk.click();
		Thread.sleep(1000);
		numBlk.sendKeys("700555555");
		Thread.sleep(3000);

		WebElement prcdBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='PROCEED']"));
		prcdBtn.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

	}
	@Test (dependsOnMethods= {"testOnLogin"})
	public void testOnAccptTrip() throws InterruptedException {
		Thread.sleep(5000);
		WebElement accptTrip = driver.findElement(By.xpath("//android.widget.TextView[@text='ACCEPT']"));
		accptTrip.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("CHAUFFER ACCEPTS THE TRIP");
	}
	@Test (dependsOnMethods= {"testOnAccptTrip"})
	public void testonNotifyRider() throws InterruptedException {
			
		WebElement notifyRider = driver.findElement(By.xpath("//android.widget.TextView[@text='NOTIFY RIDER']"));
		notifyRider.click();
		Thread.sleep(5000);

		WebElement oK = driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']"));
		oK.click();
		Thread.sleep(5000);
	}
	@Test (dependsOnMethods= {"testonNotifyRider"})
	public void testOnenterOTP() throws InterruptedException {
		WebElement enterOTP = driver.findElement(By.xpath("//android.widget.TextView[@class='android.widget.TextView' and @text='ENTER OTP']"));
		enterOTP.click();
		System.out.println("OTP ENTERED");
		Thread.sleep(8000);
		

	
	}
	@Test (dependsOnMethods= {"testOnenterOTP"})
	public void testOnStratTrip() throws InterruptedException {
		WebElement startTrip=driver.findElement(By.xpath("//android.widget.TextView[@text='START TRIP' and @index='0' and @enabled='true']"));
		startTrip.click();
		driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
		while (true) {
	        try {
	            
	            WebElement oK = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
	            oK.click();
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        } catch (NoSuchElementException e) {
	            
	            break;
	        }
	    }
	
		Thread.sleep(1000);
	}
	@Test(dependsOnMethods = {"testOnStratTrip"})
    public void testOnSlideTOTrips() throws InterruptedException {
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();
		Thread.sleep(50000);
		
		WebElement stopCompletedOkBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		stopCompletedOkBtn.click();
		System.out.println("FIRST ADD ON LOC REACHED");
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();
		Thread.sleep(1000);
		WebElement tripResumedOkBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		tripResumedOkBtn.click();
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();

		Thread.sleep(50000);
		WebElement stopCompletedOkBtn2 = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		stopCompletedOkBtn2.click();
		System.out.println("SECOND  ADD ON LOC REACHED");
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();

		Thread.sleep(1000);
		WebElement tripResumedOkBtn2 = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		tripResumedOkBtn2.click();
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();
		Thread.sleep(50000);
		WebElement stopCompletedOkBtn3 = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		stopCompletedOkBtn3.click();
		System.out.println("THIRD  ADD ON LOC REACHED");
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();
		Thread.sleep(10000);
		WebElement tripResumedOkBtn3 = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']"));
		tripResumedOkBtn3.click();
		Thread.sleep(1000);
		new TouchAction<>(driver)
        .press(PointOption.point(181, 2064))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)))
        .moveTo(PointOption.point(988, 2064))
        .release()
        .perform();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
		System.out.println("FINAL DESTINATION REACHED");
				              
	}
	@Test (dependsOnMethods= {"testOnSlideTOTrips"})
	public void testOnComplTrip() throws InterruptedException {
		WebElement comOkBtn= driver.findElement(By.xpath("//android.widget.TextView[@text='Yes' and @class='android.widget.TextView']"));
		comOkBtn.click();
		Thread.sleep(3000);
		System.out.println("TRIP COMPLETED");
		
		WebElement colCashBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='DONE']"));
		colCashBtn.click();
		Thread.sleep(1000);
		WebElement doneBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='DONE']"));
		doneBtn.click();
		Thread.sleep(1000);
		System.out.println("FARE SUMMARY CREATED");
		String text=doneBtn.getText();
		System.out.println("FARE SUMMARY DETAILS:" + text );
		Thread.sleep(1000);
		WebElement skipBtn2 = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[240,2051][355,2107]']"));
		skipBtn2.click();
		
	}
	
}

