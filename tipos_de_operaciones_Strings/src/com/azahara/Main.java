package com.azahara;

import java.util.Locale;

public class Main {
    /**
     * 6. Realizar un programa que le pida al usuario una cadena y le pregunte por otra. Debe
     *     comprobar si la segunda cadena está incluida en la primera.
     *
     * no comentado
     */
    public static void main(String[] args) {
	    //iniciar
        String frase ="Yo me llamo Azahara y estoy intentando usar Strings";

        //iniciar de orea manera
        String frase2 ;
        frase2="instanciamos así otra String pero de ortra manera";

        // metodos con Strings

        //saber el largo
        int largo = frase.length();
        System.out.println(largo);

        //saber un carracter en una posicion
        char letra = frase.charAt(0);
        System.out.println(letra);

        //hacer una cadena de una cadena más grande, inclullendo la primera exclullendo la última
        String minifrase = frase.substring(0,2);
        System.out.println(minifrase);

        //saber si dos String son exactamente iguales
        boolean sonIguales = frase.equals(frase2);
        System.out.println("las frases son esactamente igules :"+ sonIguales);
        boolean sonIgualesMenosMayusculas = frase.equalsIgnoreCase(minifrase);
        System.out.println("las frases son igules :"+ sonIgualesMenosMayusculas);

        //	Cadena	Une la cadena especificada al final de nuestra cadena
        String juntas = frase.concat(frase2);
        System.out.println(juntas);


        //	Entero	Devuelve el indice dentro de la cadena de la primera
        // coincidencia del caracter especificado a partir del indice especificado
        int indiceA = frase.indexOf("a",  0);
        int indiceA2 = frase.indexOf("a",20);
        System.out.println("tu primera coincidencia de a es"+indiceA);
        System.out.println("tu primera coincidencia de a es a partis el 20 es"+indiceA2);

        //	Entero	Devuelve el indice dentro de la cadena de la primera
        // coincidencia de la subcadena especificada a partir del indice informado
        int indiceAzahara = frase.indexOf( "Azahara", 0);
        System.out.println("tu primera coincidencia de azahara es a partis el 0 es"+ indiceAzahara );


        //toCharArray()	Char	Convierte la cadena en un Array de caracteres
        String nombre= "Azahara";
        char [] nombreVector = nombre.toCharArray();
            //imprimir la cadena para comprobar
            for (int i = 0; i < nombreVector.length; i++) {
            System.out.println(nombreVector[i]);
        }

        // combertir un vector de caracteres a una string
        String nombreReconstruido= new String(nombreVector);
        System.out.println("nombre recostuido es"+nombreReconstruido);


        //Cadena	Convierte toda la cadena a minusculas usando las reglas locales del sistema
        String minusculas = frase.toLowerCase();
        System.out.println("en minuslulas"+minusculas);

        //Cadena	Convierte toda la cadena a minusculas usando las reglas locales del sistema
        String Mallusculas = frase.toUpperCase();
        System.out.println("en mayusulas"+Mallusculas);

    }
}
