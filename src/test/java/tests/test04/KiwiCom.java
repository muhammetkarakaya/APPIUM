package tests.test04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;

public class KiwiCom {
    AndroidDriver<AndroidElement>driver = Driver.getAndroidDriver();
    TouchAction touchAction=new TouchAction<>(driver);
    KiwiPage kiwiPage = new KiwiPage();
    // uygulamanin yuklendigi dogrulanir
    // uygulamanin basariyla acildigi dogrulanir
    // misafir olarak devam et e tiklanir
    // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        //AndroidElement guest=driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(kiwiPage.misafir.isDisplayed());
        // misafir olarak devam et e tiklanir
        kiwiPage.misafir.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //koordinat 538,1686

        for (int i = 0; i < 3; i++) {

            touchAction.press(PointOption.point(538,1686)).release().perform();
            Thread.sleep(1000);

        }
        // Trip type,one way olarak secilir
        Thread.sleep(2000);
        kiwiPage.koordinatTiklama(290,627,1000);
        Thread.sleep(1000);
        kiwiPage.koordinatTiklama(552,1448,1000);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        kiwiPage.koordinatTiklama(502,780,1000);
        kiwiPage.koordinatTiklama(1016,135,1000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Istanbul");
        } else {
            kiwiPage.departureBox.sendKeys("Atina");
        }
        Thread.sleep(1000);
        kiwiPage.koordinatTiklama(493,294,1000);

        kiwiPage.chooseButton.click();


    }



}
