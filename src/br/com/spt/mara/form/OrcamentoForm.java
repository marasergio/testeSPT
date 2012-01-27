package br.com.spt.mara.form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import br.com.spt.mara.vo.ItemVO;
import br.com.spt.mara.vo.OrcamentoVO;

public class OrcamentoForm extends ActionForm {
	private OrcamentoVO orcamento = new OrcamentoVO();
	private ItemVO item = new ItemVO();
	
	private Long idVendedor;
	private String idProduto;
	private String action;
	private String dataVenda;
	private String checkDesconto;
	private double totalOrcamento;

	public OrcamentoForm() {
		super();
	}
	
	public String getCheckDesconto() {
		return checkDesconto;
	}

	public void setCheckDesconto(String checkDesconto) {
		this.checkDesconto = checkDesconto;
	}
	
	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public OrcamentoVO getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(OrcamentoVO orcamento) {
		this.orcamento = orcamento;
	}

	public ItemVO getItem() {
		return item;
	}

	public void setItem(ItemVO item) {
		this.item = item;
	}

	public double getTotalOrcamento() {
		return totalOrcamento;
	}

	public void setTotalOrcamento(double totalOrcamento) {
		this.totalOrcamento = totalOrcamento;
	}
	
	
}
