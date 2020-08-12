package com.example.demo.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MusicaController {

	@Autowired
	public MusicaService service;
	
	@GetMapping(value = "/musicas")
	public ResponseEntity<Iterable<Musica>> lista() {
		
		return  new ResponseEntity<Iterable<Musica>>(service.listar(), HttpStatus.OK);
	}
	
	
}
