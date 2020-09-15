package main.rice.pieces;

import main.rice.Coordinate;

/**
 * A representation of a Rook, which is a chess piece for whom a valid move consists of an
 * arbitrary number of steps along a single axis (horizontal or vertical). Rooks cannot
 * "jump" over other pieces; in other words, none of the steps other than the final step
 * may collide with existing pieces.
 */
public class Rook extends AChessPiece {

    /**
     * Constructor for a Bishop; delegates to the super constructor to initialize fields.
     *
     * @param color    the color of this piece ("black" or "white")
     * @param startPos the start position of this piece
     */
    public Rook(String color, Coordinate startPos) {
        // TODO: implement this constructor
    }

    // TODO: override any methods left abstract in the superclass (AChessPiece)
}
