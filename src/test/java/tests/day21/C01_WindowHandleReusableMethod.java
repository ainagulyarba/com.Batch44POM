package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C01_WindowHandleReusableMethod {

    @Test
    public void test01(){

        //https:/demoqa.com/browser-windows adresine gidelim
        //new tab butonuna basalim
        //new tab'a gecip title'inin "new Tab" oldugunu test edin

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWinwowHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> handleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:handleSeti) {
            if(!each.equals(ilkSayfaWinwowHandle)){
                ikinciSayfaHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(ilkSayfaWinwowHandle);
        System.out.println(ikinciSayfaHandle);

        Assert.assertEquals(actualTitle,expectedTitle);


    }
    @Test
    public void windowHandleReusableTest() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        ReusableMethods.getScreenshot("WindowSwitch");
        Assert.assertEquals(actualTitle,expectedTitle);


    }



}
