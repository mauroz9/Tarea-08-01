package com.salesianostriana.dam.tribici.service;

import com.salesianostriana.dam.tribici.model.Bicicleta;
import com.salesianostriana.dam.tribici.repository.BicicletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private BicicletaRepository bicicletaRepository;

    public List<Bicicleta> getAll(){
        return bicicletaRepository.findAll();
    }

    public Bicicleta getById(Long id){
        return bicicletaRepository.findById(id).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public Bicicleta save(Bicicleta bicicleta){
        return bicicletaRepository.save(bicicleta);
    }

    public Bicicleta modify(Bicicleta bicicleta, Long id){
        Bicicleta oldBicicleta = bicicletaRepository.findById(id).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));

        oldBicicleta.setEstacion(bicicleta.getEstacion());
        oldBicicleta.setUsos(bicicleta.getUsos());
        oldBicicleta.setEstado(bicicleta.getEstado());
        oldBicicleta.setModelo(bicicleta.getModelo());
        oldBicicleta.setMarca((bicicleta.getMarca()));

        return bicicletaRepository.save(oldBicicleta);
    }

    public void remove(Long id){
        Bicicleta bicicleta = getById(id);
        bicicletaRepository.delete(bicicleta);
    }


}
