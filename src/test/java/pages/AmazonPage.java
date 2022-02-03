package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    //Bir Page Class'i actigimizda ilk yapmamiz gereken sey
    //p'siz bir constructor olusturup
    //bu constructor icine Page Factory ile driver'a ilk deger atamasini yapmak olmalidir

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonAramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;




}
