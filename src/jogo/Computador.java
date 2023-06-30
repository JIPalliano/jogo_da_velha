package jogo;

import java.util.Random;

public class Computador {
	// Vetor que vai receber o valor da linha e coluna.
	public int[] tentativa = new int[2];
	public int computador;
	// variavel que vai gerar n�meros aleat�rios. 
	public Random random = new Random();
	
    // inst�nciando a vari�vel do computador.
	public Computador(int computador) {
		this.computador = computador;
		System.out.println("Jogador criado!");
	}
	
	// Jogada ir� validar a jogada e mandara para o tabuleiro.
    public void jogada(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setLocalizacao(tentativa, computador);
    } 
	
	// Tentativa � a jogada que ser� efetuada, checado e confirmado
    public void Tentativa(Tabuleiro tabu){
      do {
    	  
    	  tentativa[0] = random.nextInt(3);
    	  tentativa[1] = random.nextInt(3);
    	  
      }while(!checaTentativa(tentativa, tabu));
    }	

	// checar se a localiza��o da pe�a � valida se n�o esta ocupada.
	 public boolean checaTentativa(int[] tentativa, Tabuleiro tabu){
	        if(tabu.getLocalizacao(tentativa) == 0)
	            return true;
	        else
	            return false;
	            

	 }
	 
		

		
}
