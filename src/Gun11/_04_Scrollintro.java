package Gun11;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class _04_Scrollintro extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
        MyFunc.Bekle(2);

        //Actions actionDriver= new Actions(driver); // driver dan action çalıştırabilen driver ürettik.

        JavascriptExecutor js= (JavascriptExecutor) driver; // casting

        js.executeScript("window.scrollTo(0, 500);"); // x, y  : baştan verilen yere gider

        MyFunc.Bekle(2);
        js.executeScript("window.scrollBy(0, 500);"); // en son kaldığı yerden 500 daha gider

        MyFunc.Bekle(2);
        js.executeScript("window.scrollBy(0, -200);"); // en son kaldığı yerden 200 geri gider

        BekleVeKapat();
    }
}