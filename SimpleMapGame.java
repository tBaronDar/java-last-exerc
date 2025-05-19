import java.util.Random;
import java.util.Scanner;

public class SimpleMapGame {

    // Διαστάσεις του χάρτη
    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;

    // Χαρακτήρες απεικόνισης
    public static final char EMPTY = '.';
    public static final char PLAYER = 'A';
    public static final char ITEM = '!';

    // Συντεταγμένες του παίκτη και του αντικειμένου
    public static int playerX, playerY;
    public static int itemX, itemY;

    public static void main(String[] args) {
        char[][] map = new char[HEIGHT][WIDTH];
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Αρχικοποίηση του χάρτη με τελείες
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                map[row][col] = EMPTY;
            }
        }

        // Τοποθέτηση του αντικειμένου σε τυχαία θέση
        itemX = rand.nextInt(WIDTH);
        itemY = rand.nextInt(HEIGHT);
        map[itemY][itemX] = ITEM;

        // Τοποθέτηση του παίκτη σε άλλη τυχαία θέση (να μην είναι ίδια με το αντικείμενο)
        do {
            playerX = rand.nextInt(WIDTH);
            playerY = rand.nextInt(HEIGHT);
        } while (playerX == itemX && playerY == itemY);
        map[playerY][playerX] = PLAYER;

        // Κεντρικός βρόχος παιχνιδιού
        while (true) {
            // Εκκαθάριση οθόνης (ή τύπωμα κενών γραμμών)
            System.out.print("\033[H\033[2J");  // Προσπάθεια καθαρισμού οθόνης
            System.out.flush();
            // Εναλλακτικά σε σπάνιες περιπτώσεις που ο παραπάνω συνδυασμός δεν καθαρίζει την οθόνη
            // for (int i = 0; i < 40; i++) {
            //     System.out.println();
            // }

            // Εμφάνιση του χάρτη
            for (int row = 0; row < HEIGHT; row++) {
                for (int col = 0; col < WIDTH; col++) {
                    System.out.print(map[row][col]);
                }
                System.out.println();
            }

            // Έλεγχος για τερματισμό (αν ο παίκτης έφτασε στο αντικείμενο)
            if (playerX == itemX && playerY == itemY) {
                System.out.println("Συγχαρητήρια! Βρήκατε το αντικείμενο!");
                break;
            }

            // Λήψη εντολής από τον παίκτη
            System.out.print("Κίνηση (w/a/s/d): ");
            String input = scanner.nextLine();
            if (input.length() == 0) continue;
            char move = input.charAt(0);

            // Ενημέρωση θέσης παίκτη μόνο αν δεν βγαίνει εκτός ορίων
            int newX = playerX;
            int newY = playerY;
            switch (move) {
                case 'w': newY--; break;
                case 's': newY++; break;
                case 'a': newX--; break;
                case 'd': newX++; break;
                default: continue;
            }

            if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                // Αφαίρεση προηγούμενου παίκτη
                map[playerY][playerX] = EMPTY;

                playerX = newX;
                playerY = newY;

                // Αν δεν πατήθηκε το αντικείμενο, εμφανίζεται ξανά ο παίκτης
                if (playerX != itemX || playerY != itemY) {
                    map[playerY][playerX] = PLAYER;
                }
            }
        }

        scanner.close();
    }
}