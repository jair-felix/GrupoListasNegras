package com.example.demo.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "t_cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer DNI;
    private String Nombre;
    private String Apellidos;
    private String CalifSBS;
    private BigDecimal precio;
}
