package cl.falabella.omniChanel.po;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertFalse;
public class HomeClientePO extends BasePage{


    public HomeClientePO (WebDriver driver){
        super(driver);
    }
    PaginaInicioPO page;
    /** popUpHome: es un popup que aparece despues de ingresar a la pagina
     * botMasTarde: es para salir del popUp y continuar flujo
     */
    @FindBy (id = "cyberbankBody")
    WebElement popUpErrorInicio;
    @FindBy (id="imageComponent0")
    WebElement popUpHome;
    @FindBy (xpath = "//p[contains(text(),'Más tarde')]")
    WebElement botMasTarde;


    /*******************************/
    /**Se revisan la cantidad de prodcutos desplegados en el home */
    @FindBy(id = "tableAlignProductosPrimarios")
    WebElement primeroProductos;
    @FindBy(id = "tableAlignProductosSecundarios")
    WebElement segundosProdcutos;
    @FindBy(id = "sectionAccount_repeat0_detailAccount")
    WebElement btnFlechaDerecha;
    /**Se verifica el boton para mostrar mas prodcutos */
    @FindBy (id = "btnOtrosProductos")
    WebElement botMasProductos;
    /**Sección de NAV en el home
     * Botones: Tranferencias -> Aterceros mismo Banco -> Cuentas Propias -> Agregar Destinatarios -> TRX Programadas -> historial de TRX
     * */
    @FindBy (id ="TRANSFERENCIAS")
    WebElement btnTransferencia;
    @FindBy(id="ATercerosMismoBanco")
    WebElement btnTRXTercerosMismoBanco;
    @FindBy (id = "Acuentaspropias")
    WebElement BtnTRXmismaCuenta;
    @FindBy (id = "AgendaDestinatarios")
    WebElement btnMisContactos;
    @FindBy(id = "Programada")
    WebElement btnTRXProgramadas;
    @FindBy (id = "CartolaDeTransferencias")
    WebElement btnCartolaTRX;
    /*************************************/

    @FindBy (id = "pagos")
    WebElement btnPagarRecargas;
    @FindBy (id = "AvanceYSuperAvance")
    WebElement btnAvances;
    @FindBy (id ="Invertir")
    WebElement btnInvertir;
    @FindBy (id="SolicitarProductos")
    WebElement btnSolicitar;
    @FindBy (id="CMRpuntosybeneficios")
    WebElement btnCmrPuntos;
    @FindBy (id="Descuestos")
    WebElement btnDescuentos;

    /***
     *  input malo
     */
    @FindBy (xpath = "//input[contains(@tabindex,'1')]")
    WebElement inTipoCuenta;
    @FindBy (xpath = "//td[div[contains(@class,'divContainer')]]")
    WebElement divCuenta;


    public void popUpError(){
        if (waitForClick(popUpErrorInicio)){
            String pop = popUpErrorInicio.getText();
            Log(pop);


        }else{
            Log("Se carga pagina");
        }
    }
    public void verificacionpopUp(){
        if(isVisible(popUpHome)){
            Log("Aparece PopUp");
            waitForElementToAppear(botMasTarde);
            botMasTarde.click();
            esperaCargaFalabellaOmnichanel();
        }else{
            Log("El popUP no es visible");
        }
    }
    /**Verifica la cantidad de productos desplegados en pantalla*/
    public boolean ProductosPrimarios() {
        int cuenta = 0;
        if (isVisible(primeroProductos)) {
            List<WebElement> eles = driver.findElements(By.xpath("//div[contains(@class,'tableDiv table-align_wrap-nowidth-float-left-pointer')]"));
            for (WebElement element : eles) {
                //Log( cuenta + element.getText());
                cuenta = cuenta + 1;
            }
            Log("Cantidad de Cuentas  = " + cuenta);
            assert (cuenta >= 2);
        }
        return true;
    }
    /**Se verifica la cantidad de productos desplegados despues de verificar si existe la opción de mas productos*/
    public boolean ProductosSecundarios(){
        int cuenta = 0;
        if(isVisible(segundosProdcutos)){
            List<WebElement> eles = driver.findElements(By.xpath("//div[contains(@id,'tableAlignProductosSecundarios')]//div[contains(@class,'repeteableSection')]"));
            for(WebElement element:eles){
                Log(cuenta + element.getText());
                //cuenta = cuenta +1;
                }
           // Log("Cantidad de Cuentas desplegadas = "+cuenta);
            //assert (cuenta >= 2);
            }
        return true;
        }
    public void masProductos(){
        if(isVisible(botMasProductos)){
            waitForElementToAppear(botMasProductos);
            botMasProductos.click();
            Log("Se pincha mas Productos");
        }else{
            Log("El cliente no tiene mas de una cuenta ");
            assertFalse(true);

        }
    }
    public void TrxTerceros(){
        position(driver,btnTransferencia);
        waitForElementToAppear(btnTRXTercerosMismoBanco);
        btnTRXTercerosMismoBanco.click();

    }
    public void trxMisCuentas(){
        position(driver, btnTransferencia);
        waitForElementToAppear(BtnTRXmismaCuenta);
        BtnTRXmismaCuenta.click();

    }

    public void ingresoCuenta(String TipoCuenta){
        //waitForElementToAppear(inTipoCuenta);
        //inTipoCuenta.sendKeys(TipoCuenta);
        String cuenta = "//span[contains(text(), '"+TipoCuenta+ "')]";
        String div = "//td[div[contains(@class,'divContainer')]]";
        WebElement cuentaCompleta = driver.findElement(By.xpath(div+cuenta));
        if(isVisible(cuentaCompleta)){
            btnFlechaDerecha.click();
        }

    }

    public boolean cuentaCuentas(){
        int cuenta = 0;
        if(isVisible(segundosProdcutos)){
            List<WebElement> eles = driver.findElements(By.xpath("//div[contains(@class,'tableDiv table-align_wrap-nowidth-float-left-pointer')]"));
            for(WebElement element:eles){
               // Log(cuenta + element.getText());
                cuenta = cuenta +1;
            }
            Log("Cantidad de Cuentas desplegadas = "+cuenta);
            assert (cuenta >= 2);
        }
        return true;
    }

}
