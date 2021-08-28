package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Long codigo;

	private List<Item> itens = new ArrayList<>();
	private Date dataCompra;

	public Pedido() {
	}

	public Pedido(Item... itens) {
		for (Item item : itens) {
			this.itens.add(item);
		}
	}

	public Pedido(Date dataCompra, Item... itens) {
		this.dataCompra = dataCompra;
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

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorTotal() {
		double total = 0;
		for (Item item : itens) {
			total += item.getQuantidade() * item.getProduto().getPreco();
		};
		return total;
	}
	
}
