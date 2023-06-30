package jogo;

import java.util.Scanner;
/*
 * Nessa classe haver� as jogadas e escolha de lado.*/ 
public class Game {
	// Todos os chamados das classes e as inst�ncias
	    private Tabuleiro tabuleiro;
	    private int rodada=1, vez=1;
	    private Jogador player1;
	    private Computador player2;
	    public Scanner entrada = new Scanner(System.in);

	    // Construtor inst�ncia o tabuleiro e os jogadores, para construir o jogo.
	    public Game(){
	        tabuleiro = new Tabuleiro();
	        iniciarJogadores();
	        
	        while( Jogar() );
	    }
	    
	  //Escolha do X ou O.
	    
	    public void iniciarJogadores(){
	        System.out.println("Quem vai ser o 'X' ?");
	        if(escolherJogador() == 1)
	            this.player1 = new Jogador(1);
	        else
	            this.player2 = new Computador(1);
	        System.out.println("----------------------");
	        System.out.println("Quem vai ser o 'O' ?");
	        
	        if(escolherJogador() == 1)
	        	this.player1 = new Jogador(1);
	        else
	            this.player2 = new Computador(1);
	    }
	    
	    //Aqui ir� ocorrer a l�gica da escolha de lado.
	    public int escolherJogador(){
	        int opcao=0;
	        
	        do{
	            System.out.println("1. Jogador ");
	            System.out.println("2. Computador\n");
	            System.out.print("Op��o: ");
	            opcao = entrada.nextInt();
	            
	            if(opcao != 1 && opcao != 2) {
	                System.out.println("Op��o inv�lida! Tente novamente");
	            }
	        }while(opcao != 1 && opcao != 2);
	        
	        return opcao;
	    }
	    
	    // fun��o da jogada, ir� imprimir as rodadas e vez do usuario, vai conferir se o jogador ganhou ou perdeu.
	    public boolean Jogar(){
	        if(ganhou() == 0 ){
	            System.out.println("----------------------");
	            tabuleiro.visualizar();
	            System.out.println("\nRodada "+rodada);
	            System.out.println("� a vez do jogador " + vez() );
	           
				if(vez()==1)
					player1.jogada(tabuleiro);
	            else
	            	player2.jogada(tabuleiro);
	            
	            
	            if(tabuleiro.tabuleiroCompleto()){
	                System.out.println("Tabuleiro Completo. Jogo empatado");
	                return false;
	            }
	            vez++;
	            rodada++;

	            return true;
	        } else{
	            if(ganhou() == -1 )
	                System.out.println("Jogador 1 ganhou!");
	            else
	                System.out.println("Jogador 2 ganhou!");
	            
	            return false;
	        }
	            
	    }
	    
	    public int vez(){
	        if(vez%2 == 1)
	            return 1;
	        else
	            return 2;
	    }
	    //checagem de quem ganhou.
	    public int ganhou(){
	        if(tabuleiro.checarSituacao() == 1)
	            return 1;
	        
	        if(tabuleiro.checarSituacao() == -1)
	            return -1;

	        
	        return 0;
	    }
	    
	    
	}


