package boardgames;

public class MinimaxAlgo {
	public static MinimaxOutput minimax(Board board, boolean isPlayer, int maxDepth, int currentDepth) {
		if (board.isGameOver() || currentDepth == maxDepth) 
			return new MinimaxOutput(board.evaluate(), null);
		
		MinimaxOutput bestState = new MinimaxOutput(isPlayer?-2:2, null);
		
		for (Move move: board.getMoves()) {
			Board newBoard = (Board) board.makeMove(move, !isPlayer);
			
			MinimaxOutput currentState = minimax(newBoard, !isPlayer, maxDepth, currentDepth+1);
			
			if (isPlayer) {
				if (currentState.score > bestState.score) {
					bestState.score = currentState.score;
					bestState.move = move;
				}
			}
			else {
				if (currentState.score < bestState.score) {
					bestState.score = currentState.score;
					bestState.move = move;
				}
			}
		}
		
		return bestState;
	}
	
	public static Move getBestMove(Board board, boolean isPlayer, int maxDepth) {
		MinimaxOutput output = minimax(board, isPlayer, maxDepth, 0);
		return output.move;
	}
}
