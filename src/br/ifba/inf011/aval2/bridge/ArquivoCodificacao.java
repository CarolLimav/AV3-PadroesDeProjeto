package br.ifba.inf011.aval2.bridge;

//ABSTRAÇÃO EM BRIDGE
public interface ArquivoCodificacao {
	String codificar(String conteudo);
    String decodificar(String conteudo);
}
