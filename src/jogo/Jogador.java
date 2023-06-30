package jogo;

import java.util.Scanner;

public class Jogador {
	
	public int[] tentativa = new int[2];
	public int jogador;
	public Scanner entrada = new Scanner(System.in);
	
	// inst�nciando a vari�vel do Jogador.
	public Jogador(int jogador) {
		this.jogador = jogador;
		System.out.println("Jogador criado!");
	}
	
	// Jogada ir� validar a jogada e mandara para o tabuleiro.
    public void jogada(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    } 
	
    // Tentativa � a jogada que ser� efetuada, checado e confirmado.
    public void Tentativa(Tabuleiro tabuleiro){
    	// la�o de repeti��o server para validar a jogado do usuario, caso n�o fa�a a jogada correta n�o vai sair do la�o.
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Linha inv�lida. � 1, 2 ou 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Coluna inv�lida. � 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local j� foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
	
    // checar se a localiza��o da pe�a � valida se n�o esta ocupada.
	 public boolean checaTentativa(int[] tentativa, Tabuleiro tabu){
	        if(tabu.getPosicao(tentativa) == 0)
	            return true;
	        else
	            return false;
	            
	    }
}


