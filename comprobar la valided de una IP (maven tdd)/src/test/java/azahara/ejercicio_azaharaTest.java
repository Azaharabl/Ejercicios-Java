package azahara;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("test de azahara para IP")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ejercicio_azaharaTest {
    
    //el largo es el adecuado
    @Test
    @Order(1)
    @DisplayName("lago maximo y minimo")
    public void ipLongitudTest() {
        assertTrue(ejercicio_azahara.ipLongitudCorrecta("0.0.0.0"),"longitud minima permitida");
        assertTrue(ejercicio_azahara.ipLongitudCorrecta("255.255.255.254"),"longitud maxima permitida");
        assertFalse(ejercicio_azahara.ipLongitudCorrecta(".0.0.0"),"demasiado corto");
        assertFalse(ejercicio_azahara.ipLongitudCorrecta("1255.255.255.254"),"demasiado largo");
    }

    //hay 3 puntos y no más
    @Test
    @Order(2)
    @DisplayName("Solo tenemos 3 puntos")
    public void therAre3PointsTest(){
        assertTrue(ejercicio_azahara.therAre3Points("255.255.255.254"),"tenemos 3 putos");
        assertFalse(ejercicio_azahara.therAre3Points(".000.00"),"hay menos puntos de los necesarios");
        assertFalse(ejercicio_azahara.therAre3Points(".255.255.255.254"),"hay mas puntos de los necesarios");
    }

    //los numeros son numeros
    @Test
    @Order(3)
    @DisplayName("los numeros son numeros")
    public void areNumbersTest(){
        assertTrue(ejercicio_azahara.areNumbers("255.255.255.254"),"todos son numeros");
        assertFalse(ejercicio_azahara.areNumbers("2a5.255.255.254")," no todos son numeros");
        assertFalse(ejercicio_azahara.areNumbers("255.255.255.2-4"),"no todos son numeros");
    }

    @Test
    @Order(4)
    @DisplayName("los numeros son numeros")
    public void eachOneIsNumberTest(){
        assertTrue(ejercicio_azahara.eachOneIsNumber("255"),"todos son numeros en el bloque");
        assertFalse(ejercicio_azahara.eachOneIsNumber("25-"),"no todos son numeros en el bloque");
    }

    // maximo de cada grupo es 255, escepto del ultimo que es 254
    @Test
    @Order(5)
    @DisplayName("los numeros son numeros correctos")
    public void isCorrectNumberTest (){
        assertTrue(ejercicio_azahara.isCorrectNumber("255.255.255.254"),"bloques correctos");
        assertTrue(ejercicio_azahara.isCorrectNumber("0.0.0.0"),"bloques correctos");
        assertFalse(ejercicio_azahara.isCorrectNumber("256.0.0.0"),"el numero del bloque es falso");
        assertFalse(ejercicio_azahara.isCorrectNumber("255.255.255.255"),"el ultimo bloque es mayor");
    }

    @Test
    @Order(6)
    @DisplayName("mayor a 0 menos a 255")
    public void estaEntre255_0Test() {
        assertTrue(ejercicio_azahara.estaEntre255_0(255),"numero correcto");
        assertTrue(ejercicio_azahara.estaEntre255_0(0),"numero correcto");
        assertFalse(ejercicio_azahara.estaEntre255_0(256),"numero incorrecto");
        assertFalse(ejercicio_azahara.estaEntre255_0(-1),"numero incorrecto");
    }

    @Test
    @Order(7)
    @DisplayName("mayor a 0 menos a 254")
    public void estaEntre254_0Test() {
        assertTrue(ejercicio_azahara.estaEntre254_0(254),"numero correcto");
        assertTrue(ejercicio_azahara.estaEntre254_0(0),"numero correcto");
        assertFalse(ejercicio_azahara.estaEntre254_0(255),"numero incorrecto");
        assertFalse(ejercicio_azahara.estaEntre254_0(-1),"numero incorrecto");
    }
}
