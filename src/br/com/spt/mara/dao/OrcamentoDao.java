package br.com.spt.mara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.spt.mara.vo.*;

public class OrcamentoDao extends Dao {
	public OrcamentoVO salvar(OrcamentoVO orcamento) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(orcamento);
		em.getTransaction().commit();
		em.close();
		closeFactory();
		return orcamento;
	}

	public OrcamentoVO getOrcamento(Long id) {
		EntityManager em = getEntityManager();
		return em.find(OrcamentoVO.class, id);
	}
	
	public List<OrcamentoVO> listar(){
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT o FROM OrcamentoVO o");
		return query.getResultList();
	}
	
}
