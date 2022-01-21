package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.ForAppium;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Appium {
    private AndroidDriver driver;
    private ForAppium main;

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\ivan3\\Ua_Automator\\app\\build\\outputs\\apk\\debug\\app-debug.apk");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        main = new ForAppium(driver);
    }

    @Test
    @Order(1)
    @DisplayName("input Nothing")
    public void inputNothing() {
        String textBefore = main.textBefore.getText();
        main.buttonChange.click();
        String textAfter = main.textBefore.getText();
        assertEquals(textBefore, textAfter);
    }

    @Test
    @Order(2)
    @DisplayName("input Space")
    public void inputSpace() {
        String textBefore = main.textBefore.getText();
        main.input.sendKeys("  ");
        main.buttonChange.click();
        String textAfter = main.textBefore.getText();
        assertEquals(textBefore, textAfter);
    }

    @Test
    @Order(3)
    @DisplayName("new Activity")
    public void newActivity() {
        main.input.sendKeys("Netology");
        main.buttonActivity.click();
        String textAfter = main.activityText.getText();
        assertEquals("Netology", textAfter);
    }
}