package com.clase09.ejercicio3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Data
@Entity
@Transactional(readOnly = true)
@Table(name ="autos")
public class Auto implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private int idAuto;
    private String nroPatente;
    private String nombreDuenio;
    private String marca;
    private int modelo;
    private int kilometraje;

}
