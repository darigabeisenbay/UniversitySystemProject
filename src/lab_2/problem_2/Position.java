package lab_2.problem_2;

public class Position {
    public final int col;
    public final int row;

    public Position(int col, int row) {
        if (col < 0 || col > 7 || row < 0 || row > 7)
            throw new IllegalArgumentException("Position out of bounds: col=" + col + " row=" + row);
        this.col = col;
        this.row = row;
    }

    public static Position fromAlgebraic(String s) {
        if (s == null || s.length() != 2) throw new IllegalArgumentException("Invalid: " + s);
        int col = s.charAt(0) - 'a';
        int row = s.charAt(1) - '1';
        return new Position(col, row);
    }

    public String toAlgebraic() {
        return "" + (char)('a' + col) + (char)('1' + row);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return col == p.col && row == p.row;
    }

    @Override
    public int hashCode() { return row * 8 + col; }

    @Override
    public String toString() { return toAlgebraic(); }
}