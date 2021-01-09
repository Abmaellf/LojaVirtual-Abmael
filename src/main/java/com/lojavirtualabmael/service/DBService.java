package com.lojavirtualabmael.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojavirtualabmael.domain.Categoria;
import com.lojavirtualabmael.domain.Cidade;
import com.lojavirtualabmael.domain.Cliente;
import com.lojavirtualabmael.domain.Endereco;
import com.lojavirtualabmael.domain.Estado;
import com.lojavirtualabmael.domain.ItemPedido;
import com.lojavirtualabmael.domain.Pagamento;
import com.lojavirtualabmael.domain.PagamentoComBoleto;
import com.lojavirtualabmael.domain.PagamentoComCartao;
import com.lojavirtualabmael.domain.Pedido;
import com.lojavirtualabmael.domain.Produto;
import com.lojavirtualabmael.domain.enuns.EstadoPagamento;
import com.lojavirtualabmael.domain.enuns.Perfil;
import com.lojavirtualabmael.domain.enuns.TipoCliente;
import com.lojavirtualabmael.repository.CategoriaRepository;
import com.lojavirtualabmael.repository.CidadeRepository;
import com.lojavirtualabmael.repository.ClienteRepository;
import com.lojavirtualabmael.repository.EnderecoRepository;
import com.lojavirtualabmael.repository.EstadoRepository;
import com.lojavirtualabmael.repository.ItemPedidoRepository;
import com.lojavirtualabmael.repository.PagamentoRepository;
import com.lojavirtualabmael.repository.PedidoRepository;
import com.lojavirtualabmael.repository.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instanteateTestDatabase() throws ParseException {
	
			Categoria cat1 = new Categoria(null, "Informatica");
			Categoria cat2 = new Categoria(null,"Escritorio");
			Categoria cat3 = new Categoria(null,"Cama Mesa e Banho");
			Categoria cat4 = new Categoria(null,"Eletronico");
			Categoria cat5 = new Categoria(null,"Jardinagem");
			Categoria cat6 = new Categoria(null,"Decoração");
			Categoria cat7 = new Categoria(null,"Perfumaria");
			
			Produto p1 = new Produto(null, "Computador", 2000.00);
			Produto p2 = new Produto(null, "Impressora", 80.00);
			Produto p3 = new Produto(null, "Mouse", 30.00);
			Produto p4 = new Produto(null, "Mesa de Escritorio", 200.00);
			Produto p5 = new Produto(null, "Toalha", 80.00);
			Produto p6 = new Produto(null, "Colcha", 30.00);
			Produto p7 = new Produto(null, "TV True Color", 200.00);
			Produto p8 = new Produto(null, "Roçadeira", 80.00);
			Produto p9 = new Produto(null, "Abajour", 30.00);
			Produto p10 = new Produto(null, "Pendente", 30.00);
			Produto p11 = new Produto(null, "Shampoo", 30.00);
			Produto p12 = new Produto(null, "Produto 12", 10.00);
			Produto p13 = new Produto(null, "Produto 13", 10.00);
			Produto p14 = new Produto(null, "Produto 14", 10.00);
			Produto p15 = new Produto(null, "Produto 15", 10.00);
			Produto p16 = new Produto(null, "Produto 16", 10.00);
			Produto p17 = new Produto(null, "Produto 17", 10.00);

			Produto p18 = new Produto(null, "Produto 18", 10.00);
			Produto p19 = new Produto(null, "Produto 19", 10.00);
			Produto p20 = new Produto(null, "Produto 20", 10.00);
			Produto p21 = new Produto(null, "Produto 21", 10.00);
			Produto p22 = new Produto(null, "Produto 22", 10.00);
			Produto p23 = new Produto(null, "Produto 23", 10.00);
			Produto p24 = new Produto(null, "Produto 24", 10.00);
			Produto p25 = new Produto(null, "Produto 25", 10.00);
			Produto p26 = new Produto(null, "Produto 26", 10.00);
			Produto p27 = new Produto(null, "Produto 27", 10.00);
			Produto p28 = new Produto(null, "Produto 28", 10.00);
			Produto p29 = new Produto(null, "Produto 29", 10.00);
			Produto p30 = new Produto(null, "Produto 30", 10.00);
			Produto p31 = new Produto(null, "Produto 31", 10.00);
			Produto p32 = new Produto(null, "Produto 32", 10.00);
			Produto p33 = new Produto(null, "Produto 33", 10.00);
			Produto p34 = new Produto(null, "Produto 34", 10.00);
			Produto p35 = new Produto(null, "Produto 35", 10.00);
			Produto p36 = new Produto(null, "Produto 36", 10.00);
			Produto p37 = new Produto(null, "Produto 37", 10.00);
			Produto p38 = new Produto(null, "Produto 38", 10.00);
			Produto p39 = new Produto(null, "Produto 39", 10.00);
			Produto p40 = new Produto(null, "Produto 40", 10.00);
			Produto p41 = new Produto(null, "Produto 41", 10.00);
			Produto p42 = new Produto(null, "Produto 42", 10.00);
			Produto p43 = new Produto(null, "Produto 43", 10.00);
			Produto p44 = new Produto(null, "Produto 44", 10.00);
			Produto p45 = new Produto(null, "Produto 45", 10.00);
			Produto p46 = new Produto(null, "Produto 46", 10.00);
			Produto p47 = new Produto(null, "Produto 47", 10.00);
			Produto p48 = new Produto(null, "Produto 48", 10.00);
			Produto p49 = new Produto(null, "Produto 49", 10.00);
			Produto p50 = new Produto(null, "Produto 50", 10.00);

			cat1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
					p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
					p48, p49, p50));
			
			p12.getCategorias().addAll(Arrays.asList(cat1));
			p13.getCategorias().addAll(Arrays.asList(cat1));
			p14.getCategorias().addAll(Arrays.asList(cat1));
			p15.getCategorias().addAll(Arrays.asList(cat1));
			p16.getCategorias().addAll(Arrays.asList(cat1));
			p17.getCategorias().addAll(Arrays.asList(cat1));
			p18.getCategorias().addAll(Arrays.asList(cat1));
			p19.getCategorias().addAll(Arrays.asList(cat1));
			p20.getCategorias().addAll(Arrays.asList(cat1));
			p21.getCategorias().addAll(Arrays.asList(cat1));
			p22.getCategorias().addAll(Arrays.asList(cat1));
			p23.getCategorias().addAll(Arrays.asList(cat1));
			p24.getCategorias().addAll(Arrays.asList(cat1));

			p25.getCategorias().addAll(Arrays.asList(cat1));
			p26.getCategorias().addAll(Arrays.asList(cat1));
			p27.getCategorias().addAll(Arrays.asList(cat1));
			p28.getCategorias().addAll(Arrays.asList(cat1));
			p29.getCategorias().addAll(Arrays.asList(cat1));
			p30.getCategorias().addAll(Arrays.asList(cat1));
			p31.getCategorias().addAll(Arrays.asList(cat1));
			p32.getCategorias().addAll(Arrays.asList(cat1));
			p33.getCategorias().addAll(Arrays.asList(cat1));
			p34.getCategorias().addAll(Arrays.asList(cat1));
			p35.getCategorias().addAll(Arrays.asList(cat1));
			p36.getCategorias().addAll(Arrays.asList(cat1));
			p37.getCategorias().addAll(Arrays.asList(cat1));
			p38.getCategorias().addAll(Arrays.asList(cat1));
			p39.getCategorias().addAll(Arrays.asList(cat1));
			p40.getCategorias().addAll(Arrays.asList(cat1));
			p41.getCategorias().addAll(Arrays.asList(cat1));
			p42.getCategorias().addAll(Arrays.asList(cat1));
			p43.getCategorias().addAll(Arrays.asList(cat1));
			p44.getCategorias().addAll(Arrays.asList(cat1));
			p45.getCategorias().addAll(Arrays.asList(cat1));
			p46.getCategorias().addAll(Arrays.asList(cat1));
			p47.getCategorias().addAll(Arrays.asList(cat1));
			p48.getCategorias().addAll(Arrays.asList(cat1));
			p49.getCategorias().addAll(Arrays.asList(cat1));
			p50.getCategorias().addAll(Arrays.asList(cat1));

			
			cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
			cat2.getProdutos().addAll(Arrays.asList(p2,p4));
			cat3.getProdutos( ).addAll(Arrays.asList( p5, p6) );
			cat4.getProdutos( ).addAll(Arrays.asList( p1, p2, p3, p7) );
			cat5.getProdutos( ).addAll(Arrays.asList( p8) );
			cat6.getProdutos( ).addAll(Arrays.asList( p9, p10) );
			cat7.getProdutos( ).addAll(Arrays.asList( p11) );
		
			
			p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
			p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
			p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
			p4.getCategorias( ).addAll(Arrays.asList(cat2));
			p5.getCategorias( ).addAll(Arrays.asList(cat3));
			p6.getCategorias( ).addAll(Arrays.asList(cat3));
			p7.getCategorias( ).addAll(Arrays.asList(cat4));
			p8.getCategorias( ).addAll(Arrays.asList(cat5));
			p9.getCategorias( ).addAll(Arrays.asList(cat6));
		
			
			Estado est1 = new Estado(null, "Minas Gerais");
			Estado est2 = new Estado(null, "São Paulo");
			
			Cidade c1 = new Cidade(null, "Uberlancia", est1);
			Cidade c2 = new Cidade(null, "São Paulo", est2);
			Cidade c3 = new Cidade(null, "Campinas", est2);
			
			est1.getCidades().addAll(Arrays.asList(c1));		
			est2.getCidades().addAll(Arrays.asList(c2, c3));		
			
			
			categoriarepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
			produtorepository.saveAll(Arrays.asList(p1,p2,p3, p4, p5, p6, p7, p8, p9, p10, p11));
			
			produtorepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
					p26, p27, p28, p29, p30, p31, p32, p33,  p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
					p48, p49, p50));

			estadoRepository.saveAll(Arrays.asList(est1, est2));
			cidadeRepository.saveAll(Arrays.asList(c1,c2, c3));
			
			Cliente cli1 = new Cliente(null, "Abmael", "abmael_ninha@hotmail.com", "01203855389", TipoCliente.PESSOAFISICA, pe.encode("123"));
			
			cli1.getTelefones().addAll(Arrays.asList("99887755", "88675432"));
			
			
			Cliente cli2 = new Cliente(null, "JoaoPedro", "abmael_ninha20@hotmail.com", "05166589050", TipoCliente.PESSOAFISICA, pe.encode("123"));
			
			cli2.getTelefones().addAll(Arrays.asList("99587755", "88605432"));
			cli2.addPerfil(Perfil.ADMIN);
			
			
			
			Endereco e1 = new Endereco(null, "Rua das Flores", "23", "Apt 001", "Jardim Maringá", "7812000", cli1, c1);
			
			Endereco e2 = new Endereco(null, "Av Leonnidas", "234", "Lote 1", "Rio dagua", "7845699", cli1, c2);
			
			Endereco e3 = new Endereco(null, "Av Juliao de Brito", "233", null, "Parque do Lago", "7845699", cli2, c2);
			
			
			cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
			
			cli2.getEnderecos().addAll(Arrays.asList(e3));
			
			
			clienteRepository.saveAll(Arrays.asList(cli1, cli2));
			
			enderecoRepository.saveAll(Arrays.asList(e1,e2, e3));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH:mm");
			
			
			Pedido ped1 = new Pedido(null, sdf.parse("15-05-2020 12:00"), cli1, e1);
			Pedido ped2 = new Pedido(null, sdf.parse("10-05-2020 12:00"), cli1, e2);
			
			Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
			ped1.setPagamento(pgto1);
			
			Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("14-05-2020 00:00"), null);
			ped2.setPagamento(pgto2);
			
			cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
			
			pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
			pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
			
			ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
			ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
			ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
			
			ped1.getItens().addAll(Arrays.asList(ip1,ip2));
			ped2.getItens().addAll(Arrays.asList(ip3));
			
			p1.getItens().addAll(Arrays.asList(ip1));
			p2.getItens().addAll(Arrays.asList(ip3));
			p3.getItens().addAll(Arrays.asList(ip2));
			
			itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	
		}
	}
