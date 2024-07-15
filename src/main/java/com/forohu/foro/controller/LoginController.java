package com.forohu.foro.controller;

import com.forohu.foro.domain.perfil.Perfil;
import com.forohu.foro.domain.usuario.DatosAutenticacionUsuario;
import com.forohu.foro.domain.usuario.Usuario;
import com.forohu.foro.domain.usuario.UsuarioRegistroDTO;
import com.forohu.foro.infra.security.DTOJWTtoken;
import com.forohu.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<?> authentication(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        System.out.println("entro al endpoints");
        //Le das tus credenciales y procede a generar el token
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
        //Verifica el token si esta bien. Lanza una excepsion si esta mal
        var userAuthenticated = authenticationManager.authenticate(authToken);
        System.out.println("Has sido autheticado");

        //si todo ok
        var JWTtoken = tokenService.generarToken((Usuario) userAuthenticated.getPrincipal());
        System.out.println("se genero tu token: "+JWTtoken);
        return  ResponseEntity.ok(new DTOJWTtoken(JWTtoken));
    }

}
