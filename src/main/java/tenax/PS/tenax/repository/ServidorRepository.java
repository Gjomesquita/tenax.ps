package tenax.PS.tenax.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tenax.PS.tenax.model.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long>{
	
	public Optional<Servidor> findByNome(String nome);
}
