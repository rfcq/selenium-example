package org.rfcq.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BrowserConfig {

    WebDriver driver = null;
    private Properties environment;

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"browser"})
    public void setup(@Optional String browser) {

        browser = browser != null ? browser : "chrome";

        switch(browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                driver.get("https://www.google.com.br");
                break;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                firefoxOptions.addArguments("start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                driver.get("https://www.google.com.br");
                break;
            }
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
