package br.com.spt.mara.form;

import org.apache.struts.action.ActionForm;

import br.com.spt.mara.vo.ProdutoVO;

public class ProdutoForm extends ActionForm {
	private ProdutoVO produto = new ProdutoVO();
	private String action;

	public ProdutoForm() {
		super();
	}

	public ProdutoVO getProduto() {
		return this.produto;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
