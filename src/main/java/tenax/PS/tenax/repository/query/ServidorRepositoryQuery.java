package tenax.PS.tenax.repository.query;

import java.util.List;

import tenax.PS.tenax.model.Servidor;

public interface ServidorRepositoryQuery {

	public List<Servidor> buscaServidoresPelaDescricao(String descricao);
}
