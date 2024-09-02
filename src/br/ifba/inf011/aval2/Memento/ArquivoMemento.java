package br.ifba.inf011.aval2.Memento;

import br.ifba.inf011.aval2.state.ArquivoState;

//MEMENTO EM MEMENTO
public class ArquivoMemento {
    private final String conteudo;
    private final ArquivoState state;

    public ArquivoMemento(String conteudo, ArquivoState state) {
        this.conteudo = conteudo;
        this. state =  state;
    }

    public String getConteudo() {
        return conteudo;
    }

    public ArquivoState getEstado() {
        return  state;
    }
}
