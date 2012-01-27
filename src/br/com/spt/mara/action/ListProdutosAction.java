package br.com.spt.mara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.ProdutoDao;
import br.com.spt.mara.vo.ProdutoVO;

public class ListProdutosAction extends Action{
	public ListProdutosAction(){
		super();
	}
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response){
		
		List<ProdutoVO> lista = new ProdutoDao().listar();
		request.setAttribute("produtos", lista);
		
		return mapping.findForward("sucesso");
	}
}
