package br.ifba.inf011.aval2.state;

import br.ifba.inf011.aval2.model.Arquivo;

//CONCRETE STATE EM STATE
public class NormalState extends AbstractArquivoState {

    public NormalState(Arquivo arquivo) {
        super(arquivo);
    }

    @Override
    public ArquivoState bloquear() {
        return new BloqueadoState(arquivo);
    }

    @Override
    public ArquivoState definirSomenteLeitura() {
        return new SomenteLeituraState(arquivo);
    }

    @Override
    public ArquivoState excluir() {
        return new ExcluidoState(arquivo);
    }

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        arquivo.setConteudo(conteudo);
        return conteudo;
    }

    @Override
    public String ler() {
        return arquivo.getConteudo();
    }

    @Override
    public Long getTamanho() {
        return (long) arquivo.getConteudo().length();
    }

    @Override
    public String descricao() {
        return "Estado normal";
    }
}
