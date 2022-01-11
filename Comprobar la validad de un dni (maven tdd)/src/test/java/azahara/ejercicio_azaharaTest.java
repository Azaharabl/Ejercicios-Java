package azahara;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("test de azahara") //para poner nombre a el test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //para poner un orden a los metodos
public class ejercicio_azaharaTest {    //la clase donde van tosos los test

   // Datos que van a ser correctos para probar todos los tes

    String DNI = "51590695Q";



    @Test   //siempre que iniciamos un test
    @Order(1) //si queremos iniciar los test en orden
    public void isCorrectLongTest() {
        //longitud correcta

        //preparacion(los valores que necesitamos para probarlo

        //valor corrcto = gloval

        // valor por debajo
        String dniShort ="5371792A";

        //valor por encima
        String dniLong = "537179291A";

        // Actuar (llamar a la funcion que vamos a probar

            //como nuestra funcion va a devolver ya un Boloean no lo tenemos que hacer de nuevo

        //Verificamos que da lo que tiene que dar ya sea false o true
        assertTrue(ejercicio_azahara.isCorretLong(DNI),"La longitud es correcta");
        assertFalse(ejercicio_azahara.isCorretLong(dniShort),"la longitud es incorrecta");
        assertFalse(ejercicio_azahara.isCorretLong(dniLong),"la longitud es incorrecta");





    }

    @Test
    @Order(2)
    public void isNumberTest() {
        //preparacion(los valores que necesitamos para probarlo

        //incorrecto
        //es una letra o un signo
        //no puede se mayor o menor porque si no existiria un signo o dos numeros al tener dos digitos
        String dniWrong ="53a17929A";

        // Actuar (llamar a la funcion que vamos a probar pero no lo hacemos porque ya dará boolean

        //Verificamos que da lo que tiene que dar ya sea false o true

        assertTrue(ejercicio_azahara.isNumber(DNI),"todos son números ");
        assertFalse(ejercicio_azahara.isNumber(dniWrong),"hay alguna letra");

    }

    @Test
    @Order(3)
    public void isLetterTheLastTest(){
        //valores a probar
            //tue ya lo tenemos
            //probar con una letra en minuscula
            String DNIMIN = "53717929a";
            //false que sea un numero o un caracter
            String DNIWRONG1= "537179291";
            String DNIWRONG2= "53717929.";

        //La preparacion no hace falta porque devuelve un bolean
        //ejecucion
        assertTrue(ejercicio_azahara.isLetterTheLast(DNI));
        assertTrue(ejercicio_azahara.isLetterTheLast(DNIMIN));
        assertFalse(ejercicio_azahara.isLetterTheLast(DNIWRONG1));
        assertFalse(ejercicio_azahara.isLetterTheLast(DNIWRONG2));

    }

    @Test
    @Order(4)
    public void isCorrectLetterTest(){
        //preparamos los resultados
            //el bueno lo tenemos
            //el herroneo
        String DNIWRONG= "53717929E";

        //va ha devolver booleano asi que no hay preparacion

        //comprobamos los resultados

        assertTrue(ejercicio_azahara.isCorrectLetter(DNI),"la letra es correcta");
        assertFalse(ejercicio_azahara.isCorrectLetter(DNIWRONG),"la letra es incorrecta");
    }


}
