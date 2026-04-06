package lab_2.problem_2;


public class Pawn extends Piece {

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean isLegalMove(Position b) {
        if (b.equals(position)) return false;

        int direction  = isWhite ? 1 : -1;
        int startRank  = isWhite ? 1 : 6;
        int rowDiff    = b.row - position.row;
        int colDiff    = Math.abs(b.col - position.col);

        if (colDiff == 0) {
            if (rowDiff == direction) return true;
            if (rowDiff == 2 * direction && position.row == startRank) return true;
        }
        if (colDiff == 1 && rowDiff == direction) return true;

        return false;
    }

    @Override
    public char getSymbol() { return isWhite ? 'P' : 'p'; }
}

