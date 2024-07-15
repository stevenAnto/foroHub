package com.forohu.foro.domain.respuesta;

import com.forohu.foro.domain.topico.Topico;
import com.forohu.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDate fechaCreacion;
    @ManyToOne
    //@JoinColumn(name="id", nullable=false)
    private Topico topico;
    @ManyToOne
    private Usuario usuario;

    public Respuesta() {
    }
}
