package jogo;

import java.util.Scanner;

public class Jogador {
	
	public int[] tentativa = new int[2];
	public int jogador;
	public Scanner entrada = new Scanner(System.in);
	
	// instânciando a variável do Jogador.
	public Jogador(int jogador) {
		this.jogador = jogador;
		System.out.println("Jogador criado!");
	}
	
	// Jogada irá validar a jogada e mandara para o tabuleiro.
    public void jogada(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    } 
	
    // Tentativa é a jogada que será efetuada, checado e confirmado.
    public void Tentativa(Tabuleiro tabuleiro){
    	// laço de repetição server para validar a jogado do usuario, caso não faça a jogada correta não vai sair do laço.
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local já foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
	
    // checar se a localização da peça é valida se não esta ocupada.
	 public boolean checaTentativa(int[] tentativa, Tabuleiro tabu){
	        if(tabu.getPosicao(tentativa) == 0)
	            return true;
	        else
	            return false;
	            
	    }
}


