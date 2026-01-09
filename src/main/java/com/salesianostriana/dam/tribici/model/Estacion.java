package com.salesianostriana.dam.tribici.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estacion estacion = (Estacion) o;
        return getId() != null && Objects.equals(getId(), estacion.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
