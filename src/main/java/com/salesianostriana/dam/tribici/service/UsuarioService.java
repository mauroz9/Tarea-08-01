package com.salesianostriana.dam.tribici.service;

import com.salesianostriana.dam.tribici.model.Usuario;
import com.salesianostriana.dam.tribici.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Optional<Usuario> autenticacion(String numerTarjeta, String pin){
        return usuarioRepository.findByNumTarjetaAndPin(numerTarjeta, pin);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario modify(Usuario usuario, Long id){
        Usuario oldUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        oldUsuario.setUsos(usuario.getUsos());
        oldUsuario.setNombre(usuario.getNombre());
        oldUsuario.setPin(usuario.getPin());
        oldUsuario.setSaldo(usuario.getSaldo());
        oldUsuario.setNumTarjeta(usuario.getNumTarjeta());

        return usuarioRepository.save(oldUsuario);
    }

    public void remove(Long id){
        Usuario usuario = getById(id);

        usuarioRepository.delete(usuario);
    }

}
