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
		toss();
		System.out.print("Choose letter X or O:");
		char letter = sc.next().charAt(0);
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

	public static void toss() {
		int player1 = 0;
		Random random = new Random();
		int randomCheck = random.nextInt(2);
		if (randomCheck == player1) {
			System.out.println("player1 win the toss!!");
		} else {
			System.out.println("player2 win the toss!!");
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
			System.out.println("player1marker:");
			choice = sc.next().charAt(0);
			System.out.println(choice);
			checkFreeSpace();
			replace(board, choice, letter);
			showBoard();

			System.out.println("player2marker:");
			choice = sc.next().charAt(0);
			System.out.println(choice);
			checkFreeSpace();
			replace(board, choice, letter);
			showBoard();
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
