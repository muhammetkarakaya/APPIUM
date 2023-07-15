import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppYukleme {
    AndroidDriver<AndroidElement> driver;
    @Test
    public void upload() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities(); //yapacagimiz tamimlamalari belirtiyoruz. Mercimek corbasinin oldugu yemek kitabi
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2"); //burda mercimek tarifi, tanimlama yapilan yer
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\msas\\IdeaProjects\\APPIUM-T113\\Apps\\arabam.com_4.8.0_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
