package br.com.spt.mara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.OrcamentoDao;
import br.com.spt.mara.form.OrcamentoForm;
import br.com.spt.mara.vo.OrcamentoVO;

public class ListOrcamentosAction extends Action {
	public ListOrcamentosAction(){
		super();
	}
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response){
		
		ActionForward forward = null;
		
		if(("abrir").equalsIgnoreCase(request.getParameter("action"))){
			Long id = Long.parseLong(request.getParameter("id"));
			
			OrcamentoForm orcaForm = (OrcamentoForm) form;
			orcaForm.setOrcamento(new OrcamentoDao().getOrcamento(id));
			
			request.setAttribute("itens", orcaForm.getOrcamento().getItens());
			
			forward = mapping.findForward("ok");
		}else{
			List<OrcamentoVO> orcamentos = new OrcamentoDao().listar();		
			request.setAttribute("listOrcamentos", orcamentos);		
			forward = mapping.findForward("sucesso");
		}
		
		return forward;
	}
}
