package br.ifba.inf011.aval2.state;

import br.ifba.inf011.aval2.model.Arquivo;

//CONCRETE STATE EM STATE 
public class ExcluidoState extends AbstractArquivoState {

    public ExcluidoState(Arquivo arquivo) {
        super(arquivo);
    }

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("Arquivo excluído. Operação não permitida.");
    }

    @Override
    public String ler() throws IllegalAccessException {
        throw new IllegalAccessException("Arquivo excluído. Não é possível ler o conteúdo.");
    }

    @Override
    public Long getTamanho() {
        return 0L;
    }

    @Override
    public ArquivoState restaurar() {
        return new NormalState(arquivo);
    }

    @Override
    public String descricao() {
        return "Arquivo Excluído";
    }
}
