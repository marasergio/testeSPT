package br.com.spt.mara.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.spt.mara.vo.VendedorVO;

public class VendedorDao extends Dao{
	public VendedorVO salvar(VendedorVO vendedor){
		EntityManager em = getEntityManager();
		em.persist(vendedor);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		closeFactory();		
		return vendedor;
	}
	
	public List<VendedorVO> listar(){
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT v FROM VendedorVO v ORDER BY v.nome ASC");
		return query.getResultList();
	}
	
	public VendedorVO update(VendedorVO vendedor){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(vendedor);
		em.getTransaction().commit();
		em.close();
		closeFactory();
		return vendedor;
	}
	
	public void delete (Long id){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(VendedorVO.class, id));
		em.getTransaction().commit();
		em.close();
		closeFactory();
	}
	
	public VendedorVO getVendedor(Long id){
		EntityManager em = getEntityManager();
		return em.find(VendedorVO.class, id);
	}
	
}
