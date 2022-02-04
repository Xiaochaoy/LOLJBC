package com.example.loljbc.conectar;

import com.example.loljbc.modelo.Champion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoboEstadistica {
    public static void start(List<Champion> champions) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chaos\\IdeaProjects\\2nDAM\\LoLJBC\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions/Base_statistics");

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")));
        driver.findElement(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")).click();

        WebElement tabla = driver.findElement(new By.ByClassName("sortable"));

        List<WebElement> trs = tabla.findElements(new By.ByTagName("tr"));

        trs.remove(0);
        ArrayList<String> data = new ArrayList<String>();
        StringBuilder tempStats = new StringBuilder();
        for (int i = 0; i<trs.size()+1;i++){
            if (i == 0){
                data.add(trs.get(0).getText());
            }
            else if(i > 0) {
                tempStats.append(trs.get(i).getText()+",");
            }
        }
    }
}
