package com.example.demo.integration.reniec.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
// import java.util.Date;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReniecUsuario {
    @JsonProperty("t_persona")
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
