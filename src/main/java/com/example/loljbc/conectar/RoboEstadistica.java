package com.example.loljbc.conectar;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoboEstadistica {
    public static void start() {
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
        File file = new File("Estadisticas.csv");
        CSVWriter csvWriter;
        String[] datas;
        String[] asd = new String[20];
        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            for(WebElement tr: trs){
                datas = tr.getText().split(" ");
                if (datas.length == 21){
                    asd[0] = datas[0];
                    asd[1] = datas[1]+ " " + datas[2];
                    asd[2] = datas[3];
                    asd[3] = datas[4];
                    asd[4] = datas[5];
                    asd[5] = datas[6];
                    asd[6] = datas[7];
                    asd[7] = datas[8];
                    asd[8] = datas[9];
                    asd[9] = datas[10];
                    asd[10] = datas[11];
                    asd[11] = datas[12];
                    asd[12] = datas[13];
                    asd[13] = datas[14];
                    asd[14] = datas[15];
                    asd[15] = datas[16];
                    asd[16] = datas[17];
                    asd[17] = datas[18];
                    asd[18] = datas[19];
                    asd[19] = datas[20];
                    csvWriter.writeAll(Collections.singleton(asd));
                }else{
                    csvWriter.writeAll(Collections.singleton(datas));
                }
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




//        StringBuilder tempStats = new StringBuilder();
//        for (int i = 0; i<trs.size()+1;i++){
//            if (i == 0){
//                data.add(trs.get(0).getText());
//            }
//            else if(i > 0) {
//                tempStats.append(trs.get(i).getText()+",");
//            }
//        }
    }
}
