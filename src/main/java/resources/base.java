package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		

		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\webbrowserdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\webbrowserdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("ie")) {
			System.setProperty("webdriver.edge.driver", "src\\test\\webbrowserdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		else if (browserName.equals("headless")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\webbrowserdrivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
		}
		
		
		else if (browserName.equals("hub")) {
			DesiredCapabilities capability =new DesiredCapabilities();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("hubip"), capability);
		}
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
