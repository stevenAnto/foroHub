package com.forohu.foro.domain.usuario;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.perfil.Perfil;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioRegistroDTO(
        @NotBlank  String nombre, String correoElectronico, @NotBlank String contrasenia, Long perfil_id
) {
}
