package boardgames;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Board board1 = new Board();
		Scanner sc = new Scanner(System.in);

		for (int step = 0; step < 5; step++) {
			if (board1.isGameOver()) {
				board1.showBoard();
				System.out.println("Game over");
				break;
			}

			Move machineMove = MinimaxAlgo.getBestMove(board1, false, 3);
			board1.move(machineMove, false);
			board1.showBoard();
			
			if (board1.isGameOver()) {
				board1.showBoard();
				System.out.println("Game over");
				break;
			}

			System.out.println("Machine's turn (X): " + machineMove.r + " " + machineMove.c);
			
			Move playerMove; 
			do {
				System.out.print("Yours turn (o): ");
				int index = sc.nextInt();
				playerMove = new Move(index / 3, index % 3);
			}
			while (board1.checkDuplicate(playerMove));
			board1.move(playerMove, true);
		}

	}
}
