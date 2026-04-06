package lab_2.problem_2;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         JAVA CONSOLE CHESS           ║");
        System.out.println("║  Enter moves as: e2 e4  or  e2e4     ║");
        System.out.println("║  'board' = redraw, 'quit' = exit     ║");
        System.out.println("╚══════════════════════════════════════╝");

        Board board = new Board();
        board.draw();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print((board.isWhiteTurn() ? "White" : "Black") + " > ");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.isEmpty()) continue;

            if (line.equals("quit") || line.equals("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            if (line.equals("board")) {
                board.draw();
                continue;
            }
            String from, to;
            if (line.length() == 4) {
                from = line.substring(0, 2);
                to   = line.substring(2, 4);
            } else if (line.length() == 5 && line.charAt(2) == ' ') {
                from = line.substring(0, 2);
                to   = line.substring(3, 5);
            } else {
                System.out.println("  Invalid format. Try: e2 e4");
                continue;
            }

            Position fromPos, toPos;
            try {
                fromPos = Position.fromAlgebraic(from);
                toPos   = Position.fromAlgebraic(to);
            } catch (IllegalArgumentException e) {
                System.out.println("  Invalid position: " + e.getMessage());
                continue;
            }

            boolean ok = board.move(fromPos, toPos);
            if (ok) {
                board.draw();
                if (board.isCheckmate(board.isWhiteTurn())) {
                    System.out.println("Game over.");
                    break;
                }
            }
        }

        scanner.close();
    }
}