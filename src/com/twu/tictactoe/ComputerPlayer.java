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
        int winningMove = findHorizontalWinningMove();
        if(winningMove>0){
            return winningMove;
        }
        winningMove = findVerticalWinningMove();
        if(winningMove>0){
            return winningMove;
        }
        winningMove = findDiagonalWinningMove();
        if(winningMove>0){
            return winningMove;
        }
        return 0;
    }

    private int findDiagonalWinningMove() {

        if(board.getSymbolAt(1).equals(board.getSymbolAt(5)) && symbol.equals(board.getSymbolAt(1)) && board.isSpotOpen(9)){
            return 9;
        }
        else if(board.getSymbolAt(5).equals(board.getSymbolAt(9)) && symbol.equals(board.getSymbolAt(5)) && board.isSpotOpen(1)){
            return 1;
        }
        else if(board.getSymbolAt(1).equals(board.getSymbolAt(9)) && symbol.equals(board.getSymbolAt(1)) && board.isSpotOpen(5)){
            return 5;
        }
        else if(board.getSymbolAt(3).equals(board.getSymbolAt(5)) && symbol.equals(board.getSymbolAt(3)) && board.isSpotOpen(7)){
            return 7;
        }
        else if(board.getSymbolAt(5).equals(board.getSymbolAt(7)) && symbol.equals(board.getSymbolAt(5)) && board.isSpotOpen(3)){
            return 3;
        }
        else if(board.getSymbolAt(3).equals(board.getSymbolAt(7)) && symbol.equals(board.getSymbolAt(3)) && board.isSpotOpen(5)){
            return 5;
        }
        return 0;
    }

    private int findVerticalWinningMove() {
        for (int i = 1; i <= 3; i++) {
            if (board.getSymbolAt(i).equals(board.getSymbolAt(i + 3)) && symbol.equals(board.getSymbolAt(i)) && board.isSpotOpen(i+6)){
                return i+6;
            }
            else if(board.getSymbolAt(i).equals(board.getSymbolAt(i + 6)) && symbol.equals(board.getSymbolAt(i)) && board.isSpotOpen(i+3)){
                return i+3;
            }
            else if(board.getSymbolAt(i+3).equals(board.getSymbolAt(i+6)) && symbol.equals(board.getSymbolAt(i+3))&& board.isSpotOpen(i)){
                return i;
            }
        }
        return 0;
    }

    public int findHorizontalWinningMove() {
        int rowOffSet = 0;
        for (int i = 1; i<=9; i+=3) {
            if (board.getSymbolAt(i).equals(board.getSymbolAt(i + 1)) && symbol.equals(board.getSymbolAt(i))&& board.isSpotOpen(i+2)){
                return i+2;
            }
            else if(board.getSymbolAt(i).equals(board.getSymbolAt(i + 2)) && symbol.equals(board.getSymbolAt(i))&& board.isSpotOpen(i+1)){
                return i+1;
            }
            else if(board.getSymbolAt(i+1).equals(board.getSymbolAt(i+2)) && symbol.equals(board.getSymbolAt(i+1))&& board.isSpotOpen(i)){
                return i;
            }

        }
        return 0;
    }


}
