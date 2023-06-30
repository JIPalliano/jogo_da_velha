package jogo;

/*
 * classe do tabuleiro onde sera possivel visualizar o X e O .*/ 

public class Tabuleiro {
	
	public int tabu[][] = new int[3][3];
//O construtor vai receber a função que zera o tabueliro.
	public Tabuleiro() {
        tabuleirozero();
                  
    }

//posicionando X e O juntamento com as linha e colunas, o visual do tabuleiro.
	public void visualizar() {
			System.out.println();
			for (int i = 0; i < tabu.length; i++) {
				for (int j = 0; j < tabu.length; j++) {
					if(tabu[i][j] == -1) {
						System.out.print(" X ");
					}
					if(tabu[i][j] == 1) {
						System.out.print(" O ");
					}
					if (tabu[i][j] == 0) {
						System.out.print(" - ");
					}
					if(j == 0 || j == 1) 
						System.out.print("|");
					
				}
				System.out.println();
			}
	}
	
	
	public void tabuleirozero() {
		for(int i=0; i<tabu.length; i++)
			for(int j=0; j<tabu.length; j++)
				tabu[i][j]=0;
	}

	/*getPosicao vai receber a posição da linha e coluna. 
	 * tentativa[0]: linha
	 * tentativa[1]: coluna
	 * irá retornar os valores.*/ 
	public int getPosicao(int[] tentativa) {
		return tabu[tentativa[0]][tentativa[1]];
	}
	
	public int getLocalizacao(int[] tentativa) {
		return tabu[tentativa[0]][tentativa[1]];
	}
	// setPosicao vai setar a posição conferindo se a jogada do usuario foi verdadeira ou falsa
	public void setPosicao(int[] tentativa, int jogador) {
		if(jogador == 1) {
			tabu[tentativa[0]][tentativa[1]] = -1;
		}
		else {
			tabu[tentativa[0]][tentativa[1]] = 1;
		visualizar();
		}
		
	}
	
	public void setLocalizacao(int[] tentativa, int computador) {
		if(computador == 2) {
			tabu[tentativa[0]][tentativa[1]] = -1;
		}
		else {
			tabu[tentativa[0]][tentativa[1]] = 1;
		visualizar();
		}
		
	}
		
	// Essa função irá checar as linhas, colunas e diagonais se estão completas e decidir quem ganhou.
	public int checarSituacao() {
		for(int i=0;i<3;i++) {
			if(tabu[i][0] + tabu[i][1] + tabu[i][2] == -3) 
				return -1;
			
			if(tabu[i][0] + tabu[i][1] + tabu[i][2] == 3) 
				return 1;
			
		}
			for(int j=0;j<3;j++) {
				
				if(tabu[0][j] + tabu[1][j] + tabu[2][j] == -3) 
					return -1;
				
				if(tabu[0][j] + tabu[1][j] + tabu[2][j] == 3) 
					return 1;
				
				
			}
			
			if(tabu[0][0] + tabu[1][1] + tabu[2][2] == -3) 
				return -1;
			
			if(tabu[0][0] + tabu[1][1] + tabu[2][2] == 3)
				return 1;
			
			if(tabu[0][2] + tabu[1][1] + tabu[2][0] == -3) 
				return -1;
			
			if(tabu[0][2] + tabu[1][1] + tabu[2][0] == 3) 
				return 1;
		
			return 0;
	}
	// tabuleiroCompleto irá retornar se o tabuleiro esta 100% completo, comprovando um empate.
	public boolean tabuleiroCompleto() {
		for(int i=0;i<tabu.length;i++)
			for(int j=0;j<tabu.length;j++)
				if(tabu[i][j] == 0)
					return false;
		return true;
	}
	

	
}
