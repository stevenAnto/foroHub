package com.forohu.foro.controller;

import com.forohu.foro.domain.curso.CursoRepository;
import com.forohu.foro.domain.topico.Topico;
import com.forohu.foro.domain.topico.TopicoRegistroDTO;
import com.forohu.foro.domain.topico.TopicoRespository;
import com.forohu.foro.domain.topico.TopicoRespuestaDTO;
import com.forohu.foro.domain.usuario.Usuario;
import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.usuario.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return  new ResponseEntity<>(topico, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Topico>> getAllTopicos(){
        List<Topico> topicos = topicoRespository.findAll();
        return ResponseEntity.ok(topicos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneTopi(@PathVariable Long id){
        Optional<Topico> topico = topicoRespository.findById(id);
        if(topico.isPresent()){
            return  new ResponseEntity<>(topico.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("No encontrado",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarONe(@PathVariable Long id){
        Optional<Topico> topico = topicoRespository.findById(id);
        if(topico.isPresent()){
            topicoRespository.delete(topico.get());
            return  new ResponseEntity<>("Elimnado exitos",HttpStatus.OK);
        }
        return new ResponseEntity<>("No encontrado",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody TopicoRegistroDTO topicoRegistroDTO, @PathVariable Long id){
        Optional<Topico> topicoToUpdate = topicoRespository.findById(id);
        if(topicoToUpdate.isPresent()){
            Topico topicoUpdate = topicoToUpdate.get();
            Optional<Usuario> autorNuevo = usuarioRespository.findById(topicoRegistroDTO.autor_id());
            Optional<Curso> cursoNuevo = cursoRepository.findById(topicoRegistroDTO.curso_id());
            topicoUpdate.setAutor(autorNuevo.get());
            topicoUpdate.setCurso(cursoNuevo.get());
            topicoUpdate.setMensaje(topicoRegistroDTO.mensaje());
            topicoUpdate.setTitulo(topicoRegistroDTO.titulo());
            topicoUpdate.setFechaCracion(topicoRegistroDTO.fechaCracion());
            topicoUpdate.setStatus(topicoRegistroDTO.status());
            return  new ResponseEntity<>(topicoToUpdate.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("No encontrado",HttpStatus.NOT_FOUND);
    }

}
