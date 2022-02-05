package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_EndToEndTesting {

    @Test
    public void createHotel() throws InterruptedException {

   //   1. Tests packagenin altına class olusturun: CreateHotel
   //   2. Bir metod olusturun: createHotel
   //   3. https://www.hotelmycamp.com adresine git.
   //   4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
   //   a. Username : manager
   //   b. Password  : Manager1!
   //           5. Login butonuna tıklayın.
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
   //   6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
     hotelMyCampPage.bekle(3);
    hotelMyCampPage.hotelManagementLinki.click();
    hotelMyCampPage.hotelListLinki.click();
    hotelMyCampPage.addHotelLinki.click();
    hotelMyCampPage.bekle(2);
   //   7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.click(hotelMyCampPage.addHotelCodeBox)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Select select=new Select(hotelMyCampPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type2");

   //   8. Save butonuna tıklayın.
     hotelMyCampPage.saveButton.click();

   //   9. “Hotel was inserted successfully” textinin göründüğünü test edin.
       WebElement text=Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertTrue(text.isDisplayed(),"text goruntusu testi basarisiz");

   //   10. OK butonuna tıklayın.
        Driver.getDriver().findElement(By.xpath("//button[text()='OK']")).click();





    }
}
