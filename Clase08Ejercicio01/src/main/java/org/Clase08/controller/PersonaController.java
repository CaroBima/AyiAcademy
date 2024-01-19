package org.Clase08.controller;

import lombok.NoArgsConstructor;
import org.Clase08.model.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class PersonaController {

    Session session;
    SessionFactory sessionFactory;
    public void conexionBD(){
        try {
            sessionFactory =
                    new Configuration().configure("hibernate.cfg.xml").
                            addAnnotatedClass(Persona.class).buildSessionFactory();
            Session session = sessionFactory.openSession();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }

    public void guardarPersona(Persona persona){
        conexionBD();
        
        session.beginTransaction();
        session.save(persona);
        session.getTransaction().commit();
        session.close();
    }

    public void buscarPersona(Persona nuevaPersona){
        //ver como se consulta con hibernate
       Persona persona = session.get(Persona.class, nuevaPersona.getIdPersona());

    }
}
