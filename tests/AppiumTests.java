import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

/**
 * Demonstrates basic mobile UI testing using Appium (for Android) and TestNG.
 * This class assumes an Appium server is running and connected to an emulator or physical device.
 * NOTE: This example targets the default Android Calculator app.
 */
public class AppiumTests {

    private AndroidDriver driver;
    private final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub"; // Default Appium server URL

    /**
     * Setup method to initialize the Appium driver before running tests.
     */
    @BeforeClass
    public void setup() throws MalformedURLException {
        // 1. Define Desired Capabilities/Options
        UiAutomator2Options options = new UiAutomator2Options();

        // Device and platform information
        options.setPlatformName(Platform.ANDROID.name());
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Replace with your device name
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // Application under test (e.g., Android Calculator)
        options.setAppPackage("com.google.android.calculator"); // Change this to your target app's package
        options.setAppActivity("com.android.calculator2.Calculator"); // Change this to your target app's main activity

        // Optional settings
        options.setNoReset(true); // Don't reset app state between sessions
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        // 2. Initialize the Driver
        URL serverUrl = new URL(APPIUM_SERVER_URL);
        driver = new AndroidDriver(serverUrl, options);
        System.out.println("Appium Driver initialized.");
    }

    /**
     * Test case to verify the initial display of the calculator is '0'.
     */
    @Test(description = "Verify initial display is 0")
    public void testInitialDisplay() {
        // Locate the result display element (using accessibility ID or resource ID)
        // IDs are dependent on the specific application version/device.
        By displayId = By.id("com.google.android.calculator:id/result_final");
        
        // Wait for the element (simplified for demo, production code needs explicit waits)
        String initialValue = driver.findElement(displayId).getText();

        assertEquals(initialValue, "0", "Initial calculator display should be 0.");
        System.out.println("Test 1 Passed: Initial display is '0'.");
    }

    /**
     * Test case to simulate clicking the digit '5'.
     */
    @Test(description = "Simulate clicking the digit 5")
    public void testClickDigit() {
        // Locate the '5' button (using resource ID for the button element)
        By buttonFive = By.id("com.google.android.calculator:id/digit_5");

        // Click the '5' button
        driver.findElement(buttonFive).click();

        // Verify that '5' appears on the display
        By displayId = By.id("com.google.android.calculator:id/result_final");
        String currentValue = driver.findElement(displayId).getText();

        assertEquals(currentValue, "5", "After clicking '5', the display should show '5'.");
        System.out.println("Test 2 Passed: Digit '5' clicked and displayed.");
    }

    /**
     * Cleanup method to quit the driver after all tests are executed.
     */
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium Driver closed.");
        }
    }
}
