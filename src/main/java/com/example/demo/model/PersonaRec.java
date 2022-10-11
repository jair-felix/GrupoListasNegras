package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="t_persona")

public class PersonaRec implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="dni")
    @NonNull
    private String dni;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    // @Transient
    // @Value("#{apellidopat}+' '+#{apellidomat}")
    // private String apellidos;
    private String direccion;
    private String genero;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fechacumpleanos;
    private String estadocivil;

}
