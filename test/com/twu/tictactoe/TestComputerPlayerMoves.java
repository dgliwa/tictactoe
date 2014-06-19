package com.twu.tictactoe;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;


/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestComputerPlayerMoves {

    @Test
    public void shouldComputerPlayerGenerateMove() throws IOException {
        Board board = new Board(mock(PrintStream.class));

        ComputerPlayer computerPlayer = new ComputerPlayer(board,1, "x");
        int move = computerPlayer.makeMove();
        assertThat(move, is(greaterThan(0)));
        assertThat(move,is(lessThan(10)));
    }

    @Test
    public void shouldComputerPlayerGenerateMoveToOpenSpace() throws IOException{
        Board board = new Board(mock(PrintStream.class));
        board.addX(1);
        board.addX(2);
        board.addX(3);
        board.addX(4);
        board.addX(5);
        board.addX(6);
        board.addX(7);
        board.addX(8);

        ComputerPlayer computerPlayer = new ComputerPlayer(board,1, "x");
        int move = computerPlayer.makeMove();
        assertThat(move, is(9));

    }

    @Test
    public void shouldComputerPlayerGenerateWinningMoveHorizontal(){
        Board board = new Board(mock(PrintStream.class));
        board.addX(1);
        board.addX(3);

        ComputerPlayer computerPlayer = new ComputerPlayer(board,1,"x");
        int move = computerPlayer.makeMove();
        assertThat(move, is(2));
    }

    @Test
    public void shouldComputerPlayerGenerateWinningMoveVertical(){
        Board board = new Board(mock(PrintStream.class));
        board.addX(1);
        board.addX(4);

        ComputerPlayer computerPlayer = new ComputerPlayer(board,1,"x");
        int move = computerPlayer.makeMove();
        assertThat(move, is(7));
    }

    @Test
    public void shouldComputerPlayerGenerateWinningMoveDiagonal(){
        Board board = new Board(mock(PrintStream.class));
        board.addX(1);
        board.addX(5);

        ComputerPlayer computerPlayer = new ComputerPlayer(board,1,"x");
        int move = computerPlayer.makeMove();
        assertThat(move, is(9));
    }
}
