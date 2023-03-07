package com.atos.forecastBTP.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "risks")
@Getter
@Setter

public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ libelle est obligatoire")
    @NotBlank(message = "Le champ libeele ne peut etre vide")
    private String libelle;
    private String risk_level;

    private Date createdat;
    private Date updatedat;
    
}
