package br.com.fiap.semfome.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.semfome.model.Credencial;
import br.com.fiap.semfome.model.JwtToken;
import br.com.fiap.semfome.model.Usuario;
import br.com.fiap.semfome.repository.UsuarioRepository;

@Service
public class TokenJwtService {

    @Autowired
    UsuarioRepository repository;

    public JwtToken generateToken(Credencial credencial){
        Algorithm alg = Algorithm.HMAC256("secret");

        var token = JWT.create()
            .withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS))
            .withSubject(credencial.email())
            .withIssuer("SemFome")
            .sign(alg);

        return new JwtToken(token);
    }

    public Usuario validate(String token){
        Algorithm alg = Algorithm.HMAC256("secret");
        var email = JWT.require(alg)
            .withIssuer("SemFome")
            .build()
            .verify(token)
            .getSubject();

        return repository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Token Inválido"));
    }
    
}
