package com.forohu.foro.domain.topico;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.respuesta.Respuesta;
import com.forohu.foro.domain.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TopicoRespuestaDTO(
        String titulo,
        String mensaje,
        LocalDate fechaCracion,
        String status,
        Usuario autor,
        Curso curso
) {
    public TopicoRespuestaDTO(Topico topico, Curso curso, Usuario usuario){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCracion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
    }

}
