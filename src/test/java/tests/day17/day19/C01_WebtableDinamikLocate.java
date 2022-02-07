package tests.day17.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebtableDinamikLocate {

    //3 test ()'u olusturalim

    HMCWebTablePage hmcWebTablePage=new HMCWebTablePage();
    HotelMyCampPage hotelMyCampPage;

    @Test
    public void satirYazdirTesti(){
        hotelMyCampPage =new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        //1.() satir numarasi verdigimde bana o satirdaki Data'lari yazdirsin

        //2.satiri yazdir   //tbody//tr[2]
        //7.satir yazdir    //tbody//tr[7]

        hmcWebTablePage = new HMCWebTablePage();
        WebElement ucuncuSatirElementi=hmcWebTablePage.satirGetir(3);
        System.out.println(ucuncuSatirElementi.getText());


    }

@Test
    public void hucreGetirTesti(){
    hotelMyCampPage =new HotelMyCampPage();
    hotelMyCampPage.girisYap();

    //2.() satir No ve Data numarasi girdigimde verdigim Data'yi yazdirsin
    hmcWebTablePage = new HMCWebTablePage();

    //2.satirin 4.datasi    //tbody//tr[2]//td[4]
    //4.satirin 5.datasi       //tbody//tr[4]//td[5]

    hmcWebTablePage.hucreWebelementGetir(3,5);

    System.out.println("girdiginiz hucredeki element : "+ hmcWebTablePage.hucreWebelementGetir(3,5));


}


    @Test
    public void sutunYazdir(){

        hotelMyCampPage =new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        //3.() sutun numarasi verdigimde bana tum sutunu yazdirsin

        hmcWebTablePage = new HMCWebTablePage();
        hmcWebTablePage.sutunYazdir(4);



    }



}
