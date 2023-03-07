package com.atos.forecastBTP.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Entity
@Table(name ="users")
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Le champ last_name est obligatoire")
    @NotBlank(message = "Le champ last_name ne peut etre vide")
    private String last_name;

    @NotNull(message = "Le champ first_name est obligatoire")
    @NotBlank(message = "Le champ first_name ne peut etre vide")
    private String first_name;

    @NotNull(message = "Le champ email est obligatoire")
    @NotBlank(message = "Le champ email ne peut etre vide")
    private String email;

    @NotNull(message = "Le champ phone est obligatoire")
    @NotBlank(message = "Le champ phone ne peut etre vide")
    private String phone;

    @NotNull(message = "Le champ role est obligatoire")
    @NotBlank(message = "Le champ role ne peut etre vide")
    private String role;

    
    private Date createdat;
    private Date updatedat;
    
}
