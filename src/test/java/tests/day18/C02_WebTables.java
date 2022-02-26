package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HMCWebTablePage;


import java.util.List;

public class C02_WebTables {


   HotelMyCampPage hotelMyCampPage;
   HMCWebTablePage hmcWebTablePage;

    @Test
    public void login(){

     //   ● Bir class oluşturun : C02_WebTables
     //   ● login( ) metodun oluşturun ve oturum açın.

     //   ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
     //       ○ Username : manager
     //       ○ Password : Manager1!
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();



    }

    @Test (dependsOnMethods = "login")
    public void table(){
        //   ● table( ) metodu oluşturun
        //       ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // header kisminda 1.satir ve altindaki Data'lari locate edelim
        //    //thead//tr[1]//th
        hmcWebTablePage=new HMCWebTablePage();
        List<WebElement> headerDataList=hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi : "+headerDataList.size());

        //       ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //      //tbody
        System.out.println(hmcWebTablePage.tumBodyWebElement.getText());

        // eger body'yi tek bir Webelement olarak kocate edersek
        // icindeki tum data'lari get.Text() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil
        // body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains ()'u ile body'de olup olmadiklarini test edebiliriz

        // eger her bir data'yi ayri ayri almak istersek
        //  //tbody//td -> seklinde locate edip bir list'e atabiliriz

        List<WebElement> bodyTumDataList=hmcWebTablePage.tumBodyDatalariList;
        System.out.println("body'deki data sayisi: "+ bodyTumDataList.size());


    }

@Test (dependsOnMethods = "login")
    public void printRows(){

    //   ● printRows( ) metodu oluşturun //tr
    //  ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //  tbody//tr
    hmcWebTablePage=new HMCWebTablePage();
    System.out.println(hmcWebTablePage.satirlarListesi.size());

    //  ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    List<WebElement> satirlarWebElementListesi=hmcWebTablePage.satirlarListesi;
    for (WebElement each: satirlarWebElementListesi) {
        System.out.println(each.getText());
    }

    //  ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    System.out.println("4.satir : "+satirlarWebElementListesi.get(3).getText());



}
}
