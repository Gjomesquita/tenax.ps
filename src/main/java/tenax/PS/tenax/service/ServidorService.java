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
	
	public Servidor getServidorFiltradoPeloNome(String nome) {
		return servidorRepository.findByNome(nome).get();
	}
	
	public List<Servidor> getServidoresFiltradosPelaDescricao(String descricao) {
		return servidorRepository.buscaServidoresPelaDescricao(descricao);
	}
	
	public Servidor getServidorPeloId(Long id) {
		Optional<Servidor> servidorDb = servidorRepository.findById(id);
		if (servidorDb.isEmpty())
			throw new EmptyResultDataAccessException("Servidor com id " + id + " não encontrado !", 1);
		
		else return servidorDb.get();
	}

	public Servidor criarServidor(Servidor servidor) {
		
		if (servidor.getId() != null)
			throw new ConstraintViolationException("Para criar um servidor, não indique o id !", null, null);

		Optional<Servidor> servidorDb = servidorRepository.findByNome(servidor.getNome()); 
		if (servidorDb.isPresent())
			throw new ConstraintViolationException("Servidor " + servidor.getNome() + " já existe !", null, null);
		
		servidor.setDataCriacao(LocalDateTime.now());
		return servidorRepository.save(servidor);
	}

	public Servidor alterarServidor(Servidor servidorAlterado) {
		
		if (servidorAlterado.getId() == null)
			throw new ConstraintViolationException("Para alterar servidor, é necessário indicar o id !", null, null);

		Optional<Servidor> servidorOpt = servidorRepository.findById(servidorAlterado.getId());
		if (servidorOpt.isEmpty())
			throw new EmptyResultDataAccessException("Servidor com id " + servidorAlterado.getId() + " não encontrado !", 1);
		
		Servidor servidorDb = servidorOpt.get();
		servidorDb.setNome(servidorAlterado.getNome());
		servidorDb.setDescricao(servidorAlterado.getDescricao());
		
		return servidorRepository.save(servidorDb);
	}

	public void excluirServidor(Long idServidor) {
		
		Optional<Servidor> servidorDb = servidorRepository.findById(idServidor);
		if (servidorDb.isEmpty())
			throw new EmptyResultDataAccessException("Servidor com id " + idServidor + " não encontrado !", 1);
		
		servidorRepository.delete(servidorDb.get());
	}

	public Long getQtdDeServidores() {
		
		return servidorRepository.count();
	}

	

	

	
	
	
}
