package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CAndroidDevice implements IDevice {
    private final String hostAppiumServer = "http://127.0.0.1:4723/wd/hub";
    @Override
    public AppiumDriver createDriver() {

        /** WhenDo App */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Pie API 28");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", "com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");

        AppiumDriver appiumDriver;
        try {
            appiumDriver = new AndroidDriver(
                    new URL(hostAppiumServer),
                    capabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return appiumDriver;
    }
}
