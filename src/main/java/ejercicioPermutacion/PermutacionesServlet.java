package ejercicioPermutacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Generamos una respuesta alternativa al problema para hacerla más interactiva
 * para el usuario. Para lograrlo creamos un Servlet que permita mostrar un formulario
 * de entrada, el que recibirá la palabra ingresada por teclado y a su vez mostrará las
 * permutaciones.
 */
public class PermutacionesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método para mostrar el formulario de entrada
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige al formulario JSP
        request.getRequestDispatcher("/views/permutaciones.jsp").forward(request, response);
    }

    // Método para procesar el formulario y generar permutaciones
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos la palabra ingresada por el usuario desde el formulario
        String word = request.getParameter("word");

        // Establece la codificación de caracteres de la respuesta a UTF-8
        response.setCharacterEncoding("UTF-8");

        // Creamos un PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();

        // Realizamos la generación de permutaciones y las almacenamos 
        generarPermutaciones(word, 0, word.length() - 1, out);

        // Cerramos el PrintWriter
        out.close();
    }

    // Función para generar todas las permutaciones o combinaciones posibles
    private void generarPermutaciones(String word, int start, int end, PrintWriter out) {
        if (start == end) {
            // Cuando hemos llegado al final de la palabra, escribimos la permutación 
            out.println(word);
        } else {
            for (int i = start; i <= end; i++) {
                // Intercambiamos el caracter en la posición 'start' con el caracter en la posición 'i'
                char[] wordChars = word.toCharArray();
                char temp = wordChars[start];
                wordChars[start] = wordChars[i];
                wordChars[i] = temp;
                word = new String(wordChars);

                // Generamos una llamada recursiva para generar las permutaciones restantes
                generarPermutaciones(word, start + 1, end, out);

                // Deshacemos el intercambio para volver al estado original
                wordChars = word.toCharArray();
                temp = wordChars[start];
                wordChars[start] = wordChars[i];
                wordChars[i] = temp;
                word = new String(wordChars);
            }
        }
    }
}




















