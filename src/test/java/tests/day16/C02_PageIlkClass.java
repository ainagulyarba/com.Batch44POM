package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {


    // POM 'de farkli class'lara farkli sekilde ulasilmasi benimsenmistir
    // Driver Class'i icin static yontemi kullaniyoruz
    // Page Class'lari ise obje uzerinden kullanilmasi tercih edilmistir

    @Test
    public void test01(){

        // amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //arama kutusuna Nutella yazip aratalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //atama sonuclarinin Nutella icerdigini test edelim
        String actualSonucStr=amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));

        Driver.closeDriver();

    }

    @Test
    public void test02(){

        //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //java icin arama yapalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("java"+Keys.ENTER);
        String sonucYazisiStr=amazonPage.sonucYazisiElementi.getText();

        //sonucun java icerdigini test edelim
        Assert.assertTrue(sonucYazisiStr.contains("java"));

        Driver.closeDriver();


    }



}