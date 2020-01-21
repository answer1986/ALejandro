package cl.falabella.omniChanel.po;

import cl.falabella.omniChanel.Services.DatosSistema;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.jws.WebResult;
import java.util.List;

public class TransferenciasTercerosPO extends BasePage {

    public TransferenciasTercerosPO (WebDriver driver){ super(driver);}
    /**
     * Seleccion Cuenta origen
     */
    @FindBy (id = "selectFieldCuentaOrigen")
    WebElement lCuentOrigen;
    /**
     * Seleccion de Cuenta
     */
    @FindBy (id = "selectFieldCuentaOrigenUno")
    WebElement Cuenta;
    /**
     * Seccion de cuenta
     */
    @FindBy (id = "tableAlignOrigen2")
    WebElement tbDatos;
    /**
     * BancoDestino
     */
    @FindBy (xpath = "//select[contains(@caption,'Banco de destino')]//option[contains(value,'')]")
    WebElement lBacoDestino;

    /**
     * Tipo de Cuenta
     */
    @FindBy (id = "selectFieldTipoCuenta")
    WebElement liTipoCUenta;
    @FindBy (xpath = "//select[contains(@caption,'Tipo de cuenta')]//option[contains(text(),'')]")
    WebElement lTipoCuenta;

    /**
     * Datos para la tranferencioa a terceros
     * N°Cuenta Destino
     * Rut Destinatario
     * Nombre Destinatario
     * Monto Transferir
     * Asunto Tanferencia
     * Correo Electronico Destinatario
     * CheckBox - Programar TRansferencia
     * Boton Continuar
     */
    @FindBy(xpath = "//input[contains(@caption,'Nro. de cuenta destino')]")
    WebElement tNroCuentaDestino;
    @FindBy (xpath = "//input[contains(@caption,'RUT')]")
    WebElement tRutDestino;
    @FindBy (xpath = "//input[contains(@caption,'Nombre')]")
    WebElement tNombreDestinatario;
    @FindBy (xpath = "//input[contains(@caption,'Monto')]")
    WebElement tMontoTransferir;
    @FindBy(xpath = "//input[contains(@caption,'Asunto')]")
    WebElement tAsuntoTRX;
    @FindBy(xpath = "//input[contains(@caption,'Correo')]")
    WebElement tCorreoDestinatario;
    @FindBy (id = "checkField0")
    WebElement chProgramarTransferencia;
    @FindBy(id = "actionButtonContinuar")
    WebElement btnContinuar;

    /**
     * Mensaje
     */
    @FindBy(id = "htmlTokenMethodLocked")
    WebElement mToken;


    public void SelecionCUentaOrigen(int valor){
        if(isVisible(lCuentOrigen)){
            position(driver, lCuentOrigen);
            List<WebElement> cuenta = driver.findElements(By.xpath("//Select[contains(@caption,'Cuenta')]//option[contains(text(),'Cuenta')]"));
            for(WebElement element : cuenta){

            }
            cuenta.get(valor).click();
        }
    }



    public void BancoDestino(int cuenta){
        waitForElementToAppear(lBacoDestino);
        List<WebElement> eles = driver.findElements(By.xpath("//select[contains(@caption,'Banco de destino')]//option[contains(text(),'')]"));
        for (WebElement element : eles) {
           // Log(element.getText());
        }
        eles.get(cuenta).click();
    }
    public void TipoDeCuentas(int cuenta){
        waitForElementToAppear(liTipoCUenta);
        List<WebElement> eles = driver.findElements(By.xpath("//select[contains(@caption,'Tipo de cuenta')]//option[contains(text(),'')]"));
        for(WebElement element:eles){
           // Log(element.getText());
        }
        eles.get(cuenta).click();


    }
    public void DatosTrx(){
        waitForElementToAppear(tNroCuentaDestino);
        tNroCuentaDestino.sendKeys("17250501505");
        tRutDestino.sendKeys("16909354-7");
        tNombreDestinatario.sendKeys("Automatizado");
        tMontoTransferir.sendKeys("150000");
        tAsuntoTRX.sendKeys("Prueba Automatizada");
        tCorreoDestinatario.sendKeys("p@p.cl");
        waitForElementToAppear(btnContinuar);
        btnContinuar.click();
    }
    public void ValidacionDatos(){
        if(isVisible(mToken)){
            String mensaje = mToken.getText();
            //Se debe cambiar por variable
            String mensajeCom = "Clave dinámica bloqueada por intentos fallidos. Llama al call center 600 390 6000 o dirígete a cualquiera de nuestras sucursales";
            if (mensaje.equals(mensajeCom)){
                Log("No se puede continuar la prueba por errores \n");
            }else {}
        }

    }




}
