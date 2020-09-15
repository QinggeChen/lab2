package main.rice.pieces;

import main.rice.Coordinate;

/**
 * An abstract representation of an individual chess piece.
 */
public abstract class AChessPiece {

    // TODO: decide whether any of the following methods ought to be implemented here 
    // rather than being left abstract

    /**
     * @return the color of this chess piece
     */
    public abstract String getColor();

    /**
     * @return the current position of this chess piece
     */
    public abstract Coordinate getPosition();

    /**
     * Moves this piece by updating its position to be newPos.
     *
     * @param newPos the new position for this piece
     */
    public abstract void move(Coordinate newPos);

    /**
     * Checks whether the move to endPos is a valid move. If it's invalid, returns null;
     * if it's valid, returns an array of coordinates. These coordinates represent the
     * points along the path from this chess piece's current position to endPos that the
     * will need to be checked for collisions.
     *
     * @param endPos the prospective destination of this piece
     * @return null if endPos is an invalid move; an array of intermediate coordinates
     * between this chess piece's current position and endPos otherwise
     */
    public abstract Coordinate[] validateMove(Coordinate endPos);
}
