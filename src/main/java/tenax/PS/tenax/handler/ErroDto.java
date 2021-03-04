package tenax.PS.tenax.handler;

public class ErroDto {

	private String tipo;
	private String erro;
	
	public ErroDto(String tipo, String erro) {
		this.tipo = tipo;
		this.erro = erro;
	}

	public String getTipo() {
		return tipo;
	}

	public String getErro() {
		return erro;
	}
}
