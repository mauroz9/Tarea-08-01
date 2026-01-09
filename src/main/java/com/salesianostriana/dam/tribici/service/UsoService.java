package com.salesianostriana.dam.tribici.service;

import com.salesianostriana.dam.tribici.model.Bicicleta;
import com.salesianostriana.dam.tribici.model.Estacion;
import com.salesianostriana.dam.tribici.model.Uso;
import com.salesianostriana.dam.tribici.model.Usuario;
import com.salesianostriana.dam.tribici.repository.BicicletaRepository;
import com.salesianostriana.dam.tribici.repository.EstacionRepository;
import com.salesianostriana.dam.tribici.repository.UsoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsoService {

    private static double UMBRAL_SALDO_MINIMO

    private final UsoRepository usoRepository;
    private final UsuarioService usuarioService;
    private final EstacionRepository estacionRepository;
    private final BicicletaRepository bicicletaRepository;

    public List<Uso> getAll(){
        return usoRepository.findAll();
    }

    public Uso getById(Long id){
        return usoRepository.findById(id).orElseThrow(() -> new RuntimeException("Uso no encontrado"));
    }

    //Usuario
    //Estación
    //Bicicleta
    public Uso inicializarUso(String numTarjeta, String pin, Long idEstacion, Long idBicicleta) throws BadRequestException {
        Usuario usuario = usuarioService.autenticacion(numTarjeta, pin).orElseThrow(() -> new BadRequestException("La tarjeta o pin no son válidas"));

        if(usuario.getSaldo() < UMBRAL_SALDO_MINIMO) {
            throw new BadRequestException("Saldo insuficiente");
        }

        Estacion inicio = estacionRepository.findById(idEstacion).orElseThrow(() -> new RuntimeException("No se ha encontrado la estación"));
        Bicicleta bicicleta = bicicletaRepository.findById(idBicicleta).orElseThrow(() -> new RuntimeException("No se ha encontrado la estación"));

        Uso uso = Uso.builder()
                .bicicleta(bicicleta)
                .fechaInicio(LocalDateTime.now())
                .estacion(inicio)
                .build();
    }



}
