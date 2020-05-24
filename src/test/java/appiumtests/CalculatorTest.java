package appiumtests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Sleeper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
	}
	
	// set desired capabilities.
	public static void openCalculator() throws MalformedURLException, InterruptedException {
		File f = new File("src");
		File fs = new File(f, "Rakuten_link_debug_0.0.130e-Kiba-Https.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		
		cap.setCapability("appPackage", "jp.co.rakuten.mobile.rcs");
		cap.setCapability("appWaitPackage", "jp.co.rakuten.mobile.rcs");
		cap.setCapability("appWaitActivity", "jp.co.rakuten.mobile.rcs.*");
		//cap.setCapability("appActivity", "com.android.calculator2.calculator");
		//jp.co.rakuten.mobile.rcs:id/btn_get_started
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Applicatoin started ...");
		
		MobileElement btn = driver.findElement(By.id("jp.co.rakuten.mobile.rcs:id/btn_get_started"));
		btn.click();
		TimeUnit.SECONDS.sleep(3);
		MobileElement btn_accpt = driver.findElement(By.id("jp.co.rakuten.mobile.rcs:id/accept"));
		btn_accpt.click();
	}

}
