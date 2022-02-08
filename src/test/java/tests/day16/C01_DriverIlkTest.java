package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest {

    // Driver class'i sayesinde bizim eski driver oldu
    //artik driver'a ihtiyac varsa Driver.getDriver() yazacagiz

    @Test
    public void test01(){

       //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

       //amazon'a gittigimizi test edelim
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

        // Driver.getDriver ()'u her calistiginda
        //driver=new ChromeDriver(); komutundan oturu yeni bir driver olusturuyor
        //Biz Driver class'dan getDriver'i ilk calistirdigimizda new atamasi olsun
        //sonraki calismalarda atama olmasin istiyoruz
        // bunun icin driver=new ChromeDriver(); satiri bir if blogu icine alacagiz
       // Driver.closeDriver();


    }

    @Test
    public void test02(){

    //bestbay gidelim
    Driver.getDriver().get("https://www.bestbuy.com");

    //bestbay'a gittigimizi test edelim
    String actualUrl=Driver.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrl.contains("bestbuy"));

   // Driver.closeDriver();



}


}
