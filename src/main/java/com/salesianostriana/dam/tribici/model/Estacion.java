package com.salesianostriana.dam.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;
    private String nombre;
    private String coordenada;
    private Long capacidad;

    @OneToMany(mappedBy = "estacion", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Bicicleta> bicicletas = new ArrayList<>();

    @OneToMany(mappedBy = "estacion", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Uso> usos = new ArrayList<>();
}
