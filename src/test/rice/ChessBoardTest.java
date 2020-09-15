package test.rice;

import main.rice.ChessBoard;
import main.rice.Coordinate;
import main.rice.pieces.AChessPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the ChessBoard class.
 */
public class ChessBoardTest {

    /**
     * Tests that a move from an invalid (out-of-bounds) start position is not accepted.
     */
    @Test
    void testStartPosInvalid() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));

        // Attempt to make a move from an invalid position and check that move() returns
        // false
        boolean result = board.move(new Coordinate(-1, 0), new Coordinate(0, 0));
        assertFalse(result);

        // Check that the state is unchanged
        assertEquals(blackRook, board.getPiece(new Coordinate(0, 0)));
        assertEquals(blackRook.getPosition(), new Coordinate(0, 0));
    }

    /**
     * Tests that a move to an invalid (out-of-bounds) end position is not accepted.
     */
    @Test
    void testEndPosInvalid() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));

        // Attempt to make a move to an invalid position and check that move() returns
        // false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(-1, 0));
        assertFalse(result);

        // Check that the state is unchanged
        assertEquals(blackRook, board.getPiece(new Coordinate(0, 0)));
        assertEquals(blackRook.getPosition(), new Coordinate(0, 0));
    }

    /**
     * Tests that a move from an empty start position is not accepted.
     */
    @Test
    void testStartPosEmpty() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Attempt to move a nonexistant piece and check that move() returns false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(-1, 0));
        assertFalse(result);
    }

    /**
     * Tests that a no-op move is not accepted.
     */
    @Test
    void testMoveNoOp() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Attempt to make a move that doesn't match the allowable pattern for a Rook
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(0, 0));
        assertFalse(result);
    }

    /**
     * Tests that an invalid move (valid pattern, but collides with another piece of the
     * same color) is not accepted.
     */
    @Test
    void testMoveValidPatternSelfCollision() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));
        AChessPiece blackKnight = board.getPiece(new Coordinate(0, 1));

        // Attempt to make a move that doesn't match the allowable pattern for a Rook
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(0, 1));
        assertFalse(result);

        // Check that the state is unchanged
        assertEquals(blackRook, board.getPiece(new Coordinate(0,0)));
        assertEquals(blackKnight, board.getPiece(new Coordinate(0,1)));
        assertEquals(blackRook.getPosition(), new Coordinate(0, 0));
    }

    /**
     * Tests that a valid diagonal move of a Bishop is accepted.
     */
    @Test
    void testMoveBishopValid() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackBishop = board.getPiece(new Coordinate(0, 2));

        // Make a valid move and check that move() returns true
        boolean result = board.move(new Coordinate(0, 2), new Coordinate(2, 0));
        assertTrue(result);

        // Check that the board and Bishop are in the correct state
        assertNull(board.getPiece(new Coordinate(0, 2)));
        assertEquals(blackBishop, board.getPiece(new Coordinate(2, 0)));
        assertEquals(blackBishop.getPosition(), new Coordinate(2, 0));
    }

    /**
     * Tests that an invalid (vertical) move of a Bishop is not accepted.
     */
    @Test
    void testMoveBishopInvalidPattern() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackBishop = board.getPiece(new Coordinate(0, 2));

        // Attempt to make a move that doesn't match the allowable pattern for a Bishop
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 2), new Coordinate(1, 2));
        assertFalse(result);

        // Check that the state is unchanged
        assertNull(board.getPiece(new Coordinate(1, 2)));
        assertEquals(blackBishop, board.getPiece(new Coordinate(0, 2)));
        assertEquals(blackBishop.getPosition(), new Coordinate(0, 2));
    }

    /**
     * Tests that a valid L-shaped move (one horizontal, two vertical) of a Knight is
     * accepted.
     */
    @Test
    void testMoveKnightValid1() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackKnight = board.getPiece(new Coordinate(0, 1));

        // Make a valid move and check that move() returns true
        boolean result = board.move(new Coordinate(0, 1), new Coordinate(2, 0));
        assertTrue(result);

        // Check that the board and Bishop are in the correct state
        assertNull(board.getPiece(new Coordinate(0, 1)));
        assertEquals(blackKnight, board.getPiece(new Coordinate(2, 0)));
        assertEquals(blackKnight.getPosition(), new Coordinate(2, 0));
    }

    /**
     * Tests that a valid L-shaped move (two horizontal, one vertical) of a Knight is
     * accepted.
     */
    @Test
    void testMoveKnightValid2() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackKnight = board.getPiece(new Coordinate(0, 1));

        // Make a valid move and check that move() returns true
        boolean result = board.move(new Coordinate(0, 1), new Coordinate(1, 3));
        assertTrue(result);

        // Check that the board and Bishop are in the correct state
        assertNull(board.getPiece(new Coordinate(0, 1)));
        assertEquals(blackKnight, board.getPiece(new Coordinate(1, 3)));
        assertEquals(blackKnight.getPosition(), new Coordinate(1, 3));
    }

    /**
     * Tests that an invalid move of a Knight is not accepted.
     */
    @Test
    void testMoveKnightInvalidPattern() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackKnight = board.getPiece(new Coordinate(0, 1));

        // Attempt to make a move that doesn't match the allowable pattern for a Knight
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 1), new Coordinate(2, 1));
        assertFalse(result);

        // Check that the state is unchanged
        assertNull(board.getPiece(new Coordinate(2, 1)));
        assertEquals(blackKnight, board.getPiece(new Coordinate(0, 1)));
        assertEquals(blackKnight.getPosition(), new Coordinate(0, 1));
    }

    /**
     * Tests that a valid vertical move of a Rook is accepted.
     */
    @Test
    void testMoveRookValidVertical() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));

        // Make a valid move and check that move() returns true
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(3, 0));
        assertTrue(result);

        // Check that the board and Rook are in the correct state
        assertNull(board.getPiece(new Coordinate(0, 0)));
        assertEquals(blackRook, board.getPiece(new Coordinate(3, 0)));
        assertEquals(blackRook.getPosition(), new Coordinate(3, 0));
    }

    /**
     * Tests that a valid horizontal move of a Rook (following a valid vertical move) is
     * accepted.
     */
    @Test
    void testMoveRookValidVerticalHorizontal() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));

        // Make two valid moves and check that they return true
        board.move(new Coordinate(0, 0), new Coordinate(3, 0));
        boolean result = board.move(new Coordinate(3, 0), new Coordinate(3, 3));
        assertTrue(result);

        // Check that the board and Rook are in the correct state
        assertNull(board.getPiece(new Coordinate(0, 0)));
        assertNull(board.getPiece(new Coordinate(3, 0)));
        assertEquals(blackRook, board.getPiece(new Coordinate(3, 3)));
        assertEquals(blackRook.getPosition(), new Coordinate(3, 3));
    }

    /**
     * Tests that an invalid (diagonal) move of a Rook is not accepted.
     */
    @Test
    void testMoveRookInvalidPattern() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));

        // Attempt to make a move that doesn't match the allowable pattern for a Rook
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(1, 1));
        assertFalse(result);

        // Check that the state is unchanged
        assertNull(board.getPiece(new Coordinate(1, 1)));
        assertEquals(blackRook, board.getPiece(new Coordinate(0, 0)));
        assertEquals(blackRook.getPosition(), new Coordinate(0, 0));
    }

    /**
     * Tests that an invalid move (valid pattern, but is not a Knight and attempts to
     * jump over a piece en route to its final destination) is not accepted.
     */
    @Test
    void testMoveRookValidPatternCollision() {
        // Initialize the board
        ChessBoard board = new ChessBoard();

        // Grab a reference to the piece we're trying to move
        AChessPiece blackRook = board.getPiece(new Coordinate(0, 0));
        AChessPiece whiteBishop = board.getPiece(new Coordinate(7, 2));

        // Set up a situation with two pieces belonging to the opponent in a row
        board.move(new Coordinate(7, 0), new Coordinate(3, 0));
        board.move(new Coordinate(7, 2), new Coordinate(5, 0));

        // Attempt to make a move that doesn't match the allowable pattern for a Rook
        // and check that move() returns false
        boolean result = board.move(new Coordinate(0, 0), new Coordinate(5, 0));
        assertFalse(result);

        // Check that the state is unchanged by the last attempted move
        assertEquals(whiteBishop, board.getPiece(new Coordinate(5, 0)));
        assertEquals(blackRook, board.getPiece(new Coordinate(0, 0)));
        assertEquals(blackRook.getPosition(), new Coordinate(0, 0));
    }
}