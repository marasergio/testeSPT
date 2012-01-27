package br.com.spt.mara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.ProdutoDao;
import br.com.spt.mara.dao.VendedorDao;
import br.com.spt.mara.vo.ItemVO;
import br.com.spt.mara.vo.ProdutoVO;
import br.com.spt.mara.vo.VendedorVO;

public class PreparaOrcamentoAction extends Action{
	public PreparaOrcamentoAction(){
		super();
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		List<VendedorVO> listaVendedor = new VendedorDao().listar();
		session.setAttribute("vendedores", listaVendedor);
		
		List<ProdutoVO> listaProduto = new ProdutoDao().listar();
		session.setAttribute("produtos", listaProduto);
		
		
		session.setAttribute("itens", new ArrayList<ItemVO>());
		
		return mapping.findForward("sucesso");

	}
}
