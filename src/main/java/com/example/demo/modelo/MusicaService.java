package com.example.demo.modelo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MusicaService {

	@Autowired
	private MusicaRepository repo;
	
	@Autowired
	private RestTemplate template;
	
	@Value("${myrest.url}")
	private String restUrl;
	
	@Transactional
	public void salvar(Musica musica) {
		repo.save(musica);
	}

	public Iterable<Musica> listar() {
		
		String retorno = template.getForObject(restUrl, String.class);
		
		Iterable<Musica> findAll = repo.findAll();
		for (Musica musica : findAll) {
			musica.setGrauInstrucao(retorno);
		}
		
		return findAll;
	}

	public MusicaRepository getRepo() {
		return repo;
	}

	public void setRepo(MusicaRepository repo) {
		this.repo = repo;
	}

	
}
