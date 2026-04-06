package lab_2.problem_2;

public class TestChess {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("=== Chess Piece Move Tests ===\n");

        testRook();
        testKing();
        testQueen();
        testBishop();
        testKnight();
        testPawn();
        testPolymorphism();

        System.out.println("\n=== Results: " + passed + " passed, " + failed + " failed ===");
    }

    static void testRook() {
        System.out.println("-- Rook --");
        Rook r = new Rook(new Position(3, 3), true);
        check("Rook horizontal right",  r, "g4",  true);
        check("Rook horizontal left",   r, "a4",  true);
        check("Rook vertical up",        r, "d8",  true);
        check("Rook vertical down",      r, "d1",  true);
        check("Rook diagonal (illegal)", r, "f6",  false);
        check("Rook stay (illegal)",     r, "d4",  false);
    }

    static void testKing() {
        System.out.println("\n-- King --");
        King k = new King(new Position(4, 4), true);
        check("King one step right",    k, "f5",  true);
        check("King diagonal step",     k, "f6",  true);
        check("King two squares (illegal)", k, "g5", false);
        check("King stay (illegal)",    k, "e5",  false);
    }

    static void testQueen() {
        System.out.println("\n-- Queen --");
        Queen q = new Queen(new Position(3, 3), true);
        check("Queen horizontal",       q, "h4",  true);
        check("Queen vertical",         q, "d8",  true);
        check("Queen diagonal",         q, "g7",  true);
        check("Queen knight-hop (illegal)", q, "e5", false);
    }

    static void testBishop() {
        System.out.println("\n-- Bishop --");
        Bishop b = new Bishop(new Position(2, 0), true);
        check("Bishop diagonal up-right",  b, "g5", true);
        check("Bishop diagonal up-left",   b, "a3", true);
        check("Bishop straight (illegal)", b, "c5", false);
        check("Bishop knight-hop (illegal)", b, "d2", false);
    }

    static void testKnight() {
        System.out.println("\n-- Knight --");
        Knight n = new Knight(new Position(4, 4), true);
        check("Knight 2+1 up-right",    n, "f7",  true);
        check("Knight 1+2 right-down",  n, "g4",  false);
        check("Knight 2+1 up-right (g6)", n, "g6", true);
        check("Knight diagonal (illegal)", n, "g7", false);
        check("Knight straight (illegal)", n, "e7", false);
    }

    static void testPawn() {
        System.out.println("\n-- Pawn --");
        Pawn wp = new Pawn(new Position(4, 1), true);
        check("White pawn one forward",      wp, "e3",  true);
        check("White pawn two from start",   wp, "e4",  true);
        check("White pawn diagonal capture", wp, "f3",  true);
        check("White pawn backward (illegal)", wp, "e1", false);
        check("White pawn two not on start row", 
              new Pawn(new Position(4, 3), true), "e6",  false);

        Pawn bp = new Pawn(new Position(3, 6), false);
        check("Black pawn one forward (down)", bp, "d6", true);
        check("Black pawn two from start",     bp, "d5", true);
        check("Black pawn diagonal capture",   bp, "c6", true);
        check("Black pawn upward (illegal)",   bp, "d7", false);
    }

    static void testPolymorphism() {
        System.out.println("\n-- Polymorphism demo (same call, different pieces) --");
        Piece[] pieces = {
            new Rook  (new Position(0, 0), true),
            new Bishop(new Position(0, 0), true),
            new Queen (new Position(0, 0), true),
            new Knight(new Position(0, 0), true),
            new King  (new Position(0, 0), true),
            new Pawn  (new Position(0, 1), true)
        };
        Position target = new Position(2, 2);
        System.out.printf("  Can each piece reach %s from a1?%n", target);
        for (Piece p : pieces) {
            System.out.printf("    %-8s isLegalMove(%s) = %s%n",
                p.getClass().getSimpleName(), target, p.isLegalMove(target));
        }
    }

    static void check(String label, Piece piece, String target, boolean expected) {
        Position to = Position.fromAlgebraic(target);
        boolean result = piece.isLegalMove(to);
        boolean ok = result == expected;
        System.out.printf("  [%s] %s → %s : isLegalMove=%s (expected %s)%n",
            ok ? "PASS" : "FAIL", label, target, result, expected);
        if (ok) passed++; else failed++;
    }
}