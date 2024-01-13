package servicios;

import model.Persona;
import repository.PersonaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonaService {

    public Persona cargarPersona() throws IOException {
        String nombre;
        String apellido;
        Long tipoDni;
        String nroDocumento;
        Persona persona = new Persona();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre: ");
        nombre = entrada.readLine();
        System.out.print("Apellido: ");
        apellido = entrada.readLine();
        System.out.print("Id de tipo de documento: ");
        tipoDni = Long.valueOf(entrada.readLine());
        System.out.print("Nro de documento: ");
        nroDocumento = entrada.readLine();

        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTipoDni(tipoDni);
        persona.setNroDocumento(nroDocumento);

        return persona;
    }

    private void registrarPersona(Persona persona){
        PersonaRepository personaRepo = new PersonaRepository();
        //personaRepo.
    }
}
