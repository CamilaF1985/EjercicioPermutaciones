package ejercicioPermutacion;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*Hola, voy a abordar un ejercicio de programación que encontré en línea
 * La instrucción dice: 
 /*
 * Crea un programa que sea capaz de generar e imprimir todas las 
 * permutaciones disponibles formadas por las letras de una palabra.
 * - Las palabras generadas no tienen por qué existir.
 * - Deben usarse todas las letras en cada permutación.
 * - Ejemplo: sol, slo, ols, osl, los, lso 
 */

public class Permutaciones {
    // Función para intercambiar dos letras en un arreglo de cadena
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    // Primero, escribimos una función recursiva para generar todas las permutaciones o combinaciones posibles
    public static void generarPermutaciones(String word, int start, int end) {
        if (start == end) {
            // Cuando hemos llegado al final de la palabra, imprimimos la permutación
            System.out.println(word);
        } else {
            for (int i = start; i <= end; i++) {
                // Luego, intercambiamos el caracter en la posición 'start' con el caracter en la posición 'i'
                word = swap(word, start, i);

                // Generamos una llamada recursiva para generar las permutaciones restantes
                generarPermutaciones(word, start + 1, end);

                // Deshacemos el intercambio para volver al estado original
                word = swap(word, start, i);
            }
        }
    }

    /*Método main para solicitar al usuario el ingreso de la palabra
     * Debe funcionar con cualquier cadena de caracteres ingresada por teclado
     */
    public static void main(String[] args) {
        try {
            /*Establece la codificación de caracteres de la consola a UTF-8
             * para que la consola imprima caracteres propios de idioma español como
             * acentos y letra ñ.
             */
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una palabra: ");
        String word = scanner.nextLine();
        scanner.close();

        int n = word.length();

        // Llamamos a la función recursiva para generar las permutaciones
        generarPermutaciones(word, 0, n - 1);
    }
}

