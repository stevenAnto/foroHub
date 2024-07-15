package com.forohu.foro.controller;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.curso.CursoRegistroDTO;
import com.forohu.foro.domain.curso.CursoRepository;
import com.forohu.foro.domain.perfil.Perfil;
import com.forohu.foro.domain.perfil.PerfilRegistroDTO;
import com.forohu.foro.domain.perfil.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
    @Autowired
    PerfilRepository perfilRepository;
    @PostMapping
    public ResponseEntity<?> crearPerfil(@RequestBody @Valid PerfilRegistroDTO perfilRegistroDTO){
        Perfil perfil = new Perfil(perfilRegistroDTO);
        perfilRepository.save(perfil);
        return  new ResponseEntity<>(perfil, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCursos(){
        return  new ResponseEntity<>(perfilRepository.findAll(),HttpStatus.OK);
    }
}
