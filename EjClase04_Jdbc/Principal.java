import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        String input;

        System.out.println("Ingrese el número de opción: ");
        System.out.println("1 - Cargar un Usuario");
        System.out.println("2 - Cargar un Tipo de usuario");
        System.out.println("3 - Cargar un Tipo de documento");
        System.out.println("4 - Consultar por nombre de usuario");
        System.out.println("4 - Consultar listado de usuarios registrados");
        System.out.println("5 - Salir");

        input = entrada.readLine();
        System.out.println(input);

        //Valído si no es número, si no es, pide que ingrese nuevamente el valor hasta que lo sea
        while(!esNumero(input)){
            System.out.println("El valor ingresado debe ser un valor numérico entre 1 y 5.");
            System.out.print("Ingrese nuevamente la opción: ");
            input = entrada.readLine();
        };

        //Valido que el valor numérico ingresado esté entre 1 y 5, si no está entre esos valores solicita que
        // se ingrese nuevamente hasta que cumpla la condición
        while(esNumero(input) && (Integer.parseInt(input)<1 || Integer.parseInt(input)>5)){
            System.out.println("El número ingresado debe estar entre 1 y 5.");
            System.out.print("Ingrese nuevamente la opción: ");
            input = entrada.readLine();
        };

    }

    /**
     * Metódo que verifica si el valor que recibe por parámentro es un número o no.
     * Devuelve true en caso de que lo sea y false si no es número.
     * @param input
     * @return
     */
    private static boolean esNumero(String input){
        boolean resultado;

        try {
            Integer.parseInt(input);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
