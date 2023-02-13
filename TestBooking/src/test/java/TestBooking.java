import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class TestBooking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		startApp();

	}

	public static void startApp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator2"); // Obligatorio para Appium 2
		cap.setCapability("udid", "a58c4cdf");
		cap.setCapability("deviceName", "Xiaomi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0.0");
		cap.setCapability("appPackage", "com.booking");
		cap.setCapability("appActivity", "com.booking.appindex.presentation.activity.SearchActivity");
		//cap.setCapability("appActivity", "com.booking.login.LoginActivity");
		// cap.setCapability("appPackage", "com.xiaomi.scanner");
		// cap.setCapability("appActivity", "com.xiaomi.scanner.app.ScanActivity");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		// AppiumDriver adriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); //Appium 1.XX
		AppiumDriver adriver = new AppiumDriver(new URL("http://127.0.0.1:4723"), cap); // Appium 2.XX

		System.out.println("God, will have to wait for a minute now.");
		coolDelay(90000);
		System.out.println("God, waited for a minute now.");

		//MobileElement el = adriver.findElement(By.id("com.uobam.premier:id/btnAccept"));

		//el.click();

		System.out.println("Probably clicked");

	}

	public static void coolDelay(int miliSec) {

		try {
			Thread.sleep(miliSec);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
