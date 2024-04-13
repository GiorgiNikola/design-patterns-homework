package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({CustomTestListener.class})
public class ConfigTests {
    @BeforeSuite
    public void initialSetup(){
        Configuration.timeout = 12000;
        Configuration.reopenBrowserOnFail = true;
        Configuration.screenshots = true;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.pageLoadTimeout = 20000;
    }
    @BeforeTest
    public void setup(){
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
    }
}
