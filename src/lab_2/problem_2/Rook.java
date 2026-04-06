package lab_2.problem_2;


public class Rook extends Piece {

    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;
        return position.col == b.col || position.row == b.row;
    }

    @Override
    public char getSymbol() { return isWhite ? 'R' : 'r'; }
}
