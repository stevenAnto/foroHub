package com.forohu.foro.controller;

import com.forohu.foro.domain.curso.CursoRepository;
import com.forohu.foro.domain.topico.Topico;
import com.forohu.foro.domain.topico.TopicoRegistroDTO;
import com.forohu.foro.domain.topico.TopicoRespository;
import com.forohu.foro.domain.topico.TopicoRespuestaDTO;
import com.forohu.foro.domain.usuario.Usuario;
import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.usuario.UsuarioRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    UsuarioRespository usuarioRespository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    TopicoRespository topicoRespository;

    @PostMapping
    public ResponseEntity <?>createTopico(@RequestBody  TopicoRegistroDTO topicoRegistroDTO, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("topicoREgistroDTO "+topicoRegistroDTO);
        Topico topico = new Topico(topicoRegistroDTO);
        System.out.println("su id" +topicoRegistroDTO.autor_id());
        Optional<Usuario> autor =usuarioRespository.findById(topicoRegistroDTO.autor_id());
        Optional<Curso> curso = cursoRepository.findById(topicoRegistroDTO.curso_id());
        topico.setAutor(autor.get());
        topico.setCurso(curso.get());
        topicoRespository.save(topico);
        TopicoRespuestaDTO topicoRespuestaDTO = new TopicoRespuestaDTO(topico,curso.get(),autor.get());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return  new ResponseEntity<>(topicoRegistroDTO, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Topico>> getAllTopicos(){
        List<Topico> topicos = topicoRespository.findAll();
        return ResponseEntity.ok(topicos);
    }
}
