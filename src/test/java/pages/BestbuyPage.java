package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BestbuyPage {

    public BestbuyPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

        @FindBy (xpath = "//button[text()='Español']")
         public WebElement ispanyolButonu;


}
