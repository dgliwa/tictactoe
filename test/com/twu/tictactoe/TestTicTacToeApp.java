package com.twu.tictactoe;

import org.junit.Test;
import org.junit.runner.Computer;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestTicTacToeApp {

    @Test
    public void shouldStartCallBoardDisplay() throws IOException {
        Board board = mock(Board.class);
        HumanPlayer player1 = mock(HumanPlayer.class);
        ComputerPlayer player2 = mock(ComputerPlayer.class);
        TicTacToeApp app = new TicTacToeApp(board, player1,player2);
        when(board.isFull()).thenReturn(true);
        app.start();
        verify(board).draw();
    }


}
