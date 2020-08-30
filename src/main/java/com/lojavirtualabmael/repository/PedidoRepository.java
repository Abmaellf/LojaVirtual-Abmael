package com.lojavirtualabmael.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lojavirtualabmael.domain.Cliente;
import com.lojavirtualabmael.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	
	@Transactional(readOnly= true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable PageRequest);

}
