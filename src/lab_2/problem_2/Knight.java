package lab_2.problem_2;


public class Knight extends Piece {

    public Knight(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;
        int dc = dc(b), dr = dr(b);
        return (dc == 2 && dr == 1) || (dc == 1 && dr == 2);
    }

    @Override
    public char getSymbol() { return isWhite ? 'N' : 'n'; }
}


