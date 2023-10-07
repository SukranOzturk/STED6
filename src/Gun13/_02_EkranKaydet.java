package Gun13;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class _02_EkranKaydet extends BaseDriver {

    @Test
    public void Test1() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        MyFunc.Bekle(2);

        //kendine kod yazıyorsun hızlı ilerlemek için
         driver.findElement(By.name("username")).sendKeys("ismet");
        // WebElement username=driver.findElement(By.name("username"));
        // username.sendKeys("İsmet"); // Şirketlerde bu şekilde yapılır ama kendime kod yazarken üstteki gibi yapabilirim
        driver.findElement(By.name("password")).sendKeys("1234");
        // WebElement password=driver.findElement(By.name("password"));
        // password.sendKeys("1234"); // Şirketlerde bu şekilde yapılır ama kendime kod yazarken üstteki gibi yapabilirim

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        List<WebElement> errorMsj = driver.findElements(By.xpath("//*[text()='Invalid credentials']"));

        if (errorMsj.size() > 0) { // hata olmuşSA : ekran görüntüsü kaydetmek istiyorum

            System.out.println("hata oldu");

            //ekran kaydet.

            TakesScreenshot ts=(TakesScreenshot) driver; //1.Aşama ekran görünütü alma değişkenini tanımladım
            File hafizadakiHali=ts.getScreenshotAs(OutputType.FILE); //2.Aşama ekran görüntüsü alındı, hafızada
            // Ekran görütüsünü dosya formatında hafızaya al: "get screenshot as  file"

            //3.Aşama hafızadaki ekran görütüsününü fiziksel dosyaya kaydetmem gerekiyor.
            //hafızadaki ekran kaydını, yolunu(path) ini ve ismini verdiğim şu dosyaya kaydet
            FileUtils.copyFile(hafizadakiHali, new File("ekranGoruntuleri\\screenshot.png"));

            // TODO : Öyle bir şey yapın ki her ekran kaydı , AYRI kaydedilsin. yılgunsaatdaksan
        }
        BekleVeKapat();
    }
}