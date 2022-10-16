package singletonSession;

import factoryDevices.CFactoryDevice;
import io.appium.java_client.AppiumDriver;

public class CSession {

    private static CSession session = null;
    private AppiumDriver appiumDriver;

    private CSession() {
        /// Android Device
        appiumDriver = CFactoryDevice.make("android").createDriver();
    }

    public static CSession getInstance() {
        if (session == null)
            session = new CSession();
        return session;
    }

    public void closeApp(){
        appiumDriver.quit();
        session=null;
    }

    public AppiumDriver getDriver(){
        return appiumDriver;
    }
}
