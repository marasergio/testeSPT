package br.com.spt.mara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.VendedorDao;
import br.com.spt.mara.vo.RelatorioVO;
import br.com.spt.mara.vo.VendedorVO;

public class RelatorioOrcamentoAction extends Action {

	public RelatorioOrcamentoAction() {
		super();
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		List<VendedorVO> vendedores = new VendedorDao().listar();

		List<RelatorioVO> relatorios = new ArrayList<RelatorioVO>();

		for (VendedorVO vendedor : vendedores) {
			RelatorioVO relatorio = new RelatorioVO();
			relatorio.setVendedor(vendedor);
			relatorios.add(relatorio);
		}
		
		request.setAttribute("relatorioOrcamentos", relatorios);
		return mapping.findForward("sucesso");
	}
}
