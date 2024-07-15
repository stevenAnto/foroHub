package com.forohu.foro.controller;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.curso.CursoRegistroDTO;
import com.forohu.foro.domain.curso.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoRepository cursoRepository;
    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody @Valid CursoRegistroDTO cursoRegistroDTO){
        Curso curso = new Curso(cursoRegistroDTO);
        cursoRepository.save(curso);
        return  new ResponseEntity<>(cursoRegistroDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCursos(){
        return  new ResponseEntity<>(cursoRepository.findAll(),HttpStatus.OK);
    }
}
