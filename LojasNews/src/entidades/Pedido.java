package entidades;

import java.util.ArrayList;
import java.util.List;

import principal.Cliente;

public class Pedido {

	private Long codigo;

	private Cliente cliente;
	private List<Item> itens = new ArrayList<>();
	private String dataCompra;

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido(Cliente cliente, Item... itens) {
		this.cliente = cliente;
		for (Item item : itens) {
			this.itens.add(item);
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorTotal() {
		double total = 0;
		for (Item item : itens) {
			total += item.getQuantidade() * item.getProduto().getPreco();
		}
		;return total;
	}

}
