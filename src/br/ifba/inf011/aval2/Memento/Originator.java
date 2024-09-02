package br.ifba.inf011.aval2.Memento;

//ORIGINATOR INTERFACE EM MEMENTO 
public interface Originator{
	  ArquivoMemento criarCheckpoint();
	  void restaurar(ArquivoMemento memento) throws IllegalAccessException;
}
