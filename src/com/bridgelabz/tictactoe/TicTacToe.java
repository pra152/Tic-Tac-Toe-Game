package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	static int[][] board = new int[3][3];
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		createBoard();
		System.out.println("Tic Tac Toe Board is created!!");
		chooseLetter();
		showBoard();
	}

	public static void createBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static void chooseLetter() {
		System.out.print("Choose letter X or O:");
		char letter = sc.next().charAt(0);
		switch (letter) {
		case 'X':
			System.out.println("It has choosen X to play the game");
			break;
		case 'O':
			System.out.println("It has choosen O to play the game");
			break;
		default:
			System.out.println("You have enterd Invalid letter");
		}
	}

	public static void showBoard() {
		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = k++;
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}
}
