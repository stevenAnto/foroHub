package com.forohu.foro.domain.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forohu.foro.domain.respuesta.Respuesta;
import com.forohu.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;
import com.forohu.foro.domain.perfil.Perfil;

import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasenia;
    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    List<Topico> topicos;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    List<Respuesta> respuestas;
    @ManyToOne
    Perfil perfil;

    public Usuario(UsuarioRegistroDTO usuarioRegistroDTO){
        this.nombre=usuarioRegistroDTO.nombre();
        this.correoElectronico=usuarioRegistroDTO.correoElectronico();
        this.contrasenia=usuarioRegistroDTO.contrasenia();
    }

}
