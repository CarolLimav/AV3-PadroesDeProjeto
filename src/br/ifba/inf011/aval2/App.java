package br.ifba.inf011.aval2;
import java.time.LocalDate;
import br.ifba.inf011.aval2.Memento.ArquivoHistorico;
import br.ifba.inf011.aval2.Memento.ArquivoMemento;
import br.ifba.inf011.aval2.bridge.CodificacaoBinaria;
import br.ifba.inf011.aval2.bridge.CodificacaoTexto;
import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Pasta;


public class App {
	
	
	public void runQ1() throws IllegalAccessException  {
	
		   Credencial user01 = new Credencial("user01");

	        EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "0100001101001001010011100100001101001111", new CodificacaoTexto());
	        EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", new CodificacaoTexto());
	        EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", new CodificacaoTexto());
	        EntradaOperavel d1 = new Arquivo("D1", LocalDate.now(), "UM ARQUIVO TAMNHO MUITO MUITO E IMENSAMENTE GRANDE", new CodificacaoBinaria());
	        ArquivoHistorico arquivoHistorico = new ArquivoHistorico("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", new CodificacaoTexto());

	        Entrada a = new Pasta("A", LocalDate.now());
	        Entrada b = new Pasta("B", LocalDate.now());
	        Entrada c = new Pasta("C", LocalDate.now());
	        Entrada raiz = new Pasta("/", LocalDate.now());

	        raiz.addFilho(a);
	        raiz.addFilho(b);

	        a.addFilho(a1);

	        b.addFilho(c);
	        b.addFilho(b1);

	        c.addFilho(c1);

	        
	        System.out.println("-------------DUMPS----------------");
	        System.out.println("Dump A1 BINÁRIO: " + a1.dump()); 
	        System.out.println("Dump B1 TEXTO: " + b1.dump()); 
	        System.out.println("\n");
	        
	        
	        
	        System.out.println("---- Testando Estado Normal ----");
	        try {
	            System.out.println("Conteúdo B1: " + b1.ler(user01));  
	            b1.escrever(user01, "NOVO CONTEUDO");  
	            System.out.println("Conteúdo B1 após escrita: " + b1.ler(user01)); 
	            System.out.println("Tamanho de B1: " + b1.getTamanho());  
	            System.out.println("Conteúdo após escrita: " + b1.ler(user01));
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO: " + e.getMessage());
	        }
	        
	        
	        System.out.println("---- Terminando teste em estado Normal ----\n");
	        
	        System.out.println("---- TESTE EM MEMENTO ARQUIVO HISTÓRICO ----\n");
	        ArquivoMemento mementoInicial = arquivoHistorico.criarCheckpoint();
	        System.out.println("Conteúdo inicial do histórico: " + arquivoHistorico.getConteudo());
	       
	        arquivoHistorico.setConteudo("CONTEÚDO ALTERADO");
	        ArquivoMemento mementoAlterado = arquivoHistorico.criarCheckpoint();
	        System.out.println("Conteúdo alterado do histórico: " + arquivoHistorico.getConteudo());

	     
	        arquivoHistorico.restaurar(mementoInicial);
	        System.out.println("Conteúdo após restauração ao estado inicial: " + arquivoHistorico.getConteudo());

      
	        arquivoHistorico.restaurar(mementoAlterado);
	        System.out.println("Conteúdo após desfazer a alteração: " + arquivoHistorico.getConteudo());
	        
	        
	        System.out.println("---- TERMINANDO TESTE EM MEMENTO ARQUIVO HISTÓRICO ----\n");
	        
	        System.out.println("---- Testando Estado Somente Leitura ----");
	        ((Arquivo) b1).definaSomenteLeitura();
	        try {
	            System.out.println("Conteúdo B1 (Somente Leitura): " + b1.ler(user01));  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO:  " + e.getMessage());
	        }
	        try {
	            b1.escrever(user01, "TENTATIVA DE ESCRITA");  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO:  " + e.getMessage());
	        }
	        System.out.println("Tamanho de B1 (Somente Leitura): " + b1.getTamanho());  
	        System.out.println("---- Testando teste de somente leitura ----\n");
	        
	        
	        
	        
	        System.out.println("---- Testando Estado Bloqueado ----");
	        ((Arquivo) b1).bloqueie();
	        try {
	            b1.ler(user01);  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO: " + e.getMessage());
	        }
	        try {
	            b1.escrever(user01, "TENTATIVA DE ESCRITA BLOQUEADA");  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO: " + e.getMessage());
	        }
	        System.out.println("Tamanho de B1 (Bloqueado): " + b1.getTamanho());  
	        
	        System.out.println("TERMINANDO TESTE DE BLOQUEADO ----------------\n"); 

	        System.out.println("---- Testando Estado Excluído ----");
	        ((Arquivo) b1).exclua();
	        try {
	            b1.ler(user01);  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO: " + e.getMessage());
	        }
	        try {
	            b1.escrever(user01, "TENTATIVA DE ESCRITA EXCLUÍDA");  
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO: " + e.getMessage());
	        }
	        System.out.println("Tamanho de B1 (Excluído): " + b1.getTamanho());  
            System.out.println("-------------Terminando teste de excluído--------------\n");
            
            
            
	        System.out.println("---- Testando Bridge ----");
	        try {
	        
	            a1.escrever(user01, "CINCO");
	            System.out.println("Escrita em A1: " + a1.ler(user01));
	        } catch (IllegalAccessException ex) {
	            System.out.println("NÃO FOI POSSÍVEL ESCREVER EM A1");
	        }

	        System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	        
	       
	        ((Arquivo) a1).definaSomenteLeitura();
	        try {
	            a1.escrever(user01, "NOVO CONTEÚDO");
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL ESCREVER EM A1:" + e.getMessage());
	        }

	        
	        ((Arquivo) a1).bloqueie();
	        try {
	            a1.escrever(user01, "CINCO+2");
	        } catch (IllegalAccessException ex) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO DE ESCRITA: " + ex.getMessage());
	        }

	       
	        try {
	            System.out.println("A1: " + a1.ler(user01));
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL CONCLUIR A OPERAÇÃO DE LEITURA: " + e.getMessage());
	        }

	           
	        ((Arquivo) a1).exclua();
	        try {
	            System.out.println("Tamanho de A1 excluído: " + a1.getTamanho());
	        } catch (IllegalAccessException e) {
	            System.out.println("ARQUIVO A1 EXCLUÍDO NÃO TEM TAMANHO" + e.getMessage());
	        }

	       
	        ((Arquivo) a1).restaure();
	        try {
	            System.out.println("Conteúdo de A1 restaurado: " + a1.ler(user01));
	        } catch (IllegalAccessException e) {
	            System.out.println("NÃO FOI POSSÍVEL LER DE A1 APÓS RESTAURAÇÃO: " + e.getMessage());
	        }

	        System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

	       
	        arquivoHistorico.restaurar(mementoInicial);
	        System.out.println("Conteúdo após restauração ao estado inicial: " + arquivoHistorico.getConteudo());

	       
	        arquivoHistorico.restaurar(mementoAlterado);
	        System.out.println("Conteúdo após desfazer a alteração: " + arquivoHistorico.getConteudo());
		
	}
		
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ1();
	}

}