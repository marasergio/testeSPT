package br.com.spt.mara.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.spt.mara.dao.OrcamentoDao;
import br.com.spt.mara.dao.ProdutoDao;
import br.com.spt.mara.dao.VendedorDao;
import br.com.spt.mara.form.OrcamentoForm;
import br.com.spt.mara.vo.ItemVO;
import br.com.spt.mara.vo.OrcamentoVO;
import br.com.spt.mara.vo.ProdutoVO;
import br.com.spt.mara.vo.VendedorVO;

public class OrcamentoAction extends Action {

	public OrcamentoAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;
		HttpSession session = request.getSession();

		OrcamentoForm orcaForm = (OrcamentoForm) form;

		// recupera os itens do orcamento
		List<ItemVO> listaItens = (List<ItemVO>) session.getAttribute("itens");

		if (("adicionar").equalsIgnoreCase(orcaForm.getAction())) {

			String idProduto = orcaForm.getIdProduto();			
			String id = "";
			
			if (!idProduto.equals("0")) {
				for (int i = 0; i < idProduto.length(); i++) {
					char aux = idProduto.charAt(i);
					if (aux == '-') {
						break;
					}
					id += aux;
				}

				// busca os dados do produto selecionado no banco
				ProdutoVO produto = new ProdutoDao().getProduto(Long
						.parseLong(id));

				ItemVO itemSelecionado = orcaForm.getItem();
				itemSelecionado.setProduto(produto);

				// adiciona o item a lista
				listaItens.add(itemSelecionado);
			}
			// reset os dados do item
			orcaForm.setCheckDesconto("off");
			orcaForm.setIdProduto("0");
			orcaForm.setItem(new ItemVO());

			forward = mapping.findForward("sucesso");
		}

		if (("remover").equalsIgnoreCase(orcaForm.getAction())) {
			int index = Integer.parseInt(request.getParameter("removeItem"));
			listaItens.remove(index - 1);
			forward = mapping.findForward("sucesso");
		}

		if (("salvar").equalsIgnoreCase(orcaForm.getAction())) {
			OrcamentoVO orcamento = orcaForm.getOrcamento();

			VendedorVO vendedor = new VendedorDao().getVendedor(orcaForm
					.getIdVendedor());
			orcamento.setVendedor(vendedor);

			for (ItemVO i : listaItens) {
				i.setOrcamento(orcamento);
			}

			orcamento.setItens(listaItens);
			orcamento.setTotalOrcamento(calcularTotal(listaItens));

			SimpleDateFormat formatar = new SimpleDateFormat("dd/mm/yyyy");
			Date data = null;
			try {
				data = (Date) formatar.parse(orcaForm.getDataVenda());
			} catch (ParseException e) {
				System.out.println("ERRO ao converter a data " + e);
			}
			orcamento.setDataVenda(data);

			new OrcamentoDao().salvar(orcamento);

			// atualiza os dados do objeto
			listaItens = orcamento.getItens();
			orcaForm.setOrcamento(orcamento);
			forward = mapping.findForward("gravado");
		}

		session.setAttribute("itens", listaItens);

		// atualiza o valor total do orcamento;
		orcaForm.setTotalOrcamento(calcularTotal(listaItens));
		return forward;
	}

	public double calcularTotal(List<ItemVO> itens) {
		double total = 0;
		for (ItemVO item : itens) {
			total += item.getValor();
		}
		return total;
	}
}
