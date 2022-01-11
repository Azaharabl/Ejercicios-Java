package azahara;
import java.util.Scanner;

/**
 * ejercicio de azahara
 *16. Simularemos el lanzamiento de una piedra a un río. Se pedirá al usuario donde quiere
 * lanzar la piedra (posición del vector) y la intensidad de la piedra (un número entero menor o
 * igual que la dimensión máxima del vector). Cuando se lance, se almacena en esa casilla la
 * pedrá y en las adyacentes se irán simulando las ondas con números que se van
 * decrementando. Ejemplo, si damos una pedrá del 4 en la posición 6: {0,0,1,2,3,4,3,2,1,0,0,0}
 * Después, cada segundo, se irá calmando el río restándole uno a las posiciones con número.
 * La simulación se parará cuando el río vuelva a estar en calma;
 */
public class ejercicio_azahara {
    public static void main(String[] args) {

        //crear matriz
        int lago [][] = new int[7][7];

        //imprimir lago para que elija la posicion
        imprimirLago(lago);

        //pedion el golpe
        int [] golpePiedra = new int [2];
        pedirGolpePiedra(lago, golpePiedra);

        //la piedra da en el lago y se pintan las hondas
        hacerTodasLasHondas(golpePiedra,lago);

        imprimirLago(lago);

        //la honda siempre durara 4 tiempos si la hay la menguamos e imprimimos si no termina el programa
        disminuirHonda(lago);


    }

    private static void disminuirHonda(int[][] lago) {
        //for para hacer los 4 tiempos
        for (int i = 0; i <4 ; i++) {
            disminuirHondaUnTiempo(lago);
            System.out.println("el lago se ha calmado un poco");
            imprimirLago(lago);
        }
        System.out.println("el lago se ha calmado del todo");
    }

    private static void disminuirHondaUnTiempo(int[][] lago) {
        for (int i = 0; i < lago.length ; i++) {
            for (int j = 0; j < lago.length; j++) {
                if (lago[i][j]!=0){
                    lago[i][j]=(lago[i][j]-1);
                }
            }
        }
    }

    private static void hacerTodasLasHondas(int[] golpePiedra, int[][] lago) {

        //donde cae la piedra
        lago [golpePiedra[0]][golpePiedra[1]] =4;
        //honda más cercana 1
        pintarHonda1(golpePiedra, lago);
        //honda 2
        pintarHonda2(golpePiedra, lago);
        //honda 3
        pintarHonda3(golpePiedra, lago);
    }

    private static void pintarHonda3(int[] golpePiedra, int[][] lago) {
        //creamos honda de 1
        //for para buscar todos los 1 y si no está escrito ponemos un 2
        for (int i = 0; i < lago.length; i++) {
            for (int j = 0; j < lago.length ; j++) {

                if (lago[i][j]==2){

                    //recorremos el alrededor con otros 2 for
                    for (int h = (i-1); h <= (i+1); h++) {
                        for (int k = (j-1); k<=(j+1) ; k++) {

                            //excluimos el numero ya puesto y los extremos
                            if ((h>=0 && h<lago.length) && (k>=0 && k<lago.length)&&(lago[h][k]==0)){
                                lago[h][k]=1;
                            }
                        }
                    }
                }
            }

        }
    }

    private static void pintarHonda2(int[] golpePiedra, int[][] lago) {
        //creamos honda de 2
        //for para buscar todos los 3 y si no está escrito al rededor ponemos un 2
        for (int i = 0; i < lago.length; i++) {
            for (int j = 0; j < lago.length ; j++) {

                //encontramos un 3
                if (lago[i][j]==3){

                    //recorremos el alrededor con otros 2 for
                    for (int h=(i-1); h <=(i+1); h++) {
                        for (int k=(j-1); k<=(j+1) ; k++) {

                            //excluimos el numero ya puesto y los extremos
                            if ((h>=0 && h<lago.length) && (k>=0 && k<lago.length) && (lago[h][k]==0)){
                                lago[h][k]=2;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void pintarHonda1(int[] golpePiedra, int[][] lago) {

        //creamos honda de 3
        //hacems un for desde la posicion de la piedra -1 hasta +1 para poner los numeros en todos
        for (int i = (golpePiedra[0]-1); i <= (golpePiedra[0]+1); i++) {
            for (int j = (golpePiedra[1]-1); j<=(golpePiedra[1]+1) ; j++) {

                //excluimos el numero ya puesto y los extremos
                if ((i>=0 && i<lago.length) && (j>=0 && j<lago.length)&&(lago[i][j]!=4)){
                    lago[i][j]=3;
                }
            }
        }
    }

    private static void imprimirLago(int[][] lago) {
        System.out.println("");
        for (int i = 0; i < lago.length; i++) {
            System.out.print(" [ ");
            for (int j = 0; j < lago[i].length; j++) {
                System.out.print("[ " + lago[i][j]+ " ]");
            }
            System.out.println(" ] ");
        }
    }

    private static void pedirGolpePiedra(int[][] lago, int [] glopePiedra) {
        System.out.println("coordenada 1 ");
        glopePiedra [0]= getCoordenada(lago);
        System.out.println("coordenada 2");
        glopePiedra [1]= getCoordenada(lago);
    }

    private static int getCoordenada(int[][] lago) {
        Scanner sc = new Scanner(System.in);
        boolean intCorrecto = false;
        int coordenada =-1;
        //hacemos esto hasta que la coordenada sea correcta
        do {
            try {
                System.out.println("dime la coordenada donde quieres tirar la piedra del 1 al "+lago.length);
                coordenada = (sc.nextInt()-1);
                if (coordenada>=0 && coordenada<=lago.length-1){
                    intCorrecto=true;
                }
            }catch (Exception e){
                sc.next();
            }

        }while (!intCorrecto);

        return coordenada;}
    }


