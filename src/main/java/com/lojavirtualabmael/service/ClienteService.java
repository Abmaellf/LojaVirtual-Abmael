package com.lojavirtualabmael.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lojavirtualabmael.domain.Cidade;
import com.lojavirtualabmael.domain.Cliente;
import com.lojavirtualabmael.domain.Endereco;
import com.lojavirtualabmael.domain.enuns.TipoCliente;
import com.lojavirtualabmael.dto.ClienteDTO;
import com.lojavirtualabmael.dto.ClienteNewDTO;
import com.lojavirtualabmael.repository.ClienteRepository;
import com.lojavirtualabmael.repository.EnderecoRepository;
import com.lojavirtualabmael.service.exception.DataIntegrityException;
import com.lojavirtualabmael.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	
	public Cliente find(Integer id) {
		Optional<Cliente>  obj = repo.findById(id);
		if(obj == null) {
			
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	
	

	@Transactional
	public Cliente insert(Cliente obj) {

		obj.setId(null);
		
		obj = repo.save(obj);
		
		enderecoRepository.saveAll(obj.getEnderecos());
		
		return obj;
	}
	
	
	public Cliente update(Cliente obj) {
		
		Cliente newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	
	private void updateDate(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}



	public void delete(Integer id) {
		
		find(id);
		
		try {
			repo.deleteById(id);
			
		}catch (DataIntegrityViolationException e){
			
			throw new DataIntegrityException("Não é possivel excluir um Cliente com pedidos associados");
		}

	}


	public List<Cliente> findAll() {
		
		return repo.findAll();
	}
	
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	public Cliente fromDTO(ClienteDTO objDTO) {
			return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null, null);
		
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		
		Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), TipoCliente.toEnum(objDTO.getTipo()), pe.encode(objDTO.getSenha()));
		
		Cidade cid = new Cidade(objDTO.getCidadeId(), null, null);
		
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), cli, cid);
	
		cli.getEnderecos().add(end);
		
		cli.getTelefones().add(objDTO.getTelefone1());
		
		if(objDTO.getTelefone2() != null)
		{
			cli.getTelefones().add(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone2() != null)
		{
			cli.getTelefones().add(objDTO.getTelefone3());
		}
		return cli;
	}

}
