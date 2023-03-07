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
@Table(name = "sites")
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ name est obligatoire")
    @NotBlank(message = "Le champ name ne peut etre vide")
    private String name;
    @NotNull(message = "Le champ description est obligatoire")
    @NotBlank(message = "Le champ description ne peut etre vide")
    private String description;
    private Date createdat;
    private Date updatedat;

    @OneToMany(targetEntity = Risk.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "key_site", referencedColumnName = "id")
    // @JsonIgnore() permet de ne pas retouner les données des enfants
    @JsonIgnore()
    private List<Risk> risks;

    @OneToOne(targetEntity = Period.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "key_site", referencedColumnName = "id")
    // @JsonIgnore() permet de ne pas retouner les données des enfants
    @JsonIgnore()
    private List<Period> periods;

}
