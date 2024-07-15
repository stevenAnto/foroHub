package com.forohu.foro.domain.topico;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.respuesta.Respuesta;
import com.forohu.foro.domain.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public record TopicoListadoDTO(
        String titulo,
        String mensaje,
        LocalDate fechaCracion,
        String status,
        Usuario autor,
        Curso curso,
        List<Respuesta> respuestas
) {
    public  TopicoListadoDTO(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(),topico.getFechaCracion(),topico.getStatus(),topico.getAutor(),topico.getCurso(),
                topico.getRespuestas());
    }
}
