package knightsjourney;

import java.util.Iterator;

public class Knight implements Application{
    private int gridx,gridy;
    private Position start;
    protected Position finish;
    protected byte[][] grid;
    
    protected final byte PATH = 9, DEAD_END = 2, CORRIDOR = 1;
    
    public Knight(int gridx, int gridy, Position start) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.start = start;
        this.grid = new byte[gridx][gridy];
    }
    
    public Position getStart() {
        return start;
    }
    
    public Position getFinish(){
        return finish;
    }
    
    @Override
    public boolean isOK(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < grid.length && pos.getColumn() >= 0 && pos.getColumn() < grid.length && grid[pos.getRow()][pos.getColumn()] == CORRIDOR;
    }

    @Override
    public void markAsPossible(Position pos) {
        grid [pos.getRow()][pos.getColumn()] = PATH;
    }

    @Override
    public boolean isGoal(Position pos) {
        return pos.getRow() == finish.row && pos.getColumn() == finish.column;
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        grid[pos.getRow()][pos.getColumn()] = DEAD_END;
    }

    @Override
    public Iterator<Position> iterator(Position pos) {
        return new KnightIterator(pos);
    }
    protected class KnightIterator implements Iterator<Position>{
        protected static final int MAX = 8;
        protected int col, row, count;
        public KnightIterator(Position position){
            this.col = position.getColumn();
            this.row = position.getRow();
            this.count = 0;
        }
        public boolean hasNext(){
            return count < MAX;
        }
        public Position next(){
            Position next = new Position();
            switch (count++){
                case 0:
                    next = new Position(row - 1, col + 2);//NW
                    break;
                case 1:
                    next = new Position(row + 1, col + 2);//NE
                    break;
                case 2:
                    next = new Position(row + 2, col + 1);//EN
                    break;
                 case 3:
                    next = new Position(row + 2, col - 1);//ES
                    break;
                case 4:
                    next = new Position(row + 1, col - 2);//SE
                    break;
                case 5:
                    next = new Position(row - 1, col - 2);//SW
                    break;
                case 6:
                    next = new Position(row - 2, col - 1);//WS
                    break;
                case 7:
                    next = new Position(row - 2, col + 1);//WN
                    break;
            }
            return next;
        }
    }
}
