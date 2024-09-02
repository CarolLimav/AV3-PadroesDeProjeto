package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.List;
import br.ifba.inf011.aval2.bridge.ArquivoCodificacao;
import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.state.ArquivoState;
import br.ifba.inf011.aval2.state.NormalState;

public class Arquivo extends AbstractEntrada implements EntradaOperavel, ArquivoCodificacao {
    
    public String conteudo;
    protected ArquivoCodificacao codificacao;
    protected ArquivoState state;

    
    public Arquivo(String nome, LocalDate dataCriacao, String conteudo, ArquivoCodificacao codificacao) {
        super(nome, dataCriacao);
        this.codificacao = codificacao; 
        this.conteudo = codificacao.codificar(conteudo);
        this.state = new NormalState(this); 
    }

    @Override
    public List<Entrada> getFilhos() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFilho(Entrada entrada) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeFilho(Entrada entrada) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long getTamanho() throws IllegalAccessException {
    	return Long.valueOf(this.conteudo.length());
    }

    @Override
    public String ler(Credencial credencial) throws IllegalAccessException {
        return this.state.ler(); 
    }

    @Override
    public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
      this.conteudo = this.state.setConteudo(codificacao.codificar(conteudo)); 
    }

    @Override
    public String dump() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) throws IllegalAccessException {
        this.conteudo = conteudo;
    }

    public void restaure() throws IllegalAccessException {
        this.state = this.state.restaurar();
    }

    public void bloqueie() throws IllegalAccessException {
        this.state = this.state.bloquear();
    }

    public void definaSomenteLeitura() throws IllegalAccessException {
        this.state = this.state.definirSomenteLeitura();
    }

    public void exclua() throws IllegalAccessException {
        this.state = this.state.excluir();
        this.conteudo = ""; 
    }

    public void libere() throws IllegalAccessException {
        this.state = this.state.liberar();
    }

    public String getConteudo() {
        return this.conteudo;
    }

    @Override
    public String codificar(String conteudo) {
        return this.codificacao.codificar(conteudo);
    }

    @Override
    public String decodificar(String conteudo) {
        return this.codificacao.decodificar(conteudo);
    }
}
