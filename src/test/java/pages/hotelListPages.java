package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class hotelListPages {

    public hotelListPages(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginButonu;

    @FindBy(id = "UserName")
    public WebElement yoneticiUserName;

    @FindBy(id = "Password")
    public WebElement yoneticiPassword;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementButonu;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
    public WebElement hotelListButonu;

    @FindBy(xpath ="//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
    public WebElement detailsButonu;

    @FindBy(xpath = "(//div[@class='caption'])[1]")
    public WebElement editHotelYaziElementi;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeBox;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement adresBox;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneBox;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailBox;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement groupBox;

    @FindBy(xpath = "(//button[text()='Save'])[1]")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[text()='Hotel was updated successfully']")
    public WebElement  updatedSuccessfullyYazisi;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButtonu;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement nameKumesi;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButonu;

    @FindBy(xpath = "//td[text()='Rixos']")
    public WebElement aradigimizIsim;

    @FindBy(xpath = "//a[@class='btn btn-xs default']")
    public WebElement aranaDetailsButonu;


    @FindBy(xpath = "//div[@class='dataTables_info'][1]")
    public WebElement foundYazisi;

    @FindBy(xpath = "//button[@id='btnDelete']")
    public WebElement deleteButonu;

    @FindBy(xpath = "//div[text()='Would you like to continue?']")
    public WebElement continueYazisi;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement successfullyDeletedYazisi;












}
