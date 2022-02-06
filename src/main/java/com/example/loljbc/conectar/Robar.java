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
import java.util.List;

public class Robar {
    public static List<Champion> start(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chaos\\IdeaProjects\\2nDAM\\LoLJBC\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        WebDriver driver = new ChromeDriver(options);

        // Ir a la pagina Web.
        driver.get("https://www.leagueoflegends.com/es-es/champions/");
        // Este es la lista de links.
        List<String> li;
        // Este es la lista de campeones.
        List<Champion> champions = new ArrayList<>();
        // Este es la variable que tiene el valor que usas para la espera.
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Aqui llama a diferentes metodos
        clicarBotones(driver, driverWait);
        li = pillarLinks(driver);
        champions = robarInfo(driver,driverWait,li,champions);

        CSV csv = new CSV(champions);
        return champions;

    }

    /**
     * Este es para clicar los botones que aparecen cuando entras en la Web.
     * @param driver recibe un WebDriver para buscar elementos en la Web.
     * @param driverWait es un valor que te permite esperar.
     */
    public static void clicarBotones(WebDriver driver, WebDriverWait driverWait){
        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("osano-cm-accept-all")));
        driver.findElement(new By.ByClassName("osano-cm-accept-all")).click();
    }

    /**
     * Este es para pillar los links que hay.
     * @param driver recibe un WebDriver para buscar elementos en la Web.
     * @return devuelve una lista de links.
     */
    public static List<String> pillarLinks(WebDriver driver){
        List<WebElement> link = driver.findElements(new By.ByClassName("style__Wrapper-n3ovyt-0"));
        List<String> li = new ArrayList<>();

        for (WebElement c: link) {
            li.add(c.getAttribute("href"));
        }
        return li;
    }

    /**
     * Esto es para entrar a cada subpagina para pillar las infos que quiero.
     * @param driver esto lo uso para entrar al link.
     * @param driverWait lo uso para que se cargue la pagina
     * @param li esto son los links.
     * @param champions esto es donde guardas las infos de lo que pille.
     * @return devuelve una lista de campeons con las infos robadas.
     */
    public static List<Champion> robarInfo(WebDriver driver, WebDriverWait driverWait, List<String> li, List<Champion> champions){
        List<WebElement> nombreList = new ArrayList<>();
        WebElement rol;
        WebElement historia;
        String nom,rols,historias;

        for (String c: li) {
            driver.get(c);
            driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("style__OptionIconBorder-sc-1ac4kmt-7")));
            nombreList = driver.findElements(new By.ByClassName("style__RevealWrapper-sc-14kr0ky-0"));
            nom = nombreList.get(1).getText();
            rol = driver.findElement(new By.ByClassName("style__SpecsItemValue-sc-8gkpub-15"));
            rols = rol.getText();
            historia = driver.findElement(new By.ByClassName("style__Desc-sc-8gkpub-9"));
            historias = historia.getText();
            champions.add(new Champion(nom,rols,historias));

        }
        return champions;
    }
}
