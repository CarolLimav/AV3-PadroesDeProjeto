package br.ifba.inf011.aval2.state;

import br.ifba.inf011.aval2.model.Arquivo;

//ABSTRACT STATE EM STATE 
public abstract class AbstractArquivoState implements ArquivoState {
    protected Arquivo arquivo;

    public AbstractArquivoState(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("Operação não permitida no estado atual.");
    }

    @Override
    public ArquivoState restaurar() throws IllegalAccessException {
        return this;
    }

    @Override
    public ArquivoState bloquear() throws IllegalAccessException {
        return this;
    }

    @Override
    public ArquivoState definirSomenteLeitura() throws IllegalAccessException {
        return this;
    }

    @Override
    public ArquivoState excluir() throws IllegalAccessException {
        return this;
    }

    @Override
    public ArquivoState liberar() throws IllegalAccessException {
        return this;
    }

    @Override
    public Long getTamanho() throws IllegalAccessException {
        return (this.arquivo != null) ? this.arquivo.getTamanho() : 0L;
    }

    @Override
    public String descricao() throws IllegalAccessException {
        return "Estado desconhecido";
    }

    @Override
    public String ler() throws IllegalAccessException {
        throw new IllegalAccessException("Operação não permitida no estado atual.");
    }
}
