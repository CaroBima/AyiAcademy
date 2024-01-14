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
        Long idPersona = 0L;
        String nroDocumento;
        Persona persona = new Persona();
        DocumentoService  documentoService= new DocumentoService();
        boolean existeTipoDocumento = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre: ");
        nombre = entrada.readLine();
        System.out.print("Apellido: ");
        apellido = entrada.readLine();

        //valida si el tipo de documento se encuentra registrado en la base de datos para evitar que crashee
        //si el dni no se encuentra vuelve a pedir el ingreso o 0 para cancelar. Si se elige 0 no solicita el ingreso
        //del numero de doc
        do {
            System.out.print("Id de tipo de documento (0 para cancelar): ");
            tipoDni = Long.valueOf(entrada.readLine());
            existeTipoDocumento = documentoService.existeTipoDocumento(tipoDni);
        }while(!existeTipoDocumento && tipoDni != 0);

        if(tipoDni !=0) { //si se ingreso un tipo de dni valido y no se ingreso 0 para cancelar
            System.out.print("Nro de documento: ");
            nroDocumento = entrada.readLine();
        }else{
            nroDocumento = null;
            persona.setIdPersona(0L); //seteo en 0 para que no quede en null
        }

        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTipoDni(tipoDni);
        persona.setNroDocumento(nroDocumento);

        if(tipoDni !=0){ // si se ingreso un tipo de dni correcto lo registra, sino setea en cero
            idPersona = registrarPersona(persona);
        }else{
            idPersona = 0L;
        }
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
