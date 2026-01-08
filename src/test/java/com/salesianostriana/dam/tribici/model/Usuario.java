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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int numTarjeta;
    private int pin;
    private double saldo;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    private List<Uso> usos = new ArrayList<>();
}
