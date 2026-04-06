package lab_2.problem_2;


public class King extends Piece {

    public King(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;
        return dc(b) <= 1 && dr(b) <= 1;
    }

    @Override
    public char getSymbol() { return isWhite ? 'K' : 'k'; }
}

