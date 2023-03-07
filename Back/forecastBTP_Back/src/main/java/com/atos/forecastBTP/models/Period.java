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
@Table(name = "periods")
@Getter
@Setter

public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date_debut;
    private Date date_fin;

    private Date createdat;
    private Date updatedat;
    
}
