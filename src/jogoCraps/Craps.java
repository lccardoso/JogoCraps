package jogoCraps;

import java.util.Random;

public class Craps {
	
	//cria��o do gerador de n�meros aleat�rios
	private static final Random randonNumbers = new Random();
	
	//constantes que representam o status do jogo
	private enum Status {CONTINUE, GANHOU, PERDEU};
	
	//constantes que representam o lan�amentos dos dados do jogo
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	
	//joga uma partida de Craps
	public void play()
	{
	//int contador = 0;
	//int voceGanhou = 0;
	int mypoint = 0;
	Status gameStatus;
	int sumOfDice = rollDice();
	
	switch (sumOfDice){
	case SEVEN:
	case YO_LEVEN:
		gameStatus = Status.GANHOU;
		break;
	
	case SNAKE_EYES:
	case TREY:
	case BOX_CARS:	
		gameStatus = Status.PERDEU;
		break;
		
	default:
		gameStatus = Status.CONTINUE;
		mypoint = sumOfDice;
		System.out.println("Seus pontos s�o" + mypoint);
		break;
		}
		//end of switch
		//enquanto o jogo nao estiver completo
		while (gameStatus == Status.CONTINUE){
			sumOfDice = rollDice();
			
			if(sumOfDice == mypoint)
				gameStatus = Status.GANHOU;
			else
			if(sumOfDice == SEVEN )
				gameStatus = Status.PERDEU;
		}// fim do while
		
		//Exibe mensagem se ganhou ou perdeu
		if (gameStatus == Status.GANHOU)
			System.out.println("Voc� ganhou!");
		else
			System.out.println("Voc� perdeu!");
			
	}// fim do m�todo play

	public int rollDice() {
	
		//selecionar valores aleat�ios do dado
		int die1 = 1 + randonNumbers.nextInt(6);//primeiro lan�amento
		int die2 = 1 + randonNumbers.nextInt(6);//segundo lan�amento
		
		int sum = die1 + die2;
		
		//Exibe resultados
		System.out.printf("Valor sorteado pelo jogador %d + %d = %d\n" , die1 , die2 , sum);
		
		return sum;
	}	//fim do m�todo rollDice

}	
