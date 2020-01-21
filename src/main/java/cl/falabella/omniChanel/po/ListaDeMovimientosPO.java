package cl.falabella.omniChanel.po;

import cl.falabella.omniChanel.util.OmniChanelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListaDeMovimientosPO extends BasePage {
    OmniChanelUtils util;

    public ListaDeMovimientosPO (WebDriver driver){
        super(driver);
    }
    @FindBy (id = "selectField_movimientos")
    WebElement liMovimientos;
    @FindBy(xpath = "//tr[contains(@class,'oddRow')]")
    WebElement primeraseccion;
    @FindBy(xpath = "//tr[contains(@class,'oddRow')]")
    WebElement segundaseccion;



    public boolean Buscarpor(){
        int aux=0;
        if(isVisible(liMovimientos)){
            position(driver,liMovimientos);
            List<WebElement> eles = driver.findElements(By.xpath("//div[contains(@id,'tableAlignProductosSecundarios')]//div[contains(@class,'repeteableSection')]"));
            for(WebElement element:eles){
              //Log(cuenta + element.getText());
                aux = aux +1;
                }
                Log("Cantidad de Cuentas desplegadas = "+aux);
                assert (aux >= 2);
            }
            return true;
        }
    public void Movimiento(){
        int pimer=0;
        int segun=0;
        if(isVisible(liMovimientos)){
            //util.ContadorLista(primeraseccion,primeraseccion);
        }
        }
    }

