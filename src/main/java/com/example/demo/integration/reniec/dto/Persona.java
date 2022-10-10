package com.example.demo.integration.reniec.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {

    private String dni;
    private String nombres;
    private String ApePat;
    private String ApeMat;
    private String direc;
    private String genero;
    private Date birthdate;
    private String estado;
}
