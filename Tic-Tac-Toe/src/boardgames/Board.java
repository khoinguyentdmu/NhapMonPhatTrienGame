package boardgames;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	public char[][] matrir;

	public Board() {
		matrir = new char[3][3];
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				matrir[r][c] = '-';
	}
	
	public Board(char[][] matrir) {
		this.matrir = matrir;
	}
	
	public void showBoard() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++)
				System.out.print(matrir[r][c] + " ");
			System.out.println();
		}
	}

	public ArrayList<Move> getMoves() {
		ArrayList<Move> result = new ArrayList<Move>();

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++)
				if (this.matrir[r][c] == '-')
					result.add(new Move(r, c));
		}

		return result;
	}

	public Board makeMove(Move move, boolean isPlayer) {
		char[][] tempMatrir =  new char[3][3];
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				tempMatrir[r][c] = matrir[r][c];
		
		if (isPlayer) 
			tempMatrir[move.r][move.c] = 'o';
		else
			tempMatrir[move.r][move.c] = 'x';
		
		return new Board(tempMatrir);
	}
	
	public int evaluate() {
		for (int r = 0; r < 3; r++) {
			if (matrir[r][0] == matrir[r][1] && matrir[r][1] == matrir[r][2]) {
				if (matrir[r][0] == 'x')
					return -1;
				else if (matrir[r][0] == 'o')
					return 1;
			}
		}

		for (int c = 0; c < 3; c++) {
			if (matrir[0][c] == matrir[1][c] && matrir[1][c] == matrir[2][c]) {
				if (matrir[0][c] == 'x')
					return -1;
				else if (matrir[0][c] == 'o')
					return 1;
			}
		}

		if (matrir[0][0] == matrir[1][1] && matrir[1][1] == matrir[2][2]) {
			if (matrir[0][0] == 'x')
				return -1;
			else if (matrir[0][0] == 'o')
				return 1;
		}

		if (matrir[0][2] == matrir[1][1] && matrir[1][1] == matrir[2][0]) {
			if (matrir[0][2] == 'x')
				return -1;
			else if (matrir[0][2] == 'o')
				return 1;
		}

		return 0;
	}

	public boolean isGameOver() {
		return evaluate() != 0;
	}
	
	public void move(Move move, boolean isPlayer) {
		if (isPlayer) 
			matrir[move.r][move.c] = 'o';
		else
			matrir[move.r][move.c] = 'x';
	}
	
	public boolean checkDuplicate(Move move) {
		return matrir[move.r][move.c] != '-';
	}
}
