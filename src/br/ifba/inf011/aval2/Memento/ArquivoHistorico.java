package br.ifba.inf011.aval2.Memento;

import java.time.LocalDate;
import java.util.Stack;
import br.ifba.inf011.aval2.bridge.ArquivoCodificacao;
import br.ifba.inf011.aval2.model.Arquivo;

//ORIGINATOR EM ORIGINATOR 
public class ArquivoHistorico extends Arquivo implements Originator {
    private Stack<ArquivoMemento> historico;

    public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, ArquivoCodificacao codificacao) {
        super(nome, dataCriacao, conteudo, codificacao);
        this.historico = new Stack<>();
    }

    @Override
    public ArquivoMemento criarCheckpoint() {
        ArquivoMemento memento = new ArquivoMemento(this.getConteudo(), this.state);
        this.historico.push(memento);
        return memento;
    }

    @Override
    public void restaurar(ArquivoMemento memento) throws IllegalAccessException {
        if (memento == null) {
            throw new IllegalAccessException("O memento fornecido é inválido.");
        }
        this.setConteudo(memento.getConteudo());
        this.state = memento.getEstado();
    }

    public void desfazer() throws IllegalAccessException {
        if (historico.isEmpty()) {
            throw new IllegalAccessException("Não há estados para desfazer.");
        }
        ArquivoMemento memento = historico.pop();
        this.setConteudo(memento.getConteudo());
        this.state = memento.getEstado(); 
    }
    
}
