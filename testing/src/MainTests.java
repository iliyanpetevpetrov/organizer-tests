import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class MainTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:appPackage", "com.example.school.organizer");
        desiredCapabilities.setCapability("appium:appActivity", ".activities.MainActivity");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void AddAppointment() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el3.click();
        el3.sendKeys("Technical university sofia");
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el6.sendKeys("Classes");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/CheckBox01");
        el7.click();
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el8.click();
        Assert.assertEquals(driver.findElementById("00000000-0000-000f-7fff-ffff0000003b").getText(), "Classes\n" +
                "Marked locations 1 from 1 total.");
    }

    @Test
    public void SearchAddressOnMapTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el3.click();
        el3.sendKeys("Technical university sofia");
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el6.sendKeys("Classes");

        Assert.assertEquals(driver.findElementById("com.example.school.organizer:id/rowTextView").getText(), "1: Country: Bulgaria\n" +
                "Address: бул. „св. Климент Охридски“ 8, 1756 Studentski Kompleks, Sofia, Bulgaria");

        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/CheckBox01");
        el7.click();
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el8.click();
        Assert.assertEquals(driver.findElementById("00000000-0000-000f-7fff-ffff0000003b").getText(), "Classes\n" +
                "Marked locations 1 from 1 total.");
    }

    @Test
    public void CheckNoteFieldWrittableTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el3.click();
        el3.sendKeys("Technical university sofia");
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el6.sendKeys("Classes");

        Assert.assertEquals(driver.findElementById("com.example.school.organizer:id/edNote").getText(), "Classes");

        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/CheckBox01");
        el7.click();
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el8.click();
        Assert.assertEquals(driver.findElementById("00000000-0000-000f-7fff-ffff0000003b").getText(), "Classes\n" +
                "Marked locations 1 from 1 total.");
    }

    @Test
    public void CheckShortestPathTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el3.click();
        el3.sendKeys("Technical university sofia");
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el6.sendKeys("Classes");

        Assert.assertEquals(driver.findElementById("com.example.school.organizer:id/edNote").getText(), "Classes");

        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/CheckBox01");
        el7.click();
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el8.click();
        MobileElement el19 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnMakeRoute");
        el19.click();

        String activity = driver.getAppStringMap().get("activity_ID");
        Assert.assertEquals(activity, "com.google.maps");
    }

    @Test
    public void CheckAppointmentMenu() {
        MobileElement el5 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el6.sendKeys("Sofia technical university ");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el8.sendKeys("Sofia technical university ");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.example.school.organizer:id/rowTextView");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el10.clear();
        el10.sendKeys("Marko semov 23, Sofia");
        MobileElement el11 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.CheckBox");
        el12.click();
        driver.navigate().back();
        MobileElement el13 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el13.click();

        MobileElement el1 = (MobileElement) driver.findElementById("00000000-0000-000f-7fff-ffff0000003a");
        TouchActions action = new TouchActions(driver);
        action.longPress(el1);
        action.perform();

        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000040").getText(), "Activate");
        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000041").getText(), "Deactivate");
        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000042").getText(), "Edit selected points of interest");
        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000043").getText(), "Delete");
        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000044").getText(), "Mute for 5 minutes");
        Assert.assertEquals(driver.findElementById("00000000-0000-0012-7fff-ffff00000044").getText(), "Unmute");
    }

    @Test
    public void CheckMuteUnMuteAppointment() {
        MobileElement el5 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el6.sendKeys("Sofia technical university ");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el8.sendKeys("Sofia technical university ");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.example.school.organizer:id/rowTextView");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el10.clear();
        el10.sendKeys("Marko semov 23, Sofia");
        MobileElement el11 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.CheckBox");
        el12.click();
        driver.navigate().back();
        MobileElement el13 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el13.click();
        MobileElement el1 = (MobileElement) driver.findElementById("00000000-0000-000f-7fff-ffff0000003a");
        TouchActions action = new TouchActions(driver);
        action.longPress(el1);
        action.perform();

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]");
        el2.click();

        Assert.assertTrue(driver.findElementById("00000000-0000-001e-7fff-ffff00000012").isEnabled());
    }

    @Test
    public void EditPointsOfInterestedTest() {
        MobileElement el5 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el6.sendKeys("Sofia technical university ");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el8.sendKeys("Sofia technical university ");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.example.school.organizer:id/rowTextView");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el10.clear();
        el10.sendKeys("Marko semov 23, Sofia");
        MobileElement el11 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.CheckBox");
        el12.click();
        driver.navigate().back();
        MobileElement el13 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el13.click();

        MobileElement el1 = (MobileElement) driver.findElementById("00000000-0000-000f-7fff-ffff0000003a");
        TouchActions action = new TouchActions(driver);
        action.longPress(el1);
        action.perform();

        MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
        el15.click();
        Assert.assertEquals(driver.findElementById("00000000-0000-001e-7fff-ffff00000092").getText(), "Sofia technical university \n" +
                "Marked locations 1 from 2 total.");
        MobileElement el16 = (MobileElement) driver.findElementById("android:id/button1");
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
        el17.click();
        Assert.assertFalse(driver.findElementById("00000000-0000-002e-7fff-ffff00000113").isEnabled());
    }

    @Test
    public void ActivateDeactivateTest() {
        MobileElement el5 = (MobileElement) driver.findElementById("com.example.school.organizer:id/fab");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el6.sendKeys("Sofia technical university ");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.school.organizer:id/edNote");
        el8.sendKeys("Sofia technical university ");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.example.school.organizer:id/rowTextView");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.example.school.organizer:id/tbAddress");
        el10.clear();
        el10.sendKeys("Marko semov 23, Sofia");
        MobileElement el11 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSearch");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.CheckBox");
        el12.click();
        driver.navigate().back();
        MobileElement el13 = (MobileElement) driver.findElementById("com.example.school.organizer:id/btnSave");
        el13.click();

        MobileElement el1 = (MobileElement) driver.findElementById("00000000-0000-000f-7fff-ffff0000003a");
        TouchActions action = new TouchActions(driver);
        action.longPress(el1);
        action.perform();

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
        el2.click();

        Assert.assertTrue(driver.findElementById("00000000-0000-001e-7fff-ffff00000012").isEnabled());

        action.longPress(el1);
        action.perform();

        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        el4.click();
        Assert.assertFalse(driver.findElementById("00000000-0000-001e-7fff-ffff00000012").isEnabled());
    }

    @Test
    public void DeleteAppointment() {
        MobileElement el1 = (MobileElement) driver.findElementById("00000000-0000-000f-7fff-ffff0000003a");
        TouchActions action = new TouchActions(driver);
        action.longPress(el1);
        action.perform();

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]");
        el2.click();

        Assert.assertEquals(driver.findElementById("00000000-0000-001e-7fff-ffff00000011").getText(), "1. Click me.\n" +
                "2. Now try to delete me\n" +
                "with long click.\n" +
                "Marked locations 0 from 0 total.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}