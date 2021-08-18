package com.bridgelabz.tictactoe;

public class TicTacToe {
	static int board[][] = new int[3][3];
	public static void main(String[] args) {
		createBoard();
		System.out.println("Tic Tac Toe Board is created!!");
	}
	
	public static void createBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

}
