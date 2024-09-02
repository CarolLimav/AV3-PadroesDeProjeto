package br.ifba.inf011.aval2.bridge;
import br.ifba.inf011.aval2.model.Conversor2Bin;

//IMPLEMENTAÇÃO CONCRETA EM BRIDGE
public class CodificacaoBinaria implements ArquivoCodificacao {
	
    public String codificar(String conteudo) {
        return new Conversor2Bin().toBinary(conteudo);
    }

    public String decodificar(String conteudo) {
        return new Conversor2Bin().toASCII(conteudo);
    }
    
}
