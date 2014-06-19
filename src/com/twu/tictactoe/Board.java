package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class Board {

    String[][]moves = {{" "," "," "},{" "," "," "},{" "," "," "}};

    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void draw() {
        printStream.println(generateBoard());
    }

    private String generateBoard(){
        String boardString = "";

        boardString += String.format(" %s | %s | %s \n", moves[0][0],moves[0][1],moves[0][2]);
        boardString += "------------\n";
        boardString += String.format(" %s | %s | %s \n", moves[1][0],moves[1][1],moves[1][2]);
        boardString += "------------\n";
        boardString += String.format(" %s | %s | %s \n", moves[2][0],moves[2][1],moves[2][2]);

        return boardString;
    }

    public boolean addX(int move) {
        return addMove(move, "x");
    }

    public boolean addMove(int move, String symbol) {
        int x = (move-1)/3;
        int y = (move-1)%3;
        if(moves[x][y]!=" "){
            printStream.println("Location already taken. ");
            return false;
        }
        else {
            moves[x][y] = symbol;
        }
        return true;
    }

    public boolean addO(int move) {
        return addMove(move, "o");
    }

    public boolean isFull() {
        for (String[] move : moves) {
            for (String s : move) {
               if (s.equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(){
        if(this.isHorizontalWin() || this.isVerticalWin() || this.isDiagonalWin()){
            return true;
        }
        return false;
    }

    private boolean isDiagonalWin() {
        if(moves[0][0].equals(moves[1][1]) && moves[1][1].equals(moves[2][2]) && !moves[0][0].equals(" ")){
            return true;
        }
        else if(moves[2][0].equals(moves[1][1]) && moves[1][1].equals(moves[0][2]) && !moves[2][0].equals(" ")){
            return true;
        }

        return false;
    }

    private boolean isVerticalWin() {
        for (int i = 0; i < 3; i++) {
            if(moves[0][i].equals(moves[1][i]) && moves[1][i].equals(moves[2][i]) && !moves[0][i].equals(" ")){
                return true;
            }

        }
        return false;
    }

    private boolean isHorizontalWin() {
        for (String[] move : moves) {
            if(move[0].equals(move[1]) && move[1].equals(move[2]) && !move[0].equals(" ")){
                return true;
            }
        }
        return false;
    }

    public boolean isSpotOpen(int move){
        int x = (move-1)/3;
        int y = (move-1)%3;
        if(moves[x][y]!=" "){
            return false;
        }
        return true;
    }

    public void endInDraw() {
        printStream.println("Game is a draw");
    }

    public String getSymbolAt(int move){
        int x = (move-1)/3;
        int y = (move-1)%3;
        return moves[x][y];
    }
}
