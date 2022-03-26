package steps;/*
@author
Marat Lagun
created on 3/25/22   
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingleDriver {
    private static SingleDriver instanceOfDriver = null;

    private SingleDriver() {

    }

    public WebDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    public static SingleDriver getInstanceOfDriver() {
        if (instanceOfDriver == null) {
            instanceOfDriver = new SingleDriver();
        }
        return instanceOfDriver;
    }

}
