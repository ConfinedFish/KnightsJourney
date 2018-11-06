package knightsjourney;

import java.util.Iterator;

/**
 * This class contains methods to solve the Knight's Journey problem.
 *
 * For this problem several things are considered. The number of columns and rows,
 * as well as the start position of the knight. The knight's tour  details a series
 * of moves of the knight chess piece such that the knight lands on each spot on the grid
 * a single time.
 *
 */
public class Knight implements Application{
    private static byte moves;
    private final int col;
    private final int row;
    private final Position start;
    private final byte[][] grid;

    /**
     * Constructor for the Knight object.
     * @param col The number of columns for the board
     * @param row the number of rows for the board
     * @param start the start position of the knight. A position object can store two values: the column and row.
     */
    public Knight(int col, int row, Position start) {
        this.col = col;
        this.row = row;
        this.start = start;
        this.grid = new byte[col][row];
        moves = 0;
    }
    /**
     * Creates a copy of the current grid returns the copy
     * @return a copy of the current grid
     */
    public byte[][] getGrid(){
        byte[][] gridCopy = new byte[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                gridCopy[i][j] = grid[i][j];
        return gridCopy;
     }
    /**
     * Gets the start position
     * @return the start position of the knight.
     */
    Position getStart() {
        return start;
    }

    /**
     * Checks whether the position is okay for the knight to move to.
     * The conditions checked are:
     *  1. whether the column and row are within the grid.
     *  2. whether the column and row are negative
     *  3. the current value at the position in the grid. If it is anything but zero, that means the knight has already
     *     visited that position on that grid.
     * @param pos - the position to check
     *
     * @return - true: whether the square is okay to travel to, false if it has already visited the position.
     */
    @Override
    public boolean isOK(Position pos) {
        return pos.getColumn() >= 0 && pos.getColumn() < grid.length && pos.getRow() >= 0 && pos.getRow() < grid[0].length && grid[pos.getColumn()][pos.getRow()] == 0;
    }

    /**
     * Marks the position as possible. This method sets the value of the grid a the specified position to the number
     * of moves after it increments the value. This is done to keep track of the moves and provide a path on the grid
     * that the knight took during its tour.
     * @param pos the position that has been marked as possibly being on a
     */
    @Override
    public void markAsPossible(Position pos) {
        moves++;
        grid [pos.getColumn()][pos.getRow()] = moves;
    }

    /**
     * Checks whether the knight has reached the maximum number of moves in its tour. The position in this application
     * is unknown, therefore the position is not used in this method, however, necessary to override the Application
     * isGoal() method.
     * @param pos the position that may or may not be a goal position.
     *
     * @return true if the number of moves
     */
    @Override
    public boolean isGoal(Position pos) {
        return moves == (col * row);
    }

    /**
     * Marks the position as an available position to move to. In code, this is represented as a zero. If the knight
     * has not visited the spot, it is marked with a zero. If the knight has visited, it is marked with the number of
     * moves necessary to reach that spot.
     * @param pos the position that has been marked as not being on any path to
     */
    @Override
    public void markAsDeadEnd(Position pos) {
        grid[pos.getColumn()][pos.getRow()] = 0;
        moves--;
    }

    /**
     * Constructs the iterator object, and returns it
     * @param pos the position the Iterator object starts at.
     *
     * @return a new KnightIterator object based on the position.
     */
    @Override
    public Iterator<Position> iterator(Position pos) {
        return new KnightIterator(pos);
    }

    /**
     * Builds the grid into a StringBuilder object and returns that String. Each value in the grid is surrounded with
     * [] and each row is followed by a \n in order to indicate a new line is being built. In order for consistency,
     * if the value is less than 10, a space is added to the character. This is to ensure every character in the grid
     * takes up the same amount of space, and presents an evenly spaced grid.
     * @return A string containing the entire board and an empty line.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (byte[] grid : grid) {
            for (int j = 0; j < this.grid[0].length; j++) {
                String stringVal;
                if (grid[j] < 10) {
                    stringVal = " " + Byte.toString(grid[j]);
                } else {
                    stringVal = Byte.toString(grid[j]);
                }
                builder.append("[").append(stringVal).append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    /**
     * This class provides methods for moving the knight piece. The class iterates over the possible positions it can
     * move to, and selects that position. Other methods include whether the knight has any more possible moves at its
     * current position.
     *
     */
    protected static class KnightIterator implements Iterator<Position>{
        static final int MAX = 8;
        int row, col, count;
        KnightIterator(Position position){
            this.row = position.getRow();
            this.col = position.getColumn();
            this.count = 0;
        }

        /**
         * Checks to see if the knight has any more legal moves at this position.
         * @return true if the knight has more moves and false if there are none.
         */
        public boolean hasNext(){
            return count < MAX;
        }

        /**
         * This method provides the program with the legal moves of a knight in chess. The program then goes on to
         * check whether that is a possible move.
         * @return a new legal position each time the method is called.
         */
        public Position next(){
            Position next = new Position();
            switch (count++){
                case 0:
                    next = new Position(row + 2, col + 1);//NW
                    break;
                case 1:
                    next = new Position(row + 1, col + 2);//NE
                    break;
                case 2:
                    next = new Position(row - 1, col + 2);//EN
                    break;
                case 3:
                    next = new Position(row - 2, col + 1);//ES
                    break;
                case 4:
                    next = new Position(row - 2, col - 1);//SE
                    break;
                case 5:
                    next = new Position(row - 1, col - 2);//SW
                    break;
                case 6:
                    next = new Position(row + 1, col - 2);//WS
                    break;
                case 7:
                    next = new Position(row + 2, col - 1);//WN
            }

            return next;
        }
    }
}
