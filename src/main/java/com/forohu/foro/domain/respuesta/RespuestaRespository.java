package com.forohu.foro.domain.respuesta;

import com.forohu.foro.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRespository extends JpaRepository<Respuesta,Long> {
}
