
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddNewPurchase {
    @Test

    public static void main(String[] args) throws InterruptedException{

        WebDriver webDriver = new ChromeDriver();
        //WebDriver webDriver = new EdgeDriver();
        //WebDriver webDriver = new FirefoxDriver();

        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://checkme.kavichki.com/#");
        WebElement linkAddNew  = waitForElementLocatedBy(webDriver, By.id("open"));
        linkAddNew.click();

        WebElement fieldNamePurchase  = webDriver.findElement(By.id("name"));
        fieldNamePurchase.sendKeys("milk");

        WebElement btnAdd = webDriver.findElement(By.id("add"));
        btnAdd.click();

        Thread.sleep(2000);

        WebElement searchNewPurchase = webDriver.findElement(By.xpath("//*[@id=\"tbl\"]/tbody/tr[5]/td[1]"));
        Assert.assertNotNull(searchNewPurchase, "purchase not added");

        webDriver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver webDriver, By by) {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
