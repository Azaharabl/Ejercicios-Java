package com.azahara;
import java.util.Scanner;


public class Main {

    /**
     * @DESCRIPCION : VAMOS A PROGRAMAR UN JUEGO DONDE UNO JUEGE CONTRA EL ORDENADOR,
     * TENDREMOS CADA UNO 10 CANICAS , ELIGIREMOS UN NUMERO DE CANICAS QUE PONDREMOS EN LA MANO,
     * CADA UNO APOSTARÁ SI EL OTRO TIENE EN SU MANO UN NUMERO PAR O IMPAR,
     * FINALMENTE ABRIRAN LAS MANOS DESCUBRIENDO QUIEN HA GANADO, Y EL JUGADOR QUE HA PERDIDIO DARÁ SUS
     * CANICAS A EL OTRO JUGADOR.
     *
     * FINALIZARÁ EL JUEGO CUANDO UNO SE QUEDE SIN CANICAS Y EL OTRO TENGA TODAS.
     *
     */
    public static void main(String[] args) {

        // iniciar canicas de jugadores
        int [] canicasYo={10};
        int [] canicasOrdenador={10};

        //hacemos todos hasta que uno pierda
        boolean finJuego=false;
        do {

            //elegir cuantas canicas ordenador
            int manoOrdenador=manoOrdenador(canicasOrdenador);

            //elegir cuantas canicas yo
            int manoYo = pedirNumero(canicasYo);

            //intentamos adivinar si es par o impar
            int apuestaParOImpar= apostar();

            //el ordenador intenta adivinar las que tenemos
            int apuestaParOImparOrdenador= apuestaOrdenadorParOImpar();

            //abrimos manos(imprimimos por pantalla)
            abrimosManos(manoOrdenador,manoYo, apuestaParOImpar,apuestaParOImparOrdenador);

            //comparamos resultados
            resultadoDeEstaJugada(manoOrdenador,manoYo,apuestaParOImparOrdenador,apuestaParOImpar,canicasYo,canicasOrdenador);

        }while ((canicasOrdenador[0]!=0) && (canicasYo[0]!=0) );




    }

    /**
     *
     */
    public static int manoOrdenador(int []canicasOrdenador){
        int manoOrdenador= (int) ((Math.random()  * canicasOrdenador[0])+1);
        return manoOrdenador;
    }
    /**
     *
     */
    public static int pedirNumero(int [] canicasYo){
        //do while hasta que introduccamos el numero de canicas correcto
        int manoApostada;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime el numero de canicas quieres apostar , que sea menor a: "+ canicasYo[0]);
           manoApostada = sc.nextInt();
        }while ((manoApostada>canicasYo[0]) || (manoApostada<1));

        return manoApostada;
    }
    /**
     *
     */
    public static int apostar(){
        //do while hasta que introduccamos la apuesta correcta
        int apuesta;
        do {
            Scanner sp = new Scanner(System.in);
            System.out.println("Dime si crees que el otro jugador ha aostado un numero par(1) o impar(2) : 1/2 ");
            apuesta = sp.nextInt();
        }while ((apuesta!=1) && (apuesta!=2));

        return apuesta;
    }
    /**
     *
     */
    public static int apuestaOrdenadorParOImpar (){
        int apuestaOrdenadorParOImpar= (int) ((Math.random()  * 2)+1);

        return apuestaOrdenadorParOImpar;
    }
    /**
     *
     */
    public static void abrimosManos(int manoOrdenador, int manoYo,int apuestaParOImpar, int apuestaParOImparOrdenador ){
        System.out.println(" El ordenador tiene en la mano " +manoOrdenador);
        System.out.println(" Yo habia apostado que el ordenador tenia unnumero " +apuestaParOImpar);
        System.out.println(" Yo tengo en la mano " +manoYo);
        System.out.println(" El ordenador habia apostado que yo tenia un numero  " +apuestaParOImparOrdenador);
    }
    /**
     *
     */
    public static void resultadoDeEstaJugada(int manoOrdenador, int manoYo, int apuestaParOImparOrdenador,int apuestaParOImpar,int []canicasYo, int []canicasOrdenador){

        //vemos quien ha acertado la apuesta
        boolean aciertoDelOrdenador = esAcierto(apuestaParOImparOrdenador, manoYo);
        boolean aciertoYo = esAcierto( apuestaParOImpar, manoOrdenador);

        //vemos si han empatado
        boolean esEmpate= esEmpate( aciertoDelOrdenador, aciertoYo);
        if (esEmpate==true){
            System.out.println(" Nadie gano porque es un empate, nadie pierde sus canicas ");

            //si no es empate miramos qien gano
        }else if (aciertoDelOrdenador==true){
            System.out.println("Gano el ordenador y tienes que darle tus canicas ");
            canicasYo[0]=(canicasYo[0]-manoYo);
            canicasOrdenador[0]=(canicasOrdenador[0]+manoYo);
            System.out.println(" Tus canicas se quedan en  "+canicasYo[0]+ "  las canicas del ordenador son: "+canicasOrdenador[0]);
        }else{
            //si no gano el ordenador y no hay empate es porque gane yo
            System.out.println("guay!! gane yo, asi que te quedas con las canicas del ordenador");
            canicasOrdenador[0]=(canicasOrdenador[0]-manoOrdenador);
            canicasYo[0]=(canicasYo[0]+manoOrdenador);
            System.out.println("  tus canicas se quedan en "+canicasYo[0]+ "  las canicas del ordenador son: "+canicasOrdenador[0]);
        }

    }
    /**
     *
     */
    public static boolean esEmpate(boolean acietoDelOrdenador, boolean aciertoYo){
        boolean esempate=false;
       if (aciertoYo==acietoDelOrdenador){
           esempate=true;
       }
        return esempate;
    }
    /**
     *
     */
    public static boolean esAcierto(int apuesta, int manoContraria){
        boolean esAcierto = false;
        boolean manoImpar=false;
        boolean apostoImpar=false;
        int aux = manoContraria%2;
        //miramos si en la mano tiene un numero de canicas impar o impar
        if (0== aux){
            manoImpar=false;
        }else{
            manoImpar=true;
        }
        //miramos si el contraro aposto que era par o impar
        if (apuesta==1){
            apostoImpar=true;
        }
        //damos solucion
        if (manoImpar==apostoImpar){
            esAcierto=true;
        }
        return esAcierto;

    }

}
