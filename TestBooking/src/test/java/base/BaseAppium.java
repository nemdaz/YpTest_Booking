package base;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseAppium {
	
	public static AppiumDriverLocalService aservice;
	public static AppiumDriver adriver; 
	
	public BaseAppium() {}
	
	public void start() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("udid", "a58c4cdf");
		cap.setCapability("deviceName", "Xiaomi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0.0");
		cap.setCapability("appPackage", "com.booking");
		cap.setCapability("appActivity", "com.booking.appindex.presentation.activity.SearchActivity");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		
		
		// Service
		AppiumServiceBuilder abuilder = new AppiumServiceBuilder().withCapabilities(cap).withIPAddress("http://127.0.0.1").usingPort(4723);
		aservice = abuilder.build();
		aservice.start();
		
		// Driver
		adriver = new AppiumDriver(aservice.getUrl(), cap);
		
	}
	
	public void shutDown() {
		if(adriver != null) adriver.quit();
	}

}
