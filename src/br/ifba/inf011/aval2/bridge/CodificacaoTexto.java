package br.ifba.inf011.aval2.bridge;

//IMPLEMENTAÇÃO CONCRETA EM BRIDGE
public class CodificacaoTexto implements ArquivoCodificacao {

	@Override
	public String codificar(String conteudo) {
		 return conteudo;
	}

	@Override
	public String decodificar(String conteudo) {
		 return conteudo;
	}

}
