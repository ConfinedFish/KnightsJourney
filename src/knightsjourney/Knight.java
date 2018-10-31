package knightsjourney;

import java.util.Iterator;

public class Knight implements Application{
    private static byte moves;
    private int col, row;
    private Position start;
    private byte[][] grid;

    public Knight(int col, int row, Position start) {
        this.col = col;
        this.row = row;
        this.start = start;
        this.grid = new byte[col][row];
        moves = 0;
    }
    
    Position getStart() {
        return start;
    }
    byte getMoves(){
        return moves;
    }
    @Override
    public boolean isOK(Position pos) {
        return pos.getColumn() >= 0 && pos.getColumn() < grid.length && pos.getRow() >= 0 && pos.getRow() < grid[0].length && grid[pos.getColumn()][pos.getRow()] == 0;
    }

    @Override
    public void markAsPossible(Position pos) {
        moves++;
        grid [pos.getColumn()][pos.getRow()] = moves;
    }

    @Override
    public boolean isGoal(Position pos) {
        return moves == (col * row);
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        grid[pos.getColumn()][pos.getRow()] = 0;
        moves--;
    }

    @Override
    public Iterator<Position> iterator(Position pos) {
        return new KnightIterator(pos);
    }
    protected class KnightIterator implements Iterator<Position>{
        static final int MAX = 8;
        int row, col, count;
        KnightIterator(Position position){
            this.row = position.getRow();
            this.col = position.getColumn();
            this.count = 0;
        }
        public boolean hasNext(){
            return count < MAX;
        }
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
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (byte[] grid : grid) {
            for (int j = 0; j < this.grid[0].length; j++) {
                String stringVal;
                if (grid[j] < 10){
                   stringVal = " " + Byte.toString(grid[j]);
                }else{
                    stringVal = Byte.toString(grid[j]);
                }
                builder.append("[").append(stringVal).append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
