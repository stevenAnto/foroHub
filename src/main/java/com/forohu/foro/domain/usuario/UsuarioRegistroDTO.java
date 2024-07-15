package com.forohu.foro.domain.usuario;

import com.forohu.foro.domain.curso.Curso;
import com.forohu.foro.domain.perfil.Perfil;

import java.util.List;

public record UsuarioRegistroDTO(
        String nombre, String correoElectronico, String contrasenia, List<Perfil> perfiles, Curso curso
) {
}
