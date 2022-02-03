package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_YanlisKeyKullnimi {


    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        // eger key olarak String configuration.properties dosyasinda yoksa
        // Orn : HMCUrl yerine HMCurl yazarsak
        // configReader.getProperty()'u o key'i bulamaz ve
        // nullPointerException firlatir



    }
}
