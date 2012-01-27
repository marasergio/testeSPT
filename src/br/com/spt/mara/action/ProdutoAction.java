package br.com.spt.mara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.ProdutoDao;
import br.com.spt.mara.form.ProdutoForm;
import br.com.spt.mara.vo.ProdutoVO;

public class ProdutoAction extends Action {
	public ProdutoAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		ProdutoForm prodForm = (ProdutoForm) form;
		ProdutoVO produto = prodForm.getProduto();
		ProdutoDao dao = new ProdutoDao();

		try {
			if (("Salvar").equalsIgnoreCase(prodForm.getAction())) {
				if (prodForm.getProduto().getId() == 0) {
					// gravar o novo contato
					produto.setId(null);
					produto = dao.salvar(produto);
					
					prodForm.getProduto().setId(produto.getId());
					
					System.out.println("Produto Salvo com Sucesso id: "+produto.getId());
				} else {
					// atualizar os dados do contato
					produto = dao.update(produto);
					System.out.println("Produto alterado id: "+produto.getId());
				} 
			}
			
			else if (("remover").equalsIgnoreCase(prodForm.getAction())) {
				new ProdutoDao().delete(prodForm.getProduto().getId());
				
				List<ProdutoVO> lista = dao.listar();
				request.setAttribute("produtos", lista);
			}
			else if(("editar").equalsIgnoreCase(prodForm.getAction())) {
				Long id = prodForm.getProduto().getId();
				
				produto = dao.getProduto(id);
				prodForm.setProduto(produto);
			}
			
			forward = mapping.findForward("sucesso");
			
		} catch (Exception ex) {
			forward = mapping.findForward("falha");
			System.out.println(ex);
		}
		return forward;
	}
	
}
