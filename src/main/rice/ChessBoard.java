package main.rice;

import main.rice.pieces.*;

/**
 * A representation of a chess board, which is an 8x8 grid of squares. Each square is
 * either empty or contains an AChessPiece.
 */
public class ChessBoard {

    /**
     * Dimensions of the board (number of rows/columns).
     */
    private int dim = 8;

    /**
     * Representation of the board; each square contains an AChessPiece or null (if
     * empty).
     */
    private AChessPiece[][] board;

    /**
     * Constructor for a ChessBoard; creates a new board
     */
    public ChessBoard() {
        // Create the board
        this.board = new AChessPiece[dim][dim];

        // Create the pieces
        this.initPieces(0, "black");
        this.initPieces(7, "white");
    }

    /**
     * Returns the chess piece (or null) located at the specified position.
     *
     * @param pos the position to get the contents of
     * @return the piece located at the given position
     */
    public AChessPiece getPiece(Coordinate pos) {
        return this.board[pos.getRow()][pos.getCol()];
    }

    /**
     * Returns a string representation of the board.
     *
     * @return a string representation of the board
     */
    @Override
    public String toString() {
        // String-ify the top edge
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------\n");

        // String-ify each row
        for (int row = 0; row < this.dim; row++) {
            sb.append("|");
            for (int col = 0; col < this.dim; col++) {
                // Get the piece in the given (row, col) position
                AChessPiece piece = this.board[row][col];

                if (piece == null) {
                    // Empty square
                    sb.append("    |");
                    continue;
                }

                // Get one-character representations of the color and type
                // Note: an alternative design would be to define toString() for each
                // AChessPiece type and to simply call that here; that would make this
                // method cleaner, but the downside is that the String we want here
                // might not be a great String representation for all use cases (it's
                // relatively indescriptive.)
                String colorDesignator = piece.getColor().substring(0, 1).toUpperCase();
                String typeDesignator;
                if (piece instanceof Bishop) {
                    typeDesignator = "B";
                } else if (piece instanceof Knight) {
                    typeDesignator = "K";
                } else {
                    typeDesignator = "R";
                }

                // Non-empty square: display colorDesignator + typeDesignator
                sb.append(" ").append(colorDesignator).append(typeDesignator)
                    .append(" |");
            }
            sb.append("\n-----------------------------------------\n");
        }

        // Return the complete string representation of the board
        return sb.toString();
    }

    /**
     * Performs the specified move (from startPos to endPos) iff it is valid, updating
     * both the board as well as the piece's notion of its location.
     *
     * @param startPos the current location of the piece to be moved
     * @param endPos   the prospective destination of the piece to be moved
     * @return true if the move was able to be completed successfully; false otherwise
     */
    public boolean move(Coordinate startPos, Coordinate endPos) {
        // TODO: implement this method
        return false;
    }

    /**
     * Initializes a set of pieces of the given color in the given row.
     *
     * @param row   the row in which to place the pieces
     * @param color the color of the pieces
     */
    private void initPieces(int row, String color) {
        board[row][0] = new Rook(color, new Coordinate(row, 0));
        board[row][1] = new Knight(color, new Coordinate(row, 1));
        board[row][2] = new Bishop(color, new Coordinate(row, 2));
        board[row][5] = new Bishop(color, new Coordinate(row, 5));
        board[row][6] = new Knight(color, new Coordinate(row, 6));
        board[row][7] = new Rook(color, new Coordinate(row, 7));
    }
}
