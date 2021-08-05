package lojasnews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private Cliente c1 = new Cliente();
	private List<Item> itm = new ArrayList<>();
	private double valorTotal;
	private Long codigo;
	private Date dataCompra;

	public Pedido() {

	}

	public Pedido(Cliente c1, Long codigo, Date dataCompra) {
		this.c1 = c1;
		this.codigo = codigo;
		this.dataCompra = dataCompra;

	}

	public Cliente getC1() {
		return c1;
	}

	public void setC1(Cliente c1) {
		this.c1 = c1;
	}

	public List<Item> getItm() {
		return itm;
	}

	public void setItm(List<Item> itm) {
		this.itm = itm;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
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

}
