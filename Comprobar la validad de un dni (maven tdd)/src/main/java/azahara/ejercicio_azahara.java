package azahara;
import java.util.Scanner;

/**
 * ejercicio de azahara para comprobar un dni es valido
 *
 */
public class ejercicio_azahara {
    public static void main(String[] args) {
        String dni = pedirDni();
        boolean isNumber = isNumber(dni);
        boolean isLetterTheLast = isLetterTheLast(dni);
        boolean isCorrectLong = isCorretLong(dni);
        boolean isCorrectLetter = isCorrectLetter(dni);


        if (isNumber && isLetterTheLast && isCorrectLetter && isCorrectLong){
            System.out.println("el DNI es correcto");
        }else {
            System.out.println("el DNI NO es correcto");
        }

    }

    private static String pedirDni() {
        Scanner cs = new Scanner(System.in);
        System.out.println("dime el dni que quieres verificar");
        String dni = cs.next();
        return dni;
    }

    public static boolean isCorretLong(String dni) {
        Boolean isCorrectLong = (dni.length()==9);
        return isCorrectLong;
    }

    public  static boolean isNumber(String dni) {
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))){
                return false;
            }
        }
        return true;
    }

    static boolean isLetterTheLast(String dni) {
        return Character.isLetter(dni.charAt(8));
    }

    public static boolean isCorrectLetter(String dni) {
        /**
         * Para obtener la letra del DNI solo hay que dividir el número entre 23
         * y el número resultante del resto de esta división hay que buscarlo
         * en la siguiente lista que nos indicará que letra le corresponde:
         * Por ejemplo al número de DNI 12345678 al dividirlo entre 23 el resultado es 536768 y resto 14.
         * String caracteres="TRWAGMYFPDXBNJZSQVHLCKE";
         */
        String numbersDni = dni.substring(0,8);
        String caracteres ="TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.valueOf(numbersDni);
        int numberOfLetter = (number%23);
        String correctLeter= caracteres.substring(numberOfLetter,numberOfLetter+1);
        String dniLetter = dni.substring(8);
        return correctLeter.equalsIgnoreCase(dniLetter);
    }
}


