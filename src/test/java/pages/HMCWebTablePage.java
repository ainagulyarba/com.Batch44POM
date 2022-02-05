package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {

    public HMCWebTablePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//theader//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;

    @FindBy(xpath = "//tbody")
    public WebElement tumBodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> tumBodyDatalariList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;


public WebElement satirYazdir(int satirNo){

    //2.satiri yazdir   //tbody//tr[2]
    //7.satir yazdir    //tbody//tr[7]
    String satirDinamikXpath="//tbody//tr["+ satirNo  +"]";
    WebElement satirElementi=Driver.getDriver().findElement(By.xpath(satirDinamikXpath));

    return satirElementi;



}


    public String hucreWebelemntGetir(int satir, int sutun) {
        //2.satirin 4.datasi    //tbody//tr[2]//td[4]
        //4.satirin 5.datasi       //tbody//tr[4]//td[5]
        String hucreDinamikXpath="//tbody//tr["+ satir  +"]//td["+ sutun  +"]";
        WebElement istenenHucreElementi=Driver.getDriver().findElement(By.xpath(hucreDinamikXpath));
        String hucreDatasi=istenenHucreElementi.getText();

        return hucreDatasi;

    }





}