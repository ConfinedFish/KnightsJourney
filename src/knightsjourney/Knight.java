package knightsjourney;

import java.util.Iterator;

public class Knight implements Application{
    private static byte moves;
    private int gridX, gridY;
    private Position start;
    private byte[][] grid;

    public Knight(int col, int row, Position start) {
        this.gridX = col;
        this.gridY = row;
        this.start = start;
        this.grid = new byte[col][row];
        grid[start.getColumn()][start.getRow()] = -1;
        moves = 0;
    }
    
    Position getStart() {
        return start;
    }
    public byte getMoves(){
        return moves;
    }
    @Override
    public boolean isOK(Position pos) {
        return pos.getColumn() >= 0 && pos.getColumn() < grid.length && pos.getRow() >= 0 && pos.getRow() < grid[0].length && grid[pos.getColumn()][pos.getRow()] == 0;
    }

    @Override
    public void markAsPossible(Position pos) {
        grid [pos.getColumn()][pos.getRow()] = moves;
        moves++;
    }

    @Override
    public boolean isGoal(Position pos) {
        return moves == gridX * gridY;
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        grid[pos.getColumn()][pos.getRow()] = 0;
        moves--;
    }

    @Override
    public Iterator<Position> iterator(Position pos) {
        return new KnightIterator(pos, this);
    }
    protected class KnightIterator implements Iterator<Position>{
        static final int MAX = 8;
        int row, col, count;
        Knight knight;
        KnightIterator(Position position, Knight knight){
            this.row = position.getRow();
            this.col = position.getColumn();
            this.count = 0;
            this.knight = knight;
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
                    break;
            }
            System.out.println(count);
            System.out.print(knight.printGrid() + "\n");
            return next;
        }
    }
    String printGrid(){
        StringBuilder builder = new StringBuilder();
        for (byte[] grid : grid) {
            for (int j = 0; j < this.grid[0].length; j++) {
                String color = "\u001B[37m";
                if (grid[j] != 0){
                    color = "\u001B[31m";
                }
                if(grid[j] == -1){
                    color = "\u001B[36m";
                }
                if (grid[j] == 0){
                    color = "\u001B[35m";
                }
                builder.append("[").append(color).append(grid[j]).append("\u001B[37m").append("] ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
