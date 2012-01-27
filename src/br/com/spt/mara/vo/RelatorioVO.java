package br.com.spt.mara.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.spt.mara.dao.VendedorDao;

public class RelatorioVO {
	private VendedorVO vendedor;
	private int qtdProspeccao;
	private int qtdElaboracao;
	private int qtdAprovacao;
	private int qtdAprovado;
	
	public RelatorioVO(){
	}

	public VendedorVO getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorVO vendedor) {
		this.vendedor = vendedor;
		calcularQuantidades();
	}

	public int getQtdProspeccao() {
		return qtdProspeccao;
	}

	public void setQtdProspeccao(int qtdProspeccao) {
		this.qtdProspeccao = qtdProspeccao;
	}

	public int getQtdElaboracao() {
		return qtdElaboracao;
	}

	public void setQtdElaboracao(int qtdElaboracao) {
		this.qtdElaboracao = qtdElaboracao;
	}

	public int getQtdAprovacao() {
		return qtdAprovacao;
	}

	public void setQtdAprovacao(int qtdAprovacao) {
		this.qtdAprovacao = qtdAprovacao;
	}

	public int getQtdAprovado() {
		return qtdAprovado;
	}

	public void setQtdAprovado(int qtdAprovado) {
		this.qtdAprovado = qtdAprovado;
	}
	
	public void calcularQuantidades(){
		for(OrcamentoVO orcamento : this.vendedor.getOrcamentos()){
			String situacao = orcamento.getSituacao();
			
			if(situacao.equalsIgnoreCase("prospecção")){
				this.qtdProspeccao += 1;
			}
			else if(situacao.equalsIgnoreCase("elaboração de proposta")){
				this.qtdElaboracao += 1;
			}
			else if(situacao.equalsIgnoreCase("aprovação")){
				this.qtdAprovacao += 1;
			}
			else if(situacao.equalsIgnoreCase("aprovado")){
				this.qtdAprovado += 1;
			}
		}
	}
}
