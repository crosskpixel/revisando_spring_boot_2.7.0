package com.application.web.service;

import com.application.web.dto.response.IdEmailUsuarioResponse;
import com.application.web.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(
        UsuarioRepository usuarioRepository
    ) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<IdEmailUsuarioResponse> listarTodosUsuarios() {
        return usuarioRepository.findAll2().stream()
                .map(usuario ->
                        IdEmailUsuarioResponse.builder()
                                .id(usuario.getId())
                                .email(usuario.getEmail())
                                .build()
                )
                .collect(Collectors.toList());
    }

}
