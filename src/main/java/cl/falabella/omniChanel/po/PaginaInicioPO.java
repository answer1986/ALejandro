package cl.falabella.omniChanel.po;

import cl.falabella.omniChanel.Services.DatosSistema;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

public class PaginaInicioPO extends BasePage{

    public PaginaInicioPO (WebDriver driver){
        super(driver);
    }
    private String url = DatosSistema.getDatoProperties("URLOmni1");
    private String url2 = DatosSistema.getDatoProperties("URLOmni2");



    @FindBy(xpath = "//input[contains(@caption,'Rut')]")
    WebElement RUTogin;
    @FindBy (xpath = "//input[contains(@caption,'Multiclave')]")
    WebElement PassLogin;
    @FindBy (id = "actionButtonIngresarBFCH")
    WebElement ingresarButton;
    @FindBy (id = "errorMsgPlaceholder")
    WebElement poUpError;
    /***
     * Avatar
     */
    @FindBy (xpath = "//img[contains(@alt,'Avatar 27')]")
    WebElement sAvatar;
    @FindBy (id = "constantLabelTitulo")
    WebElement idAvatar;
    @FindBy (id = "actionButton0")
    WebElement btnSiguiente;



    public void Login (String rut, String pass){
        Log("Se ingresa a OmniChanel");
        driver.get(url2);
        waitForElementToAppear(RUTogin);
        RUTogin.sendKeys(rut);
        waitForElementToAppear(PassLogin);
        PassLogin.sendKeys(pass);
        waitForElementToAppear(ingresarButton);
        ingresarButton.click();
    }
    public void popUp(){
        if (isVisible(poUpError)){
            poUpError.getText();
            assertTrue(false);
            Log("Error de pagina");
        }

    }

    public void SeleccionAvatar(){
        esperaCargaFalabellaOmnichanel();
        if(isVisible(idAvatar)){
            idAvatar.getText();
            waitForElementToAppear(sAvatar);
            sAvatar.click();
            waitForClick(btnSiguiente);
            btnSiguiente.click();
            esperaCargaFalabellaOmnichanel();
        }
    }

}
