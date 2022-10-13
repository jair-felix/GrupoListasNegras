package com.example.demo.integration.reniec.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {

    @JsonProperty("display_name")
    private String dni;
    private String nombres;
    private String ApePat;
    private String ApeMat;
    private String direc;
    private String genero;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birthdate;
    private String estado;
}
