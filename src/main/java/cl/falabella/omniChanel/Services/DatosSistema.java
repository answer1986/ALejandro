package cl.falabella.omniChanel.Services;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DatosSistema {
    //private static final Logger LOGGER = Logger.getLogger(DatosSistema.class);
    public static final String ARCHIVO_PROPIEDADES = "test.properties";
    private static Properties properties;

    static {

        InputStream input;

        try {
           // LOGGER.info("Obtener Propiedades - init");
            properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            input = loader.getResourceAsStream(ARCHIVO_PROPIEDADES);
            properties.load(input);

           // LOGGER.info("Cargar Propiedades - end");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Excepcion EMT- Archivo " + ARCHIVO_PROPIEDADES + " no encontrado.", e);
        } catch (IOException e) {
            throw new RuntimeException("Excepcion EMT- Archivo " + ARCHIVO_PROPIEDADES + " no pudo ser cargado.", e);
        }
    }

    public static String getDatoProperties(String value) {
        //LOGGER.info("Obtener Propiedades - end");
        return properties.getProperty(value);
    }

    public static Integer getDatoPropertiesInt(String value) {
       // LOGGER.info("Obtener Propiedades - end");
        return Integer.parseInt(properties.getProperty(value));
    }
    public static String getTarjetaCoordenadas(String llaveTarjeta, String coordenada) throws Exception {
        String value = llaveTarjeta;
        if (value == null) {
            throw new Exception("Properties de Tarjeta de coordenadas mal cargada llave:" + llaveTarjeta);
        }
        Map<String, String> map = new HashMap<String, String>();
        String arr1[] = value.split(";");
        if (arr1.length != 50) {
            throw new Exception("Properties de Tarjeta de coordenadas mal cargada, validacion largo");
        }
        for (String string : arr1) {
            String arr2[] = string.split(":");
            String key1 = arr2[0];
            String value1 = arr2[1];
            map.put(key1, value1);
        }

        String v = map.get(coordenada);
        if (v == null) {
            throw new Exception("Properties de Tarjeta de coordenadas mal cargada");
        }
        return v;
    }
}