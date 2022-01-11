package azahara;
import java.util.Scanner;

/**
 * ejercicio de Azahara Blanco Rodriguez TDD
 *
 * indicar si una IP  que pasas por teclado es correcta,
 *
 */
public class ejercicio_azahara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la ip que quieres analizar: ");
        String ip = sc.next();

        boolean longitudIsCorrecta =ipLongitudCorrecta(ip);
        boolean tiene3puntos =therAre3Points(ip);
        boolean sonNumeros =areNumbers(ip);
        boolean losNumerosSonCorrectos = false;
        if (sonNumeros){
            losNumerosSonCorrectos =isCorrectNumber(ip);
        }


        if (longitudIsCorrecta && tiene3puntos && sonNumeros && losNumerosSonCorrectos){
            System.out.println("La ip es correcta");
        }else{
            System.out.println("la ip no es correcta");
            if (!longitudIsCorrecta){
                System.out.println("la longitud no es correcta");
            }
            if (!tiene3puntos){
                System.out.println("No tienen 3 puntos");
            }
            if (!sonNumeros){
                System.out.println("Tienen caracteres que no son numeros");
            }
            if (!losNumerosSonCorrectos){
                System.out.println("Los numeros no son correctos");
            }
        }

    }

    public static boolean ipLongitudCorrecta(String ip){
        if ((ip.length()>=7) && (ip.length()<=15)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean therAre3Points(String ip) {
        int puntos=0;
        for (int i = 0; i < ip.length(); i++) {
            String cararcter= ip.substring(i,(i+1));
            if (cararcter.equals(".")){
                puntos++;
            }
        }
        return (puntos==3);
    }

    public static boolean areNumbers(String ip) {

        // buscamos la posicion de los puntos
        int punto1=ip.indexOf(".");
        int punto2=ip.indexOf(".",(punto1+1));
        int punto3=ip.indexOf(".", (punto2+1));


        //hacemos las 4 substrings que serán numeros

        String bloque1 = ip.substring(0,punto1);
        String bloque2 = ip.substring(punto1+1,punto2);
        String bloque3 = ip.substring(punto2+1,punto3);
        String bloque4 = ip.substring(punto3+1);

        //coger cada numero y  character.isnumber

        boolean bloque1isNumber = eachOneIsNumber(bloque1);
        boolean bloque2isNumber = eachOneIsNumber(bloque2);
        boolean bloque3isNumber = eachOneIsNumber(bloque3);
        boolean bloque4isNumber = eachOneIsNumber(bloque4);

            // ver cada punto donde está

        if (bloque1isNumber && bloque2isNumber && bloque3isNumber && bloque4isNumber){
            return true;
        }

        return false;
    }

    public static boolean eachOneIsNumber(String bloque) {
        for (int i = 0; i < bloque.length(); i++) {
            if (!Character.isDigit(bloque.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectNumber(String ip) {
        // buscamos la posicion de los puntos
        int punto1=ip.indexOf(".");
        int punto2=ip.indexOf(".",(punto1+1));
        int punto3=ip.indexOf(".", (punto2+1));


        //hacemos las 4 substrings que serán numeros

        String bloque1 = ip.substring(0,punto1);
        String bloque2 = ip.substring(punto1+1,punto2);
        String bloque3 = ip.substring(punto2+1,punto3);
        String bloque4 = ip.substring(punto3+1);

        // lo pasamos a numeros y vemos si es mayor o menor al indicado
        int int1 =Integer.parseInt(bloque1);
        int int2 =Integer.parseInt(bloque2);
        int int3 =Integer.parseInt(bloque3);
        int int4 =Integer.parseInt(bloque4);

        boolean isCorrect1 = estaEntre255_0(int1);
        boolean isCorrect2 = estaEntre255_0(int2);
        boolean isCorrect3 = estaEntre255_0(int3);
        boolean isCorrect4 = estaEntre254_0(int4);

        if (isCorrect1 && isCorrect2 && isCorrect3 && isCorrect4){
            return true;
        }
        return false;
    }

    public static boolean estaEntre255_0(int numero) {
        if (numero<=255 && numero>=0){
            return true;
        }
        return false;
    }

    public static boolean estaEntre254_0(int numero) {
        if (numero<=254 && numero>=0){
            return true;
        }
        return false;
    }
}

