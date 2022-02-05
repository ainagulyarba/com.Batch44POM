package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.naming.ConfigurationException;
import java.beans.ConstructorProperties;

public class PositiveLoginTesti {

    @Test
    public void positiveLoginTest(){


        //1) com.techproed altinda bir package olustur : smoketest
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //         https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //        login butonuna bas
        HotelMyCampPage hotelmyCampPage=new HotelMyCampPage();
        hotelmyCampPage.ilkLoginLinki.click();
        //test data username: manager ,
        hotelmyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //test data password : Manager1!
        hotelmyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelmyCampPage.loginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelmyCampPage.basariliGirisYaziElementi.isDisplayed());
        Driver.closeDriver();


    }










}
