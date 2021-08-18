package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static int[][] board = new int[3][3];
	static final Scanner sc = new Scanner(System.in);
	static char letter;

	public static void main(String[] args) {
		createBoard();
		System.out.println("Tic Tac Toe Board is created!!");
		chooseLetter();
		playerChoice(letter);
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
		toss();
		switch (letter) {
		case 'X':
			System.out.println("It has choosen X to play the game");
			System.out.println("Board is:");
			showBoard();
			playerChoice(letter);
			break;
		case 'O':
			System.out.println("It has choosen O to play the game");
			System.out.println("Board is");
			showBoard();
			playerChoice(letter);
			break;
		default:
			System.out.println("You have enterd Invalid letter");
			chooseLetter();
		}
	}

	public static void showBoard() {
		int k = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = Character.forDigit(k++, 10);
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static void playerChoice(char letter) {
		char choice;
		for (int i = 0; i < 2; i++) {
			choice = sc.next().charAt(0);
			if (choice > 'o' && choice < '9') {
				checkFreeSpace();
				replace(board, choice, letter);
				showBoard();
			} else {
				playerChoice(letter);
			}
			choice = sc.next().charAt(0);
			if (choice > 'o' && choice < '9') {
				checkFreeSpace();
				replace(board, choice, letter);
				showBoard();
			} else {
				playerChoice(letter);
			}
			choice = sc.next().charAt(0);
			if (choice > 'o' && choice < '9') {
				checkFreeSpace();
				replace(board, choice, letter);
				showBoard();
			} else {
				playerChoice(letter);
			}
		}
	}

	public static void replace(int[][] board2, char find, char replace) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == find) {
					board[i][j] = replace;
					return;
				}
			}
		}
	}

	public static void toss() {
		Random random = new Random();
		int randomCheck = random.nextInt(2);
		if (randomCheck == 1) {
			System.out.println("Player won the toss");
		} else {
			System.out.println("Computer won the toss");
		}
	}
	
	public static boolean checkingForWinner() {
		return (checkForRow() || checkForColumn() || checkForDiagonal());
	}
	
	public static boolean checkForRow() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkForColumn() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkForDiagonal() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[0][0], board[1][1], board[2][2]) == true || check(board[0][2], board[1][1], board[2][0]) == true)  {
				return true;
			}
		}
		return false;
	}
	
	public static boolean check(int c1, int c2, int c3) {
		return ((c1 == c2) && (c2 == c3));
		
	}
	
	public static void checkFreeSpace() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != letter) {
					System.out.println("Here it is free space");
					return;
				} else {
					System.out.println("Here it is not free space");
					playerChoice(letter);
				}
			}
		}
	}
}
