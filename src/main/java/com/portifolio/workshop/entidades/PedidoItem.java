package com.portifolio.workshop.entidades;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portifolio.workshop.entidades.pk.PedidoItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoItemPk id = new PedidoItemPk();
	private Integer quantidade;
	private Double preco;
	
	public PedidoItem() {
	}

	public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
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
		PedidoItem other = (PedidoItem) obj;
		return Objects.equals(id, other.id);
	}
}