package Assignment5;
class NQueens{ 
	final int N = 4; 

	// function to print solution 
	void printSolution(int board[][]) { 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) 
				System.out.print(" " + board[i][j] + " "); 
			System.out.println(); 
		} 
	} 

	// function to check if a queen can be placed on board or not.
	boolean nQueen(int board[][], int row, int col){ 
		int i, j; 
		
		// Check this row on left side 
		for (i = 0; i < col; i++)
			if (board[row][i] == 1) 
				return false; 
		
		// Check upper diagonal on left side 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1) 
				return false; 

		// Check lower diagonal on left side 
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == 1) 
				return false; 
		return true; 
	} 

	// A recursive function to solve N Queen problem
	boolean solveNQueen(int board[][], int col) 
	{ 
		//  If all queens are placed then return true 
		if (col >= N) 
			return true; 

		// placing this queen in all rows one by one
		for (int i = 0; i < N; i++) { 
			// Check if the queen can be placed on board[i][col] 
			if (nQueen(board, i, col)) { 
				board[i][col] = 1; 

			       // place rest of the queens
			       if (solveNQueen(board, col + 1) == true) 
				         return true; 

			      // If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col]
		       	      board[i][col] = 0; // BACKTRACK 
		       } 
		} 

		// If the queen can not be placed in any row in this column col, then return false 
		return false; 
	} 

	// This function solves the N Queen problem using Backtracking.
	boolean solveNQ() 
	{ 
		int board[][] = { { 0, 0, 0, 0 }, 
				  { 0, 0, 0, 0 }, 
				  { 0, 0, 0, 0 }, 
				  { 0, 0, 0, 0 } }; 

		if (solveNQueen(board, 0) == false) { 
			System.out.print("Solution does not exist"); 
			return false; 
		} 

		printSolution(board); 
		return true; 
	} 
 
	public static void main(String args[]) 
	{ 
		NQueens Queen = new NQueens(); 
		Queen.solveNQ(); 
	} 
} 
