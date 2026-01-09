package com.salesianostriana.dam.tribici.service;

import com.salesianostriana.dam.tribici.model.Estacion;
import com.salesianostriana.dam.tribici.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionService {

    EstacionRepository estacionRepository;

    public List<Estacion> getAll(){
        return estacionRepository.findAll();
    }

    public Estacion getById(Long id){
        return estacionRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encotnrado la estación"));
    }

    public Estacion save(Estacion estacion){
        return estacionRepository.save(estacion);
    }

    public Estacion modify(Estacion estacion, Long id){
        Estacion oldEstacion = estacionRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encotnrado la estación"));

        oldEstacion.modify(estacion);

        oldEstacion.setBicicletas(estacion.getBicicletas());
        oldEstacion.setCapacidad(estacion.getCapacidad());
        oldEstacion.setCoordenada(estacion.getCoordenada());
        oldEstacion.setNumero(estacion.getNumero());
        oldEstacion.setNombre(estacion.getNombre());

        return estacionRepository.save(oldEstacion);
    }

    public void remove(Long id){
        Estacion estacion = getById(id);

        estacionRepository.delete(estacion);
    }

}
