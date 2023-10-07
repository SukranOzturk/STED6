package Gun13;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.Dimension;
public class _03_WindowSize extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://www.youtube.com/");
        MyFunc.Bekle(5);

        driver.manage().window().maximize(); // ekranı max yapıyordu.
        Dimension ekranBoyutu =driver.manage().window().getSize();
        System.out.println("ekranBoyutu.width = " + ekranBoyutu.width);
        System.out.println("ekranBoyutu.height = " + ekranBoyutu.height);

        MyFunc.Bekle(5);
        Dimension yeniBoyut=new Dimension(516,600);

        driver.manage().window().setSize(yeniBoyut); // ekrandaki pencereyi
        // istenilen boyutlara getirdim, teste böyle başlıyorum

        //  testler....
        BekleVeKapat();
    }
}