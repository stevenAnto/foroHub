package com.forohu.foro.domain.topico;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.respuesta.Respuesta;
import com.forohu.foro.domain.usuario.Usuario;
import com.forohu.foro.domain.usuario.UsuarioRegistroDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TopicoRegistroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDate fechaCracion,
        @NotBlank
        String status,
        @NotBlank
        @NotNull
        Long autor_id,
        @NotBlank
        Long curso_id
) {
}
