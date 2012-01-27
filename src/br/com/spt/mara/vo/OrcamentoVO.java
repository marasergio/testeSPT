package br.com.spt.mara.vo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tb_orcamento")
public class OrcamentoVO implements Serializable {

	private static final long serialVersionUID = -1881806493732008560L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orca_id")
	private Long id;
	@Column(name = "orca_cliente")
	private String cliente;
	@Column(name = "orca_data")
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	@Column(name = "orca_situacao")
	private String situacao;	
	@Column(name="orca_total_orcamento")
	private double totalOrcamento;

	@ManyToOne
	@JoinColumn(name = "orca_vend_id")
	private VendedorVO vendedor;

	@OneToMany(mappedBy = "orcamento")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<ItemVO> itens = new ArrayList<ItemVO>();

	public OrcamentoVO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public VendedorVO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorVO vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItemVO> getItens() {
		return itens;
	}

	public void setItens(List<ItemVO> itens) {
		this.itens = itens;
	}

	public double getTotalOrcamento() {
		return this.totalOrcamento;
	}

	public void setTotalOrcamento(double totalOrcamento) {
		this.totalOrcamento = totalOrcamento;
	}	
}
