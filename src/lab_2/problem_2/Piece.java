package lab_2.problem_2;

import lab_2.problem_2.Position;

public abstract class Piece {

    protected Position position;
    protected boolean isWhite;
    public Piece(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite  = isWhite;
    }
    public abstract boolean isLegalMove(Position b);

    public abstract char getSymbol();

    protected int dc(Position b) { return Math.abs(b.col - position.col); }
    protected int dr(Position b) { return Math.abs(b.row - position.row); }

    public Position getPosition()          { return position; }
    public void     setPosition(Position p){ this.position = p; }
    public boolean  isWhite()              { return isWhite; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + position + "," + (isWhite ? "W" : "B") + ")";
    }
}
