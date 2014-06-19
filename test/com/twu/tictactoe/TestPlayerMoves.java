package com.twu.tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestPlayerMoves {

    @Test
    public void shouldGetCoordinateOnUserInput() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1");
        HumanPlayer player = new HumanPlayer(reader,printStream,1);
        int move = player.makeMove();
        assertThat(move, is(1));

    }

    @Test
    public void shouldPromptForNewInputIfSpotFilled() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        int move1 = 1;

        board.addMove(move1, "y");
        board.addMove(move1, "y");

        verify(printStream).println("Location already taken. ");


    }

    @Test
    public void shouldPromptForNewInputIfSpotFiledDifferentPlayers() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        int move1 = 1;

        board.addMove(move1,"y");
        board.addMove(move1, "z");

        verify(printStream).println("Location already taken. ");


    }



}
