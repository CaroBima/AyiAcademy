import model.TipoUsuario;
import repository.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        DbConnection  dbconection = new DbConnection();

        String input = mostrarMenu(entrada);

        int opcionSeleccionada = Integer.parseInt(input);

        switch(opcionSeleccionada){
            case 1:
                System.out.println("Aún en desarrollo");
                mostrarMenu(entrada);
                break;
            case 2: //carga un nuevo tipo de usuario, ingresado por teclado
                TipoUsuario nuevoTipoUsuario = cargarTipoUsuario();
                dbconection.registrarTipoUsuario(nuevoTipoUsuario);
                mostrarMenu(entrada);
                break;
            case 3:
                dbconection.listarTipoUsuario();

        }
    }

    /**
     * Muestra el menú de opciones para que el usuario pueda ingresar por teclado el número de la acción que
     * desea realizar
     * @param entrada
     * @return
     * @throws IOException
     */
    private static String mostrarMenu(BufferedReader entrada) throws IOException {
        String input;

        System.out.println("Ingrese el número de opción: ");
        System.out.println("1 - Cargar un Usuario");
        System.out.println("2 - Cargar un Tipo de usuario");
        System.out.println("3 - Cargar un Tipo de documento");
        System.out.println("4 - Consultar por nombre de usuario");
        System.out.println("4 - Consultar listado de usuarios registrados");
        System.out.println("5 - Salir");
        System.out.print(  "Ingrese el número de opción: ");
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

        return input;
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

    private static TipoUsuario cargarTipoUsuario() throws IOException {
        TipoUsuario tipoUsuario = new TipoUsuario();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la descripción del tipo de usuario: ");
        String descripcion = entrada.readLine();

        tipoUsuario.setDescripcion(descripcion);

        return tipoUsuario;
    }
}
