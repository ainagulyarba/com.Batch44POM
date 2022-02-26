package tests.practice;


import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hotelListPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OtelProjesi extends TestBaseRapor {

        pages.hotelListPages hotelListPages=new hotelListPages();

        @Test
        public void TC_0001(){
            extentTest=extentReports.createTest("HotelMyCamp","\"LIST OF HOTELS\" yazisi gorunmeli");
            // 1-"https://www.hotelmycamp.com" sayfasina gider

            Driver.getDriver().get(ConfigReader.getProperty("anaSayfa"));
            extentTest.info("\"HotelMyCamp\" sayfasina girildi");
            // 2-"Log in" butonuna tiklar
            hotelListPages.ilkLoginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");
            // 3-"Username" kutusuna gecerli bir username girer
            hotelListPages.yoneticiUserName.sendKeys("manager");
            extentTest.info("\"Username\" kutusuna gecerli bir username girildi");
            // 4-"Password" kutusuna gecerli bir password girer
            hotelListPages.yoneticiPassword.sendKeys("Manager1!");
            extentTest.info("\"Password\" kutusuna gecerli bir password girildi");
            // 5-"Log in" butonuna tiklar
            hotelListPages.loginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");
            // 6-"Hotel Management"butonuna tiklar
            hotelListPages.hotelManagementButonu.click();
            extentTest.info("\"Hotel Management\"butonuna tiklandi");
            // 7-"Hotel list" butonuna tiklar
            hotelListPages.hotelListButonu.click();
            extentTest.info("\"Hotel list\" butonuna tiklandi");
            // 8-"LIST OF HOTELS" yazisinin goruldugunu test eder
            Assert.assertTrue(hotelListPages.basariliGirisYaziElementi.isDisplayed(),"test is failde");
            extentTest.info("LIST OF HOTELS yazisi goruldu");
            Driver.getDriver().quit();


        }

        @Test
        public void TC_0002(){
            extentTest=extentReports.createTest("HotelMyCamp","\"Edit Hotel\" yazisi gorunmeli  ");

            Driver.getDriver().get(ConfigReader.getProperty("anaSayfa"));
            extentTest.info("HotelMyCamp sayfasina girildi");

            hotelListPages.ilkLoginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.yoneticiUserName.sendKeys("manager");
            extentTest.info("\"Username\" kutusuna \"manager\" username girildi");

            hotelListPages.yoneticiPassword.sendKeys("Manager1!");
            extentTest.info("\"Password\" kutusuna \"Manager1!\" password girildi");

            hotelListPages.loginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.hotelManagementButonu.click();
            extentTest.info("\"Hotel Management\"butonuna tiklandi");

            hotelListPages.hotelListButonu.click();
            extentTest.info("\"Hotel list\" butonuna tiklandi");

            hotelListPages.detailsButonu.click();
            extentTest.info("\"Details\" butonuna tiklandi");

            Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
            List<String> list = new ArrayList<>(windowsHandle);
            Driver.getDriver().switchTo().window(list.get(1));
            Assert.assertTrue(hotelListPages.editHotelYaziElementi.isDisplayed());
            extentTest.info("Edit Hotel yazisi goruldu");

            Driver.getDriver().quit();
        }


        @Test
        public void TC_0003() throws InterruptedException {
            extentTest=extentReports.createTest("HotelMyCamp","Hotel bilgileri guncellenebilmeli");

            Driver.getDriver().get(ConfigReader.getProperty("anaSayfa"));
            extentTest.info("HotelMyCamp sayfasina girildi");

            hotelListPages.ilkLoginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.yoneticiUserName.sendKeys("manager");
            extentTest.info("\"Username\" kutusuna \"manager\" username girildi");

            hotelListPages.yoneticiPassword.sendKeys("Manager1!");
            extentTest.info("\"Password\" kutusuna \"Manager1!\" password girildi");

            hotelListPages.loginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.hotelManagementButonu.click();
            extentTest.info("\"Hotel Management\"butonuna tiklandi");

            hotelListPages.hotelListButonu.click();
            extentTest.info("\"Hotel list\" butonuna tiklandi");

            hotelListPages.detailsButonu.click();
            extentTest.info("\"Details\" butonuna tiklandi");

            ReusableMethods.switchToWindow("Admin ");
            Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
            List<String> list = new ArrayList<>(windowsHandle);
            Driver.getDriver().switchTo().window(list.get(1));
            Actions actions=new Actions(Driver.getDriver());
            Thread.sleep(3000);
            hotelListPages.codeBox.clear();
            hotelListPages.codeBox.sendKeys("1009A"+ Keys.TAB);
            hotelListPages.nameBox.clear();
            hotelListPages.nameBox.sendKeys("Rixos"+Keys.TAB);
            hotelListPages.adresBox.clear();
            hotelListPages.adresBox.sendKeys("Istiklal cad No5,Istanbul,Turkiye"+Keys.TAB);
            hotelListPages.phoneBox.clear();
            hotelListPages.phoneBox.sendKeys("05642431643"+Keys.TAB);
            hotelListPages.emailBox.clear();
            hotelListPages.emailBox.sendKeys("alican@hotmail.com"+Keys.TAB);

            Select select=new Select(hotelListPages.groupBox);
            select.selectByVisibleText("Hotel Type1");
            extentTest.info("Otel bilgileri guncellendi");

            hotelListPages.saveButonu.click();
            extentTest.info("\"Save\" butonuna tiklandi");
            ReusableMethods.waitForVisibility(hotelListPages.updatedSuccessfullyYazisi,10);

            Assert.assertTrue(hotelListPages.updatedSuccessfullyYazisi.isDisplayed(),"test is failde");
            extentTest.info("\"Hotel was updated successfully\" yazisi goruldu");

            hotelListPages.okButtonu.click();
            extentTest.info("\"Ok\" butonuna tiklandi");

            Driver.getDriver().quit();
        }


        @Test
        public void TC_0004(){
            extentTest=extentReports.createTest("HotelMyCamp","Otel bilgilerinin guncellendigi test edildi");

            Driver.getDriver().get(ConfigReader.getProperty("anaSayfa"));
            extentTest.info("HotelMyCamp sayfasina girildi");

            hotelListPages.ilkLoginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.yoneticiUserName.sendKeys("manager");
            extentTest.info("\"Username\" kutusuna \"manager\" username girildi");

            hotelListPages.yoneticiPassword.sendKeys("Manager1!");
            extentTest.info("\"Password\" kutusuna \"Manager1!\" password girildi");

            hotelListPages.loginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.hotelManagementButonu.click();
            extentTest.info("\"Hotel Management\"butonuna tiklandi");

            hotelListPages.hotelListButonu.click();
            extentTest.info("\"Hotel list\" butonuna tiklandi");

            hotelListPages.nameKumesi.sendKeys("Rixos");
            extentTest.info("Name kutusuna degisiklik yaptigi otel ismi \"Rixos\" yazildi");
            hotelListPages.searchButonu.click();
            extentTest.info("\"Search\" butonuna tiklandi");

            //  String actualYazi="Found total 2 records";
            //  String expectedYazi=hotelListPages.foundYazisi.getText();
            //  Assert.assertEquals(actualYazi,expectedYazi,"test is failde");
            String actualYazi= hotelListPages.aradigimizIsim.getText();
            String expectedYazi="Rixos";
            Assert.assertEquals(actualYazi,expectedYazi,"Test is Faild");
            extentTest.info("Aranan otel ismi bilgileri goruldu");

            //    Driver.getDriver().quit();

        }



        @Test
        public void TC_0005(){

            extentTest=extentReports.createTest("HotelMyCamp","Otel bilgileri silinmeli");

            Driver.getDriver().get(ConfigReader.getProperty("anaSayfa"));
            extentTest.info("HotelMyCamp sayfasina girildi");

            hotelListPages.ilkLoginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.yoneticiUserName.sendKeys("manager");
            extentTest.info("\"Username\" kutusuna gecerli bir username girildi");

            hotelListPages.yoneticiPassword.sendKeys("Manager1!");
            extentTest.info("\"Password\" kutusuna gecerli bir password girildi");

            hotelListPages.loginButonu.click();
            extentTest.info("\"Log in\" butonuna tiklandi");

            hotelListPages.hotelManagementButonu.click();
            extentTest.info("\"Hotel Management\"butonuna tiklandi");

            hotelListPages.hotelListButonu.click();
            extentTest.info("\"Hotel list\" butonuna tiklandi");

            hotelListPages.nameKumesi.sendKeys("Rixos");
            extentTest.info("Name kutusuna degisiklik yaptigi otel ismi \"Rixos\" yazildi");

            ReusableMethods.waitFor(3);
            hotelListPages.searchButonu.click();
            extentTest.info("\"Search\" butonuna tiklandi");

            ReusableMethods.waitFor(3);
            hotelListPages.aranaDetailsButonu.click();
            extentTest.info("Silmek istedigi otelin \"detail\" butonuna tiklandi");

            ReusableMethods.waitFor(3);

            Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
            List<String> list = new ArrayList<>(windowsHandle);
            Driver.getDriver().switchTo().window(list.get(1));

            SoftAssert softAssert=new SoftAssert();
            String actualYazi= hotelListPages.codeBox.getText();
            String expectedYazi="1009A";
            softAssert.assertEquals(actualYazi,expectedYazi,"Test is Faild");
            extentTest.info("Silmek istedigi otelin ismi \"Rixos\" olup olmadigi test edildi");
            ReusableMethods.waitFor(5);
            hotelListPages.deleteButonu.click();
            extentTest.info("\"Delete\" butonuna tiklandi");

            ReusableMethods.waitFor(5);

            softAssert.assertTrue(hotelListPages.continueYazisi.isDisplayed(),"test is faild");
            extentTest.info("\"Would you like to continue?\" yazisinin gorundugu test edildi");

            hotelListPages.okButtonu.click();
            extentTest.info("\"Ok\" butonuna tiklandi");

            ReusableMethods.waitFor(10);
            softAssert.assertTrue(hotelListPages.successfullyDeletedYazisi.isDisplayed());
            extentTest.info("\"Hotel successfully deleted\" yazisi goruldu");

            hotelListPages.okButtonu.click();
            extentTest.info("\"Ok\" butonuna tiklandi");
            softAssert.assertAll();
            //  Driver.getDriver().quit();

        }



    }
















