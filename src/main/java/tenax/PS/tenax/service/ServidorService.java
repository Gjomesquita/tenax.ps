package tenax.PS.tenax.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tenax.PS.tenax.model.Servidor;
import tenax.PS.tenax.repository.ServidorRepository;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepository servidorRepository;

	public List<Servidor> getTodosServidores() {
		return servidorRepository.findAll();
	}

	public Servidor criarServidor(Servidor servidor) {

		Optional<Servidor> servidorDb = servidorRepository.findByNome(servidor.getNome()); 
		if (servidorDb.isPresent())
			throw new ConstraintViolationException("Servidor " + servidor.getNome() + " já existe!", null, null);
		
		servidor.setDataCriacao(LocalDateTime.now());
		return servidorRepository.save(servidor);
		
	}

	public Servidor alterarServidor(Servidor servidorAlterado) {

		Optional<Servidor> servidorDb = servidorRepository.findById(servidorAlterado.getId());
		if (servidorDb.isEmpty())
			throw new EmptyResultDataAccessException("Servidor com id " + servidorAlterado.getId() + " não encontrado!", 1);
		
		return servidorRepository.save(servidorAlterado);
	}

	public void excluirServidor(Long idServidor) {
		
		Optional<Servidor> servidorDb = servidorRepository.findById(idServidor);
		if (servidorDb.isEmpty())
			throw new EmptyResultDataAccessException("Servidor com id " + idServidor + " não encontrado!", 1);
		
		servidorRepository.delete(servidorDb.get());
	}

	public Long getQtdDeServidores() {
		
		return servidorRepository.count();
	}
	
	
}
