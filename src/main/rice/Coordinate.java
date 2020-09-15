package main.rice;

/**
 * A simple class representing a (row, col) coordinate.
 */
public class Coordinate {

    /**
     * The row number.
     */
    private int row;

    /**
     * The column number.
     */
    private int col;

    /**
     * Constructor for a main.rice.Coordinate; stores the row and column numbers.
     * @param row row number
     * @param col column number
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @return the row number
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return the column number
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Returns true if this and o are equivalent (based on their row and column values);
     * false otherwise.
     *
     * @param o the object to compare to
     * @return true if this and o are equivalent; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // If o is not a Coordinate, it's not equal
        if (!(o instanceof Coordinate)) {
            return false;
        }

        // Check row and column values
        Coordinate other = (Coordinate)o;
        return (other.getRow() == this.getRow() && other.getCol() == this.getCol());
    }
}