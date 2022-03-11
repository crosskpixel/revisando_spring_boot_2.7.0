package com.application.web;

import com.application.web.model.Acesso;
import com.application.web.model.Usuario;
import com.application.web.repository.AcessoRepository;
import com.application.web.repository.UsuarioRepository;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootApplication
public class WebApplication {

	Logger logger = LoggerFactory.getLogger(WebApplication.class);

	private final UsuarioRepository usuarioRepository;
	private final AcessoRepository acessoRepository;

	public WebApplication(
		UsuarioRepository usuarioRepository,
		AcessoRepository acessoRepository
	) {
		this.usuarioRepository = usuarioRepository;
		this.acessoRepository = acessoRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void startup() throws InterruptedException {

		Thread.sleep(2000);

		usuarioRepository.delete(usuarioRepository.getById(1L));

//		usuarioRepository.findAll().stream().forEach(usuario -> {
//
//			acessoRepository.save(
//					Acesso.builder()
//						.ip("127.0.0.1")
//						.accessToken(UUID.randomUUID().toString())
//						.refreshToken(UUID.randomUUID().toString())
//						.usuario(usuario)
//						.build()
//			);
//
//
//
//		});
	}

}
