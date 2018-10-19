package knightsjourney;

import java.util.Iterator;

public class Knight implements Application{
    private int gridx,gridy;
    private Position start;

    public Knight(int gridx, int gridy, Position start) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.start = start;
    }
    
    public Position getStart() {
        return start;
    }
    
    
    @Override
    public boolean isOK(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void markAsPossible(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isGoal(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position> iterator(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
