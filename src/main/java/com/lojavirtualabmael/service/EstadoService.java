package com.lojavirtualabmael.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtualabmael.domain.Estado;
import com.lojavirtualabmael.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll() {
           		return repo.findAllByOrderByNome();
	}


}

