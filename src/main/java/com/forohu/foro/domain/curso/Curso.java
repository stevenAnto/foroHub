package com.forohu.foro.domain.curso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forohu.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCurso;
    private String categoria;
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    List<Topico> topicoList;
    public Curso() {
    }
   public Curso(CursoRegistroDTO cursoRegistroDTO) {
        this.nombreCurso=cursoRegistroDTO.nombreCurso();
        this.categoria=cursoRegistroDTO.categoria();
   }

}
