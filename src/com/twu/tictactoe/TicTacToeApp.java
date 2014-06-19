package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TicTacToeApp {

    private Board board;
    private HumanPlayer player1;
    private ComputerPlayer player2;

    public TicTacToeApp(Board board, HumanPlayer player1, ComputerPlayer player2){
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(System.out);
        TicTacToeApp app = new TicTacToeApp(board, new HumanPlayer(reader,System.out, 1),new ComputerPlayer(board,2, "y"));
        app.start();
    }

    public void start() throws IOException {
        board.draw();
        while(!board.isFull()) {
            int move = player1.makeMove();
            while(!board.addX(move)){
                move = player1.makeMove();
            }
            board.draw();
            if(board.isWin()){
                System.out.println("Player " + player1.playerNum + " wins!");
                break;
            }
            if(!board.isFull()) {

                move = player2.makeMove();
                while(!board.addO(move)){
                    move = player2.makeMove();
                }
                board.draw();
                if(board.isWin()){
                    System.out.println("Player " + player2.playerNum + " wins!");
                    break;
                }
            }
            else{
                board.endInDraw();
            }
        }

    }
}
