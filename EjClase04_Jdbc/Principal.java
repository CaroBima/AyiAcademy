import model.TipoUsuario;
import repository.DbConnection;
import repository.DocumentoRepository;
import repository.TipoUsuarioRepository;
import servicios.DocumentoService;
import servicios.TipoUsuarioService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int opcionSeleccionada = 999;

        do {
            String input = mostrarMenu(entrada);

            opcionSeleccionada = Integer.parseInt(input);

            switch (opcionSeleccionada) {
                case 0: //salir
                    System.out.println("Chau!");
                    break;

                case 1: //cargar un usuario
                    System.out.println("Aún en desarrollo");
                    break;

                case 2: //carga un nuevo tipo de usuario, ingresado por teclado
                    TipoUsuarioService nuevoTipoUsuarioService = new TipoUsuarioService();
                    nuevoTipoUsuarioService.registrarTipoUsuario(); //permite ingresar y guarda el nuevo usuario ingresado
                    break;

                case 3: //carga un tipo de documento nuevo
                    DocumentoService docuService = new DocumentoService();
                    docuService.registrarDocumento();
                    break;

                case 4: //consulta por nombre de usuario
                    System.out.println("Aún en desarrollo");
                    break;

                case 5: //lista de usuarios registrados
                    nuevoTipoUsuarioService = new TipoUsuarioService();
                    System.out.println("********************************************");
                    System.out.println("       Listado de usuarios registrados:     ");
                    System.out.println("********************************************");
                    nuevoTipoUsuarioService.listarTipoUsuario();
                    break;

                case 6: //lista todos los tipos de documentos registrados
                    docuService = new DocumentoService();
                    System.out.println("********************************************");
                    System.out.println("       Tipos de documento registrados:      ");
                    System.out.println("********************************************");
                    docuService.listarDocumentos();
                    break;
            }
        }while(opcionSeleccionada != 0);
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
        int cantOpciones = 6; //si se agregan nuevas opciones se modifica el numero maximo de opciones desde aca

        System.out.println(" ");
        System.out.println("********************************************");
        System.out.println("              Menú de opciones              ");
        System.out.println("********************************************");
        System.out.println("  1 - Cargar un Usuario");
        System.out.println("  2 - Cargar un Tipo de usuario");
        System.out.println("  3 - Cargar un Tipo de documento");
        System.out.println("  4 - Consultar por nombre de usuario");
        System.out.println("  5 - Listar tipos de usuarios registrados");
        System.out.println("  6 - Listar tipos de documentos registrados");
        System.out.println("  0 - Salir");
        System.out.print(  "Ingrese el número de opción: ");
        input = entrada.readLine();
        System.out.println(input);

        //Valído si no es número, si no es, pide que ingrese nuevamente el valor hasta que lo sea
        while(!esNumero(input)){
            System.out.println("El valor ingresado debe ser un valor numérico entre 0 y " + cantOpciones + ".");
            System.out.print("Ingrese nuevamente la opción: ");
            input = entrada.readLine();
        };

        //Valido que el valor numérico ingresado esté entre los posibles, si no está entre esos valores solicita que
        // se ingrese nuevamente hasta que cumpla la condición
        while(esNumero(input) && (Integer.parseInt(input)<0 || Integer.parseInt(input)>cantOpciones)){
            System.out.println("El número ingresado debe estar entre 0 y " + cantOpciones + ".");
            System.out.print("Ingrese nuevamente la opción: ");
            input = entrada.readLine();
        };

        return input;
    }

    /**
     * Metódo que verifica si el valor que recibe por parámentro es un número o no.
     * Devuelve true en caso de que lo sea y false si no es número.
     * @param input
     * @return boolean
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
