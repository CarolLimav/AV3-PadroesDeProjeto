package br.ifba.inf011.aval2.state;

import br.ifba.inf011.aval2.model.Arquivo;

//CONCRETE STATE EM STATE 
public class BloqueadoState extends AbstractArquivoState {

    public BloqueadoState(Arquivo arquivo) {
        super(arquivo);
    }

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("Arquivo está bloqueado. Operação não permitida.");
    }

    @Override
    public String ler() throws IllegalAccessException {
        throw new IllegalAccessException("Arquivo está bloqueado. Não é possível ler o conteúdo.");
    }

    @Override
    public Long getTamanho() throws IllegalAccessException {
        return (long) arquivo.getConteudo().length();
    }

    @Override
    public ArquivoState liberar() {
        return new NormalState(arquivo);
    }

    @Override
    public String descricao() {
        return "Arquivo Bloqueado";
    }
}
