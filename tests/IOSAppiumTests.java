import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Demonstrates basic mobile UI testing using Appium (for iOS/XCUITest) and TestNG.
 * This class assumes an Appium server is running and connected to an iOS Simulator or device.
 * NOTE: This example targets a simulated built-in iOS Calculator app.
 */
public class IOSAppiumTests {

    private IOSDriver driver;
    private final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub"; // Default Appium server URL

    /**
     * Setup method to initialize the Appium driver for iOS before running tests.
     */
    @BeforeClass
    public void setup() throws MalformedURLException {
        // 1. Define XCUITest Options
        XCUITestOptions options = new XCUITestOptions();

        // Device and platform information
        options.setPlatformName(Platform.IOS.name());
        options.setDeviceName("iPhone 15 Simulator"); // Must match a device/simulator name on your machine
        options.setPlatformVersion("17.0"); // Must match the platform version on your machine
        options.setAutomationName("XCUITest");

        // Application under test (e.g., iOS Calculator using its Bundle ID)
        options.setBundleId("com.apple.calculator"); // Standard Bundle ID for the Calculator app

        // Optional settings
        options.setWdaLaunchTimeout(Duration.ofSeconds(60)); // WebDriverAgent launch timeout
        options.setNoReset(true);

        // 2. Initialize the Driver
        URL serverUrl = new URL(APPIUM_SERVER_URL);
        driver = new IOSDriver(serverUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for demo
        System.out.println("iOS Appium Driver initialized.");
    }

    /**
     * Test case to verify the basic visibility of the calculator application.
     */
    @Test(description = "Verify application is reachable and visible")
    public void testAppVisibility() {
        // Using Accessibility ID (iOS equivalent of Content Description/Resource ID)
        By elementId = By.ByAccessibilityId.AccessibilityId("clear");

        assertTrue(driver.findElement(elementId).isDisplayed(), "The 'Clear' button should be displayed, indicating the app loaded.");
        System.out.println("Test 1 Passed: App loaded and 'Clear' button is visible.");
    }

    /**
     * Test case to simulate a simple calculation (e.g., press 5).
     */
    @Test(description = "Simulate clicking the digit 5 and verify display")
    public void testClickDigit() {
        // Locators using Accessibility ID
        By buttonFive = By.ByAccessibilityId.AccessibilityId("5");
        By displayElement = By.ByAccessibilityId.AccessibilityId("Result"); // Actual locator may vary

        // Click the '5' button
        driver.findElement(buttonFive).click();

        // Retrieve the current display value (may require text attribute or value attribute)
        // Note: The specific retrieval method can vary based on the element's class/type.
        String currentValue = driver.findElement(displayElement).getText();

        assertEquals(currentValue, "5", "After clicking '5', the display should show '5'.");
        System.out.println("Test 2 Passed: Digit '5' clicked and displayed.");

        // Clean up the display for the next test
        driver.findElement(By.ByAccessibilityId.AccessibilityId("clear")).click();
    }

    /**
     * Cleanup method to quit the driver after all tests are executed.
     */
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("iOS Appium Driver closed.");
        }
    }
}
