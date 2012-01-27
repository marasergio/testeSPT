package br.com.spt.mara.vo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tb_item")
public class ItemVO implements Serializable{
	
	private static final long serialVersionUID = 595010848132105422L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Long id;
	@Column(name="item_desconto")
	private double desconto;
	@Column(name="item_valor")
	private double valor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_orca_id")
	private OrcamentoVO orcamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_prod_id")
	private ProdutoVO produto;
	
	public ItemVO(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public OrcamentoVO getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(OrcamentoVO orcamento) {
		this.orcamento = orcamento;
	}

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVO other = (ItemVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
