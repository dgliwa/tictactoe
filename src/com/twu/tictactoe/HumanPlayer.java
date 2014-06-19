package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class HumanPlayer implements Player {
    public final int playerNum;
    private BufferedReader reader;
    private PrintStream printStream;

    public HumanPlayer(BufferedReader reader, PrintStream printStream, int playerNum) {
        this.reader = reader;
        this.printStream = printStream;
        this.playerNum = playerNum;
    }

    @Override
    public int makeMove() {
        printStream.println("Choose a place to move (1-9): ");
        String move = null;
        try {
            move = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int position = Integer.parseInt(move);
        return position;
    }
}
