package br.com.spt.mara.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.spt.mara.vo.ProdutoVO;

public class ProdutoDao extends Dao{
	public ProdutoVO salvar (ProdutoVO produto){
		EntityManager em = getEntityManager();
		em.persist(produto);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		closeFactory();		
		return produto;
	}
	
	public List<ProdutoVO> listar(){
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT p FROM ProdutoVO p ORDER BY p.nome ASC");
		return query.getResultList();
	}
	
	public ProdutoVO update(ProdutoVO produto){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
		closeFactory();
		return produto;
	}
	
	public void delete (Long id){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(ProdutoVO.class, id));
		em.getTransaction().commit();
		em.close();
		closeFactory();
	}
	
	public ProdutoVO getProduto(Long id){
		EntityManager em = getEntityManager();
		ProdutoVO produto = em.find(ProdutoVO.class, id);
		em.close();
		closeFactory();
		return produto;
	}
	
}
