package servicios;

import model.Persona;
import repository.PersonaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonaService {

    /**
     * Permite ingresar los datos de una nueva persona por teclado
     * @return Persona - devuelve la persona guardada
     * @throws IOException
     */
    public Long cargarPersona() throws IOException {
        String nombre;
        String apellido;
        Long tipoDni;
        String nroDocumento;
        Persona persona = new Persona();
        DocumentoService  documentoService= new DocumentoService();
        boolean existeTipoDocumento = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre: ");
        nombre = entrada.readLine();
        System.out.print("Apellido: ");
        apellido = entrada.readLine();

        do {
            System.out.print("Id de tipo de documento (0 para cancelar): ");
            tipoDni = Long.valueOf(entrada.readLine());
            existeTipoDocumento = documentoService.existeTipoDocumento(tipoDni);
            System.out.println("dentro del do de cargar persona. Existetipodocumento: " + existeTipoDocumento); //-<<<<<<<<<<<<<<<<<
        }while(!existeTipoDocumento && tipoDni != 0);

        System.out.print("Nro de documento: ");
        nroDocumento = entrada.readLine();

        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTipoDni(tipoDni);
        persona.setNroDocumento(nroDocumento);

        Long idPersona = registrarPersona(persona);
        return idPersona;
    }

    /**
     * Permite el registro de una nueva persona en la base de datos
     * @param persona
     */
    private Long registrarPersona(Persona persona){
        PersonaRepository personaRepo = new PersonaRepository();
        personaRepo.guardarPersona(persona);

        return personaRepo.buscarIdPersona(persona);
    }
}
