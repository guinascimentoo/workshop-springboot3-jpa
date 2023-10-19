package com.portifolio.workshop.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portifolio.workshop.entidades.Categoria;
import com.portifolio.workshop.entidades.Pedido;
import com.portifolio.workshop.entidades.PedidoItem;
import com.portifolio.workshop.entidades.Produto;
import com.portifolio.workshop.entidades.Usuario;
import com.portifolio.workshop.entidades.enums.PedidoStatus;
import com.portifolio.workshop.repositorios.CategoriaRepositorio;
import com.portifolio.workshop.repositorios.PedidoItemRepositorio;
import com.portifolio.workshop.repositorios.PedidoRepositorio;
import com.portifolio.workshop.repositorios.ProdutoRepositorio;
import com.portifolio.workshop.repositorios.UsuarioRepositorio;

@Configuration
@Profile("teste")
public class ConfiguracaoTeste implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private PedidoItemRepositorio pedidoItemRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-20T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-20T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3));
		
		PedidoItem pi1 = new PedidoItem(p1, pr1, 2, pr1.getPreco());
		PedidoItem pi2 = new PedidoItem(p1, pr3, 1, pr4.getPreco());
		PedidoItem pi3 = new PedidoItem(p2, pr3, 2, pr1.getPreco());
		PedidoItem pi4 = new PedidoItem(p3, pr5, 2, pr5.getPreco());
		
		pedidoItemRepositorio.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
	}
}