package events;

//import java.security.AlgorithmParameterGenerator;
import java.util.HashMap;

import model.Joueur;
import model.Piece;
import utilitaires.Utilitaires;

public class Events {
	public static void isMovable(Piece P, Joueur J) {

	}
	public static void transfrom_To_Queen(HashMap<String, Piece> hmP,Piece P, String[][] board) {
		if(P.getColour()=="Blanc") {
			if(P.getY()==1) {
				hmP.remove(P.getName());
				P.setQueen(true);
				P.setName("QB"+String.valueOf(P.getId()));
				board[P.getY()][P.getX()]=P.getName();
				hmP.put(P.getName(), P);
			}
		}else {
			if(P.getY()==board.length-2) {
				hmP.remove(P.getName());
				P.setQueen(true);
				P.setName("QN"+String.valueOf(P.getId()));
				board[P.getY()][P.getX()]=P.getName();
				hmP.put(P.getName(), P);
			}
		}
	}
//only move if its your turn
//move only your colours

//mouvement event


//move sert à bouger un pion(piece)
	public static void move(HashMap<String, Piece> hmP,Piece P, String[][] board, int x, int y) {
		board[P.getY()][P.getX()] = ".";
		P.setX(x);
		P.setY(y);
		board[P.getY()][P.getX()] = P.getName();
		transfrom_To_Queen(hmP,P,board);
	}

	public static void check_Moves() {

	}

	// eat event
	public static void eat_Event(Piece predator, Piece victim, String[][] board, HashMap<String, Piece> hmP) {
		System.out.println(predator.getName() + " ate " + victim.getName());
		board[victim.getY()][victim.getX()] = Utilitaires.get_Position(board, victim.getX(), victim.getY());
		hmP.remove(victim.getName());
	}



	// change turns after each play
	// game over
	// if player is out of pieces
	// if player cant move anymore
}
