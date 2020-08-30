package com.lojavirtualabmael.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtualabmael.domain.Categoria;
import com.lojavirtualabmael.dto.CategoriaDTO;
import com.lojavirtualabmael.service.CategoriaService;

//@CrossOrigin("${origem-permitida}")
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService servico;
	
	
		@RequestMapping(value="/{id}", method = RequestMethod.GET)
		public ResponseEntity<Categoria> find(@PathVariable Integer id) {
			Categoria cat = servico.find(id);
			return ResponseEntity.ok().body(cat);
			
		}
		
		@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO){
			
			Categoria obj = servico.fromDTO(objDTO);
			obj = servico.insert(obj);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
			
		}
		
		
		
		@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping(value="/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Categoria> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id) {
			
			Categoria obj = servico.fromDTO(objDTO); 
			obj.setId(id);
			obj = servico.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		
		
		@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id) {
			servico.delete(id);
			
			return ResponseEntity.noContent().build();
			
		}
		
		
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity <List<CategoriaDTO>> findAll() {
			List<Categoria> lista = servico.findAll();
			List<CategoriaDTO> listaDTO = lista.stream()
					.map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listaDTO);
			
		}
		
		

		@RequestMapping(value="pages", method = RequestMethod.GET)
		public ResponseEntity <Page<CategoriaDTO>> findAPage(

				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
				@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			
			
			Page<Categoria> lista = servico.findPage(page, linesPerPage, orderBy, direction);
			Page<CategoriaDTO> listaDTO = lista.map(obj -> new CategoriaDTO(obj));
			return ResponseEntity.ok().body(listaDTO);
			
		}
	
		
}

//Criado no inicio para fins de testes
//Categoria ca1 = new Categoria(1,"Informatica");
//Categoria ca2 = new Categoria(2,"Escritório");
//
//List<Categoria> list = new ArrayList<Categoria>();
//
//list.add(ca1);
//list.add(ca2);
//return list;