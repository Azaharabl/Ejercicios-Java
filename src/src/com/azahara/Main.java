package com.azahara;
import java.util.Scanner;

public class Main {
    /**
     * @autor azahara blanco
     * Dada una matriz, imprimirla obtener el máximo, el mínimo y la media. Buscar si un
     * elemento existe en dicha matriz. Mostrar el elemento que más se repite.
     * @author Azahara Blanco Rodriguez
     * @date 2-11-2021 -6-11-2021
     */
    public static void main(String[] args) {
        //

        //crear una matriz;
        int [][] matriz = {{10,7,3},{4,6,6},{7,8,1}};
        int [] sumaMatriz ={0};


        //sacar el maximo;
        getnumeroMayor(matriz);

        //sacar el minimo;
        getnumeroMenor(matriz);

        //sacar suma
        getsumaMatriz(matriz,sumaMatriz);

        //sacar media
        getmediaMatriz(matriz,sumaMatriz);

        // comprobar si un elemento existe en dicha matriz
        busquedaDeNumero(matriz);

        //Mostrar el elemento que más se repite
        getNumeroMasRepetido(matriz);


    }

    /**
     * @descriptión te imprime por pantalla en numero mayor de la matriz
     * @return nada.
     */
    public static void getnumeroMayor(int[][] matriz) {
        int [] numeroMayor = {0};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(numeroMayor[0]<(matriz[i][j])){
                    numeroMayor[0]= matriz[i][j];
                }
            }
        }
        System.out.println("el numero mayor de la matriz es: "+ numeroMayor[0]);
    }

    /**
     * @descriptión te imprime por pantalla en numero menor de la matriz
     * @return nada.
     */
    public static void getnumeroMenor(int[][] matriz) {
        int numeroMenor = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(numeroMenor>(matriz[i][j])){
                    numeroMenor= matriz[i][j];
                }
            }
        }
        System.out.println("El numero menor de la matriz es: "+ numeroMenor);
    }

    /**
     * @descriptión te imprime por pantalla en numero resultado de la suma de todos los valores de la matriz
     * @return nada, pero te pasa por referencia el resultado de la suma en una matriz llamada sumaMatriz.
     */
    public static void getsumaMatriz(int[][] matriz , int [] sumaMatriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaMatriz[0]=sumaMatriz[0]+matriz[i][j];
            }
        }
        System.out.println("la suma es "+sumaMatriz [0]);
    }

    /**
     * @descriptión te imprime por pantalla en numero resultado de la media de todos los valores de la matriz
     * @return nada.
     */
    public static void getmediaMatriz(int[][] matriz , int [] sumaMatriz){
        float suma=sumaMatriz[0];
        float longitud=(matriz.length * matriz[0].length);
        float mediaMatriz = suma/longitud;
        System.out.println("La media de la matriz es : ");
        System.out.println(mediaMatriz);
    }

    /**
     * @descriptión te imprime por pantalla si dentro de la matris está un numero que tu le des
     * @return nada.
     * @use usa la funcion de getNumeroElegido
     */
    public static void busquedaDeNumero(int [][] matriz){
        int numeroElegido=getNumeroElegido();
        boolean isNumeroElegido = false;
        for (int i = 0; (i < matriz.length) && (isNumeroElegido!= true); i++) {
            for (int j = 0; (j < matriz[i].length) && (isNumeroElegido!= true); j++) {
                isNumeroElegido=numeroElegido==matriz[i][j];
            }
        }
        String mensaje =(isNumeroElegido)?"tu numero si esta!": "tu numero elegido no esta!";
        System.out.println(mensaje);
    }

    /**
     * @descriptión te pregunta y escanea un numero
     * @return un numero entero.
     */
    public static int getNumeroElegido(){
        Scanner sc = new Scanner(System.in);
        System.out.println("dime el numero que quieres buscar en la matriz");
        int numeroElegido = sc.nextInt();
        return numeroElegido;
    }

    /**
     * @descriptión calcula y imprime por pantalla el numero más repetido o los numeros que más se repiten.
     */
    public static void getNumeroMasRepetido(int [][] matriz){
        //iniciar una matriz con el mismo numero de casillas que nuestra matriz origuinal
        int [][] matrizNumeroRepetido= new int [3][3];

        //guardar en la nueva matriz vas veces que se repite cada numero
        cuantasVecesSeRepiteCadaNumero(matriz, matrizNumeroRepetido);

        //Cuantas veces se repite el numero más repetido
        int numeroMasRepetido = getnumeroMayorMatriz(matrizNumeroRepetido);

        //imprimir por pantalla el numero o numeros que se repitan el numero de
        // veces más alto(por si varos se repiten)
        imprimirNumeroMasRepetido(matrizNumeroRepetido,numeroMasRepetido,matriz);
    }

    /**
     * devuelve una matriz a la que añadimos cuantos  veces se repite cada numero de la ora matris
     * @param matriz es la matriz con numeros original
     * @param matrizNumeroRepetido donde guardaremos las repeticiones
     */
    public static void cuantasVecesSeRepiteCadaNumero(int[][] matriz, int[][] matrizNumeroRepetido) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                for (int k = 0; k < matriz.length ; k++) {

                    for (int l = 0; l < matriz.length; l++) {
                        if(matriz[i][j]== matriz[k][l]) {
                            matrizNumeroRepetido[i][j]= matrizNumeroRepetido[i][j]+1;
                        }
                    }
                }
            }
        }
    }

    /**
     * @descriptión devuelve e imprime por pantalla cuantas veces se repite
     * el numero más repetido en la matriz
     * @return veces que se repite el numero más repetido.
     */
    public static int getnumeroMayorMatriz(int[][] matriz) {
        int numeroMayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (numeroMayor < (matriz[i][j])) {
                    numeroMayor = matriz[i][j];
                }
            }
        }
        return numeroMayor;
    }

    /**
     * @descriptión  imprime por pantalla el o los numeros de la primero matriz
     * que esten más repetidos fijandose en la segunda matriz comparandolo con
     * el numero más repetido en la matriz
     * @return veces que se repite el numero más repetido.
     */
    public static void imprimirNumeroMasRepetido(int [][] matriz, int numeroMasRepetido,int [][] matrizOriginal){
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz.length ; j++) {
                if (matriz[i][j]==numeroMasRepetido){
                    System.out.println("el numero que más se repite es: "+matrizOriginal[i][j]);
                }
            }

        }
    }

}
