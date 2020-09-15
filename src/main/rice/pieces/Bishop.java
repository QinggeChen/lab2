package main.rice.pieces;

import main.rice.Coordinate;

/**
 * A representation of a Bishop, which is a chess piece for whom a valid move consists of
 * an arbitrary number of steps in a diagonal direction (same horizontal and vertical
 * deltas). Bishops cannot "jump" over other pieces; in other words, none of the steps
 * other than the final step may collide with existing pieces.
 */
public class Bishop extends AChessPiece {

    /**
     * Constructor for a Bishop.
     *
     * @param color    the color of this piece ("black" or "white")
     * @param startPos the start position of this piece
     */
    public Bishop(String color, Coordinate startPos) {
        // TODO: implement this constructor
    }

    // TODO: override any methods left abstract in the superclass (AChessPiece)
}
