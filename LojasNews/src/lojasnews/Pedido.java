package lojasnews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private static Long contadorCodigo = 1l;
	private Long codigo;

	private List<Item> itens = new ArrayList<>();
	private Date dataCompra;

	public Pedido() {

	}

	public Pedido(Item... itens) {
		for (Item item : itens) {
			this.itens.add(item);
		}
		codigo = contadorCodigo;
		contadorCodigo += 1;
	}

	public Pedido(Date dataCompra, Item... itens) {
		this.dataCompra = dataCompra;
		codigo = contadorCodigo;
		contadorCodigo += 1;
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
