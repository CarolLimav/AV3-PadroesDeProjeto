package br.ifba.inf011.aval2.state;

//STATE EM STATE 
public interface ArquivoState {
	
	public String setConteudo(String conteudo) throws  IllegalAccessException;
	
	ArquivoState restaurar() throws IllegalAccessException;

	ArquivoState bloquear() throws IllegalAccessException;

	ArquivoState definirSomenteLeitura() throws IllegalAccessException;

	ArquivoState excluir() throws IllegalAccessException;
    
	ArquivoState liberar() throws IllegalAccessException;

    public Long getTamanho() throws IllegalAccessException;
    
    public String descricao() throws IllegalAccessException;
    
    String ler() throws IllegalAccessException;

}
