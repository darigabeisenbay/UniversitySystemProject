package lab_2.problem_2;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] grid = new Piece[8][8];
    private boolean whiteTurn = true;
    public Board() {
        setupStartingPosition();
    }

    private void setupStartingPosition() {
        placePiece(new Rook  (new Position(0, 0), true));
        placePiece(new Knight(new Position(1, 0), true));
        placePiece(new Bishop(new Position(2, 0), true));
        placePiece(new Queen (new Position(3, 0), true));
        placePiece(new King  (new Position(4, 0), true));
        placePiece(new Bishop(new Position(5, 0), true));
        placePiece(new Knight(new Position(6, 0), true));
        placePiece(new Rook  (new Position(7, 0), true));
        for (int c = 0; c < 8; c++)
            placePiece(new Pawn(new Position(c, 1), true));

        placePiece(new Rook  (new Position(0, 7), false));
        placePiece(new Knight(new Position(1, 7), false));
        placePiece(new Bishop(new Position(2, 7), false));
        placePiece(new Queen (new Position(3, 7), false));
        placePiece(new King  (new Position(4, 7), false));
        placePiece(new Bishop(new Position(5, 7), false));
        placePiece(new Knight(new Position(6, 7), false));
        placePiece(new Rook  (new Position(7, 7), false));
        for (int c = 0; c < 8; c++)
            placePiece(new Pawn(new Position(c, 6), false));
    }

    private void placePiece(Piece p) {
        Position pos = p.getPosition();
        grid[pos.col][pos.row] = p;
    }

    public boolean move(Position from, Position to) {
        Piece piece = getPiece(from);

        if (piece == null) {
            System.out.println("  No piece at " + from);
            return false;
        }
        if (piece.isWhite() != whiteTurn) {
            System.out.println("  It is " + (whiteTurn ? "White" : "Black") + "'s turn.");
            return false;
        }
        if (!piece.isLegalMove(to)) {
            System.out.println("  Illegal move shape for " + piece.getClass().getSimpleName());
            return false;
        }

        Piece target = getPiece(to);
        if (target != null && target.isWhite() == whiteTurn) {
            System.out.println("  Cannot capture your own piece.");
            return false;
        }

        if (!(piece instanceof Knight) && isPathBlocked(from, to)) {
            System.out.println("  Path is blocked.");
            return false;
        }

        if (piece instanceof Pawn) {
            boolean isDiagonal = Math.abs(to.col - from.col) == 1;
            if (!isDiagonal && target != null) {
                System.out.println("  Pawn cannot capture forward.");
                return false;
            }
            if (isDiagonal && target == null) {
                System.out.println("  Pawn can only capture diagonally when there is an enemy piece.");
                return false;
            }
        }
        applyMove(piece, from, to);
        if (isInCheck(whiteTurn)) {
            applyMove(piece, to, from);
            grid[to.col][to.row] = target;
            if (target != null) target.setPosition(to);
            System.out.println("  Move would leave your King in check!");
            return false;
        }
        if (piece instanceof Pawn) {
            int promotionRow = whiteTurn ? 7 : 0;
            if (to.row == promotionRow) {
                grid[to.col][to.row] = new Queen(to, whiteTurn);
                System.out.println("  Pawn promoted to Queen!");
            }
        }

        whiteTurn = !whiteTurn;

        if (isInCheck(!whiteTurn)) {
            if (isCheckmate(whiteTurn)) {
                System.out.println("  CHECKMATE! " + (!whiteTurn ? "White" : "Black") + " wins!");
            } else {
                System.out.println("  CHECK!");
            }
        }

        return true;
    }
    private void applyMove(Piece piece, Position from, Position to) {
        grid[from.col][from.row] = null;
        grid[to.col][to.row]     = piece;
        piece.setPosition(to);
    }
    private boolean isPathBlocked(Position from, Position to) {
        int dc = Integer.signum(to.col - from.col);
        int dr = Integer.signum(to.row - from.row);
        int c  = from.col + dc;
        int r  = from.row + dr;
        while (c != to.col || r != to.row) {
            if (grid[c][r] != null) return true;
            c += dc;
            r += dr;
        }
        return false;
    }

    public boolean isInCheck(boolean kingIsWhite) {
        Position kingPos = findKing(kingIsWhite);
        if (kingPos == null) return false;
        for (int c = 0; c < 8; c++)
            for (int r = 0; r < 8; r++) {
                Piece p = grid[c][r];
                if (p != null && p.isWhite() != kingIsWhite && p.isLegalMove(kingPos))
                    if (!(p instanceof Knight) ? !isPathBlocked(p.getPosition(), kingPos) : true)
                        return true;
            }
        return false;
    }

    private Position findKing(boolean isWhite) {
        for (int c = 0; c < 8; c++)
            for (int r = 0; r < 8; r++) {
                Piece p = grid[c][r];
                if (p instanceof King && p.isWhite() == isWhite)
                    return new Position(c, r);
            }
        return null;
    }


    public boolean isCheckmate(boolean forWhite) {
        if (!isInCheck(forWhite)) return false;
        for (int fc = 0; fc < 8; fc++)
            for (int fr = 0; fr < 8; fr++) {
                Piece p = grid[fc][fr];
                if (p == null || p.isWhite() != forWhite) continue;
                Position from = new Position(fc, fr);
                for (int tc = 0; tc < 8; tc++)
                    for (int tr = 0; tr < 8; tr++) {
                        Position to = new Position(tc, tr);
                        if (!p.isLegalMove(to)) continue;
                        Piece captured = grid[tc][tr];
                        if (captured != null && captured.isWhite() == forWhite) continue;
                        if (p instanceof Knight || !isPathBlocked(from, to)) {
                            grid[fc][fr] = null;
                            grid[tc][tr] = p;
                            p.setPosition(to);
                            boolean stillInCheck = isInCheck(forWhite);
                            grid[fc][fr] = p;
                            grid[tc][tr] = captured;
                            p.setPosition(from);
                            if (captured != null) captured.setPosition(to);
                            if (!stillInCheck) return false;
                        }
                    }
            }
        return true;
    }
    public void draw() {
        System.out.println();
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int r = 7; r >= 0; r--) {
            System.out.print((r + 1) + " |");
            for (int c = 0; c < 8; c++) {
                Piece p = grid[c][r];
                char bg = ((c + r) % 2 == 0) ? '.' : ' ';
                if (p == null) {
                    System.out.print(" " + bg + " |");
                } else {
                    System.out.print(" " + p.getSymbol() + " |");
                }
            }
            System.out.println(" " + (r + 1));
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println("  (uppercase=White, lowercase=Black)");
        System.out.println("  Turn: " + (whiteTurn ? "White" : "Black"));
        System.out.println();
    }

    public Piece getPiece(Position pos) { return grid[pos.col][pos.row]; }
    public boolean isWhiteTurn()        { return whiteTurn; }
}
