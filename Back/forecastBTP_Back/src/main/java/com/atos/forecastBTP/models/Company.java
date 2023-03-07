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
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ libelle est obligatoire")
    @NotBlank(message = "Le champ libeele ne peut etre vide")
    private String libelle;
    @NotNull(message = "Le champ register_number est obligatoire")
    @NotBlank(message = "Le champ register_number ne peut etre vide")
    private String register_number;

    private Date createdat;
    private Date updatedat;

  @OneToMany(targetEntity = Site.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn (name = "key_company",referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore()
  private List<Site> sites;

}
