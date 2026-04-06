package lab_2.problem_2;


public class Queen extends Piece {

    public Queen(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;
        return position.col == b.col
                || position.row == b.row
                || dc(b) == dr(b);
    }

    @Override
    public char getSymbol() { return isWhite ? 'Q' : 'q'; }
}
