package tenax.PS.tenax.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tenax.PS.tenax.model.Servidor;
import tenax.PS.tenax.repository.query.ServidorRepositoryQuery;

public interface ServidorRepository extends JpaRepository<Servidor, Long>, ServidorRepositoryQuery {
	
	public Optional<Servidor> findByNome(String nome);
	
}
