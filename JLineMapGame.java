import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class JLineMapGame {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;
    public static final char EMPTY = '.';
    public static final char PLAYER = 'A';
    public static final char ITEM = '!';

    public static int playerX, playerY;
    public static int itemX, itemY;

    public static void main(String[] args) throws IOException {
        char[][] map = new char[HEIGHT][WIDTH];

        // Αρχικοποίηση χάρτη
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                map[row][col] = EMPTY;
            }
        }

        // Τυχαία τοποθέτηση αντικειμένου
        itemX = (int) (Math.random() * WIDTH);
        itemY = (int) (Math.random() * HEIGHT);
        map[itemY][itemX] = ITEM;

        // Τυχαία τοποθέτηση παίκτη (όχι ίδια θέση με το αντικείμενο)
        do {
            playerX = (int) (Math.random() * WIDTH);
            playerY = (int) (Math.random() * HEIGHT);
        } while (playerX == itemX && playerY == itemY);
        map[playerY][playerX] = PLAYER;

        // Εκκίνηση terminal JLine
        Terminal terminal = TerminalBuilder.builder()
                .jna(true)
                .system(true)
                .build();

        terminal.enterRawMode();

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            printMap(map);

            if (playerX == itemX && playerY == itemY) {
                System.out.println("Συγχαρητήρια! Βρήκατε το αντικείμενο!");
                break;
            }

            int key = terminal.reader().read();

            map[playerY][playerX] = EMPTY;

            switch (key) {
                case 'w': if (playerY > 0) playerY--; break;
                case 's': if (playerY < HEIGHT - 1) playerY++; break;
                case 'a': if (playerX > 0) playerX--; break;
                case 'd': if (playerX < WIDTH - 1) playerX++; break;
                case 'q': System.out.println("Έξοδος..."); return;
            }

            if (playerX != itemX || playerY != itemY) {
                map[playerY][playerX] = PLAYER;
            }

        }

        terminal.close();
    }

    private static void printMap(char[][] map) {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
        System.out.println("\nΠατήστε w/a/s/d για να κινηθείτε ή q για έξοδο.");
    }
}