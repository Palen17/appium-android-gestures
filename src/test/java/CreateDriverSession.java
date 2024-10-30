import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Pixel_5");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:udid", "emulator-5554");

        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +  File.separator + "resources" +  File.separator + "ApiDemos-debug.apk";
        caps.setCapability("appium:app", appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, caps);



    }
}
