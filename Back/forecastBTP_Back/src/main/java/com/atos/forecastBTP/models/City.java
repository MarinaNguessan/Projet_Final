package com.atos.forecastBTP.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="cities")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ libelle est obligatoire")
    @NotBlank(message = "Le champ libelle ne peut etre vide")
    private String libelle;
    private Date createdat;
    private Date updatedat;

    @OneToMany(targetEntity = Site.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "key_city",referencedColumnName = "id")
    //  @JsonIgnore() permet de ne pas retouner les données des enfants
    @JsonIgnore()
    private List<Site> sites;
    
}
