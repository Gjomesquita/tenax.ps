package tenax.PS.tenax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tenax.PS.tenax.model.Servidor;
import tenax.PS.tenax.service.ServidorService;

@RestController
@RequestMapping("/servidor")
public class ServidorController {

	@Autowired
	private ServidorService servidorService;
	
	@GetMapping()
	public List<Servidor> retornaTodosServidores() {
		return servidorService.getTodosServidores();
	}
	
	@PostMapping()
	public Servidor criaServidor(@RequestBody Servidor servidor) {
		return servidorService.criarServidor(servidor);
	}
	
	@PutMapping()
	public Servidor alteraServidor(@RequestBody Servidor servidor) {
		return servidorService.alterarServidor(servidor);
	}
	
	@DeleteMapping("/{idServidor}")
	public void excluiServidor(@PathVariable Long idServidor) {
		servidorService.excluirServidor(idServidor);
	}
	
	@GetMapping("/contagem")
	public Long retornaContagemDeServidores() {
		return servidorService.getQtdDeServidores();
	}
	
	
}
