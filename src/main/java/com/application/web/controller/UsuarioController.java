package com.application.web.controller;

import com.application.web.dto.response.IdEmailUsuarioResponse;
import com.application.web.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(
        UsuarioService usuarioService
    ) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public List<IdEmailUsuarioResponse> teste() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/todos")
    public List<IdEmailUsuarioResponse> teste2() {
        return usuarioService.listarTodosUsuarios();
    }

}
