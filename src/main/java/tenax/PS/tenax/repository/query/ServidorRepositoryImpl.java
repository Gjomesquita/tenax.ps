package tenax.PS.tenax.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tenax.PS.tenax.model.Servidor;
import tenax.PS.tenax.repository.query.ServidorRepositoryQuery;

public class ServidorRepositoryImpl implements ServidorRepositoryQuery {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Servidor> buscaServidoresPelaDescricao(String descricao) {
		TypedQuery<Servidor> query = em.createQuery("SELECT s FROM Servidor s WHERE s.descricao LIKE :descricao", Servidor.class);
		return query.setParameter("descricao", "%" + descricao + "%").getResultList(); 
		// % usado para buscar qualquer aparicao do input na descricao 
	}
	
	
}
