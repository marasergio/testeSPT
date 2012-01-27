package br.com.spt.mara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.form.VendedorForm;
import br.com.spt.mara.vo.VendedorVO;
import br.com.spt.mara.dao.VendedorDao;

public class VendedorAction extends Action{
	
	public VendedorAction(){
		super();
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		VendedorForm vendForm = (VendedorForm) form;
		VendedorVO vendedor = vendForm.getVendedor();
		VendedorDao dao = new VendedorDao();
		
		try {
			if (("salvar").equalsIgnoreCase(vendForm.getAction())) {
				if (vendForm.getVendedor().getId() == 0L) {
					vendedor.setId(null);
					dao.salvar(vendedor);
					vendForm.setVendedor(vendedor);
				} else {
					vendedor = dao.update(vendedor);
				}
			}
			else if (("remover").equalsIgnoreCase(vendForm.getAction())) {
				dao.delete(vendForm.getVendedor().getId());
				List<VendedorVO> lista = dao.listar();
				request.setAttribute("listVendedores", lista);				
			}
			else if (("editar").equalsIgnoreCase(vendForm.getAction())){
				Long id = vendForm.getVendedor().getId();
				vendedor = dao.getVendedor(id);
				vendForm.setVendedor(vendedor);
			}	
			forward = mapping.findForward("sucesso");
			
		} catch (Exception ex) {
			forward = mapping.findForward("falha");
			System.out.println(ex);
		}
		return forward;
	}
}
