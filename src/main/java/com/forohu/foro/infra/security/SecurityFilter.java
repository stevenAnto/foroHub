package com.forohu.foro.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.forohu.foro.domain.usuario.UsuarioRespository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UsuarioRespository usuarioRepository;

    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenCorrecto= "";
        System.out.println("tamanio del correcto "+tokenCorrecto.length());
        var authHeader = request.getHeader("Authorization");
        if(authHeader !=null ){
            var token = authHeader.replace("Bearer","").trim();
            /*System.out.println("comparacion");
            System.out.println(tokenCorrecto);
            System.out.println(token);
            System.out.println("Este debe ser el subjetc "+tokenService.getSubject(token));*/
            var subject = tokenService.getSubject(token);
            if(subject!=null){
                //Toekn valido
                //forzar inicio de sesion
                var usuario = usuarioRepository.findByNombre(subject);
                var authenticaction = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticaction);
            }
        }
        System.out.println("el header es nulo");
        filterChain.doFilter(request,response);
    }
}