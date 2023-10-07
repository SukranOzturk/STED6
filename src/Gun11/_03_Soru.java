package Gun11;

/*
   1-driver.get("https://chercher.tech/practice/frames"); sayfasına gidiniz.
   2-Inputa ülke adı yazınız
   3-CheckBox ı çekleyiniz.
   4-Select in 2.elemanını seçiniz.
 */
import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class _03_Soru extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://chercher.tech/practice/frames");
        MyFunc.Bekle(2);

        driver.switchTo().frame(0); // ilk frame e geçildi.
        WebElement input=driver.findElement(By.cssSelector("#topic+input"));
        input.sendKeys("Türkiye");
        // Şu anda 1.frame in içideyim , onun içindeki frame gidicem
        // 1 tane olduğu için index 0
        driver.switchTo().frame(0);
        WebElement chkBox= driver.findElement(By.id("a"));
        chkBox.click();

//        driver.switchTo().parentFrame();  // bi geri parente
//        driver.switchTo().parentFrame(); // daha sonra bi geri parente yani ansayfaya

        driver.switchTo().defaultContent(); // direkt ana sayfaya gidildi

        driver.switchTo().frame(1); // 2.frame geçildi.
        WebElement webSelect=driver.findElement(By.id("animals"));
        Select nesneSelect=new Select(webSelect);
        nesneSelect.selectByIndex(1); // 2.eleman : index olarak 1

        BekleVeKapat();
    }
}