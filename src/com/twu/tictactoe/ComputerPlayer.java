package com.twu.tictactoe;

import java.util.Random;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ComputerPlayer implements Player {
    public final int playerNum;
    private String symbol;
    private Board board;

    public ComputerPlayer(Board board, int playerNum, String symbol){

        this.board = board;
        this.playerNum = playerNum;
        this.symbol = symbol;
    }


    @Override
    public int makeMove(){
        int move = findWinningMove();
        if(move == 0) {
            Random randomGenerator = new Random();
            move = randomGenerator.nextInt(9) + 1;
            while (!board.isSpotOpen(move)) {
                move = randomGenerator.nextInt(9) + 1;

            }
        }
        return move;
    }

    public int findWinningMove(){
        int winningMove = findHorizontalWinningMove(symbol);
        if(winningMove>0){
            return winningMove;
        }
        winningMove = findVerticalWinningMove(symbol);
        if(winningMove>0){
            return winningMove;
        }
        winningMove = findDiagonalWinningMove(symbol);
        return 0;
    }

    private int findDiagonalWinningMove(String symbol) {

        return 0;
    }

    private int findVerticalWinningMove(String symbol) {
        for (int i = 1; i <= 3; i++) {
            if (board.getSymbolAt(i).equals(board.getSymbolAt(i + 3)) && symbol.equals(board.getSymbolAt(i))){
                return i+6;
            }
            else if(board.getSymbolAt(i).equals(board.getSymbolAt(i + 6)) && symbol.equals(board.getSymbolAt(i))){
                return i+3;
            }
            else if(board.getSymbolAt(i+3).equals(board.getSymbolAt(i+6)) && symbol.equals(board.getSymbolAt(i+3))){
                return i;
            }
        }
        return 0;
    }

    public int findHorizontalWinningMove(String symbol) {
        int rowOffSet = 0;
        for (int i = 1; i<=9; i+=3) {
            if (board.getSymbolAt(i).equals(board.getSymbolAt(i + 1)) && symbol.equals(board.getSymbolAt(i))){
                return i+2;
            }
            else if(board.getSymbolAt(i).equals(board.getSymbolAt(i + 2)) && symbol.equals(board.getSymbolAt(i))){
                return i+1;
            }
            else if(board.getSymbolAt(i+1).equals(board.getSymbolAt(i+2)) && symbol.equals(board.getSymbolAt(i+1))){
                return i;
            }

        }
        return 0;
    }


}
