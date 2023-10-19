package com.portifolio.workshop.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portifolio.workshop.entidades.enums.PedidoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instanteDoPedido;
	
	private Integer pedidoStatus;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant instanteDoPedido, PedidoStatus pedidoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.instanteDoPedido = instanteDoPedido;
		setPedidoStatus(pedidoStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstanteDoPedido() {
		return instanteDoPedido;
	}

	public void setInstanteDoPedido(Instant instanteDoPedido) {
		this.instanteDoPedido = instanteDoPedido;
	}
	
	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valorOf(pedidoStatus);
	}
	
	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCodigo();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<PedidoItem> getItems(){
		return items;
	}
	
	public Double getTotal() {
		double soma = 0;
		for(PedidoItem x : items) {
			soma += x.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}