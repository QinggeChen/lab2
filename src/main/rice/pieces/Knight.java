package main.rice.pieces;

import main.rice.Coordinate;

/**
 * A representation of a Knight, which is a chess piece for whom a valid move consists of
 * two steps along one axis (horizontal/vertical) and one step along the other axis.
 * Unlike other chess pieces, Knights can "jump" over pieces that are in their path.
 */
public class Knight extends AChessPiece {

    /**
     * Constructor for a Bishop; delegates to the super constructor to initialize fields.
     *
     * @param color the color of this piece ("black" or "white")
     * @param startPos the start position of this piece
     */
    public Knight(String color, Coordinate startPos) {
        // TODO: implement this constructor
    }

    // TODO: override any methods left abstract in the superclass (AChessPiece)
}
