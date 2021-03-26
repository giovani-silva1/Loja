package com.devgiovani.loja;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devgiovani.loja.domain.Categoria;
import com.devgiovani.loja.domain.Cidade;
import com.devgiovani.loja.domain.Cliente;
import com.devgiovani.loja.domain.Endereco;
import com.devgiovani.loja.domain.Estado;
import com.devgiovani.loja.domain.ItemPedido;
import com.devgiovani.loja.domain.Pagamento;
import com.devgiovani.loja.domain.PagamentoComBoleto;
import com.devgiovani.loja.domain.PagamentoComCartao;
import com.devgiovani.loja.domain.Pedido;
import com.devgiovani.loja.domain.Produto;
import com.devgiovani.loja.domain.enums.EstadoPagamento;
import com.devgiovani.loja.domain.enums.TipoCliente;
import com.devgiovani.loja.repository.CategoriaRepository;
import com.devgiovani.loja.repository.CidadeRepository;
import com.devgiovani.loja.repository.ClienteRepository;
import com.devgiovani.loja.repository.EnderecoRepository;
import com.devgiovani.loja.repository.EstadoRepository;
import com.devgiovani.loja.repository.ItemPedidoRepository;
import com.devgiovani.loja.repository.PagamentoRepository;
import com.devgiovani.loja.repository.PedidoRepository;
import com.devgiovani.loja.repository.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(1, "Computador", 2000.00);
		Produto p2 = new Produto(2, "Impressora", 800.00);
		Produto p3 = new Produto(3, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
        
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto203", "Jardim", "38220834", c1, cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2, cli1);
	
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf1.parse("30/09/2007 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf1.parse("10/10/2017 19:35"), cli1, e1);
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf1.parse("20/10/2017 00:00"),null);

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		cli1.setPedidos(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		
		

		
		
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		

		
		

	}

}
