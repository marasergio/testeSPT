package br.com.spt.mara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.VendedorDao;
import br.com.spt.mara.form.VendedorForm;
import br.com.spt.mara.vo.VendedorVO;

public class ListVendedorAction extends Action {
	public ListVendedorAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		List<VendedorVO> lista = new VendedorDao().listar();
		request.setAttribute("listVendedores", lista);
		
		return mapping.findForward("sucesso");

	}

}
