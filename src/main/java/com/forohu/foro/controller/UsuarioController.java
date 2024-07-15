package com.forohu.foro.controller;

import com.forohu.foro.domain.perfil.Perfil;
import com.forohu.foro.domain.perfil.PerfilRegistroDTO;
import com.forohu.foro.domain.perfil.PerfilRepository;
import com.forohu.foro.domain.usuario.Usuario;
import com.forohu.foro.domain.usuario.UsuarioRegistroDTO;
import com.forohu.foro.domain.usuario.UsuarioRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    UsuarioRespository usuarioRespository;
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO){
        Usuario usuario = new Usuario(usuarioRegistroDTO);
        String encodedPasword =passwordEncoder.encode(usuarioRegistroDTO.contrasenia());
        Optional<Perfil> perfil = perfilRepository.findById(usuarioRegistroDTO.perfil_id());
        usuario.setPerfil(perfil.get());
        usuario.setContrasenia(encodedPasword);
        usuarioRespository.save(usuario);
        return  new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCursos(){
        return  new ResponseEntity<>(usuarioRespository.findAll(),HttpStatus.OK);
    }
}
