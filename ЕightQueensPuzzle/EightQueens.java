package eightQueensPuzzle;

import java.util.HashSet;
import java.util.Set;
 
public class EightQueens {
	// total rows & total columns
	
	final static int size = 8;
	static int solutionsFound = 0;
	static boolean[][] chessboard = new boolean[size][size];
	
	static Set<Integer> attackedRows = new HashSet<>();
	static Set<Integer> attackedColumns = new HashSet<>();
	static Set<Integer> attackedLeftDiagonals = new HashSet<>();
	static Set<Integer> attackedRightdiagonal = new HashSet<>();
	
	static void putQueens(int row) {
		if (row == size) {
			printSolution();
		} else {
			for (int col = 0; col < size; col++) {
				if (canPlaceQueen(row, col)) {
					markAllAttackedPositions(row, col);
					putQueens(row + 1);
					unmarkAllAttackedPositions(row, col);
				}
			}
		}
	}

	private static void printSolution() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(chessboard[row][col] ? "* " : "- ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		solutionsFound++;
	}

	private static void unmarkAllAttackedPositions(int row, int col) {
		attackedRows.remove(row);
		attackedColumns.remove(col);
		attackedLeftDiagonals.remove(col - row);
		attackedRightdiagonal.remove(row + col);
		chessboard[row][col] = false;		
	}

	private static void markAllAttackedPositions(int row, int col) {
		attackedRows.add(row);
		attackedColumns.add(col);
		attackedLeftDiagonals.add(col - row);
		attackedRightdiagonal.add(row + col);
		chessboard[row][col] = true;
	}

	private static boolean canPlaceQueen(int row, int col) {
		boolean positionOccupied = attackedRows.contains(row)
								|| attackedColumns.contains(col)
								|| attackedLeftDiagonals.contains(col - row)
								|| attackedRightdiagonal.contains(row + col);
		return !positionOccupied;
	}
}
