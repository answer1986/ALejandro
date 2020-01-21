package cl.falabella.omniChanel.test;

import cl.falabella.omniChanel.Services.DatosSistema;
import cl.falabella.omniChanel.po.BasePage;
import cl.falabella.omniChanel.po.HomeClientePO;
import cl.falabella.omniChanel.po.ListaDeMovimientosPO;
import cl.falabella.omniChanel.po.PaginaInicioPO;
import cl.falabella.omniChanel.util.OmniChanelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Test_Ultimos_Movimientos {
    String rut = DatosSistema.getDatoProperties("Rut2c");
    String pass = DatosSistema.getDatoProperties("Pass");
    String CuentaCorriente=DatosSistema.getDatoProperties("CtaCte");


    WebDriver driver;
    PaginaInicioPO page;
    HomeClientePO home;
    ListaDeMovimientosPO lista;
    BasePage base;
    OmniChanelUtils util;


    /**
     * Se crea BeforeEach SetUp para iniciar un chrome y se dan las opciones de maximizar y headless
     * headles es un chrome que se maneja en segundo plano
     * Start Maximized agranda la pantalla en su maxima
     */
    @BeforeEach
    public void SetUp(){
        BasicConfigurator.configure();// log4g
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");//Se inicia Chrome en segundo plano
        driver = new ChromeDriver(options);
        this.page = new PaginaInicioPO(driver);
        this.home = new HomeClientePO(driver);
        this.base = new BasePage(driver);
        this.util = new OmniChanelUtils();
        this.lista = new ListaDeMovimientosPO(driver);


    }

    @Test @Order(1) public void Test_01_UltmosMovimientos() throws IOException {
        page.Login(rut,pass);
        page.SeleccionAvatar();
        page.esperaCargaFalabellaOmnichanel();
        home.verificacionpopUp();
        home.ingresoCuenta(CuentaCorriente);
        base.esperaCargaFalabellaOmnichanel();
        lista.Movimiento();


    }

    @AfterEach    public void cerrar(){
        driver.close();
    }
}
