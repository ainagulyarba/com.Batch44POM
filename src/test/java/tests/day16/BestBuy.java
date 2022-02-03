package tests.day16;

import org.testng.annotations.Test;
import pages.BestbuyPage;
import utilities.Driver;

public class BestBuy {


    @Test
    public void test(){

        Driver.getDriver().get("https://www.bestbuy.com");
        BestbuyPage bestbuyPage=new BestbuyPage();
        bestbuyPage.ispanyolButonu.click();



    }






}
