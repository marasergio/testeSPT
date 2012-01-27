package br.com.spt.mara.form;

import org.apache.struts.action.ActionForm;

import br.com.spt.mara.vo.VendedorVO;

public class VendedorForm extends ActionForm{
	private VendedorVO vendedor = new VendedorVO();
	private String action;
	
	public VendedorForm(){
		super();
	}
	
	public VendedorVO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorVO vendedor) {
		this.vendedor = vendedor;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
