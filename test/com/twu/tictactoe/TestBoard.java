package com.twu.tictactoe;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBoard {

    @Test
    public void shouldDrawBoard(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.draw();
        verify(printStream).println("   |   |   \n"+
                                    "------------\n" +
                                    "   |   |   \n"+
                                    "------------\n" +
                                    "   |   |   \n");
    }



    @Test
    public void shouldDrawBoardWithX() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.addX(1);
        board.draw();
        verify(printStream).println(" x |   |   \n"+
                "------------\n" +
                "   |   |   \n"+
                "------------\n" +
                "   |   |   \n");

    }

    @Test
    public void shouldDrawBoardWithO() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.addO(1);
        board.draw();
        verify(printStream).println(" o |   |   \n"+
                "------------\n" +
                "   |   |   \n"+
                "------------\n" +
                "   |   |   \n");

    }

    @Test
    public void shouldRemainUnchangedAfterInsertToSamePosition() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.addO(1);
        board.addX(1);
        board.draw();
        verify(printStream).println(" o |   |   \n"+
                "------------\n" +
                "   |   |   \n"+
                "------------\n" +
                "   |   |   \n");

    }

    @Test
    public void shouldReturnIsNotFilled(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board((printStream));
        assertThat(board.isFull(), is(false));
    }

    @Test
    public void shouldReturnIsFilled(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board((printStream));
        for (int i = 1; i <= 9; i++) {
             board.addX(i);

        }
        assertThat(board.isFull(), is(true));
    }

    @Test
    public void shouldBoardEndInDraw(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board((printStream));
        board.endInDraw();
        verify(printStream).println("Game is a draw");
    }

    @Test
     public void shouldBoardDisplayWinHorizontal(){
        PrintStream printStream = mock(PrintStream.class);
        HumanPlayer player = mock(HumanPlayer.class);
        Board board = new Board((printStream));
        board.addX(1);
        board.addX(2);
        board.addX(3);

        assertThat(board.isWin(),is(true));
    }

    @Test
    public void shouldBoardDisplayWinVertical(){
        PrintStream printStream = mock(PrintStream.class);
        HumanPlayer player = mock(HumanPlayer.class);
        Board board = new Board((printStream));
        board.addX(1);
        board.addX(4);
        board.addX(7);

        assertThat(board.isWin(),is(true));
    }

    @Test
    public void shouldBoardDisplayWinDiagonal(){
        PrintStream printStream = mock(PrintStream.class);
        HumanPlayer player = mock(HumanPlayer.class);
        Board board = new Board((printStream));
        board.addX(1);
        board.addX(5);
        board.addX(9);

        assertThat(board.isWin(),is(true));
    }

    @Test
    public void shouldBoardDisplayWinDiagonalOtherDirection(){
        PrintStream printStream = mock(PrintStream.class);
        HumanPlayer player = mock(HumanPlayer.class);
        Board board = new Board((printStream));
        board.addX(3);
        board.addX(5);
        board.addX(7);

        assertThat(board.isWin(),is(true));
    }

    @Test
    public void shouldSpotBeNotOpen(){
        Board board = new Board(mock(PrintStream.class));
        board.addX(3);
        assertThat(board.isSpotOpen(3),is(false));
    }

    @Test
    public void shouldSpotBeOpen(){
        Board board = new Board(mock(PrintStream.class));
        assertThat(board.isSpotOpen(3),is(true));
    }

}
