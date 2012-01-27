package br.com.spt.mara.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="tb_vendedor")
public class VendedorVO implements Serializable {

	private static final long serialVersionUID = 1161841561180305651L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vend_id")
	private Long id;
	@Column(name="vend_nome")
	private String nome;
	
	@OneToMany(mappedBy="vendedor")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<OrcamentoVO> orcamentos = new ArrayList<OrcamentoVO>();
	
	public VendedorVO() {	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<OrcamentoVO> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<OrcamentoVO> orcamentos) {
		this.orcamentos = orcamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendedorVO other = (VendedorVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
