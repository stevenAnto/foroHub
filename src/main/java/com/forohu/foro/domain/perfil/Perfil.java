package com.forohu.foro.domain.perfil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forohu.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePerfil;
    @JsonIgnore
    @OneToMany(mappedBy = "perfil")
    List<Usuario> usuarioList;

}
