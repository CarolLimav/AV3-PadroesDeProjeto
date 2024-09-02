package br.ifba.inf011.aval2.state;

import br.ifba.inf011.aval2.model.Arquivo;

//CONCRETE STATE EM STATE 
public class SomenteLeituraState extends AbstractArquivoState {

    public SomenteLeituraState(Arquivo arquivo) {
        super(arquivo);
    }

    @Override
    public ArquivoState bloquear() {
        return new BloqueadoState(arquivo);
    }

    @Override
    public ArquivoState liberar() {
        return new NormalState(arquivo);
    }

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("Arquivo em estado de somente leitura. Operação não permitida.");
    }

    @Override
    public String ler() {
        return arquivo.getConteudo();
    }

    @Override
    public Long getTamanho() throws IllegalAccessException {
        return (long) arquivo.getConteudo().length();
    }

    @Override
    public String descricao() {
        return "Arquivo em estado de somente leitura";
    }
}
