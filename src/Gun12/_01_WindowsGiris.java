package Gun12;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _01_WindowsGiris extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        MyFunc.Bekle(2);

        String anaSayfaWindowId = driver.getWindowHandle(); // bulunduğum yani ana sayfanın id sini aldım

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement e : linkler) {
            // e.click();
            js.executeScript("arguments[0].click();", e);
        }

        Set<String> windowsIdler = driver.getWindowHandles();  // açılan tüm windowsların id sini verir
        for (String id : windowsIdler)
            System.out.println("id = " + id);

        MyFunc.Bekle(2);
        driver.switchTo().window(anaSayfaWindowId); // ilgili Window (Tab) a geçiş

        BekleVeKapat();
    }
}