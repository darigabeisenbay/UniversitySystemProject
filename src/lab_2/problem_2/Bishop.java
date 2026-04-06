package lab_2.problem_2;


public class Bishop extends Piece {

    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;
        return dc(b) == dr(b);
    }

    @Override
    public char getSymbol() { return isWhite ? 'B' : 'b'; }
}

