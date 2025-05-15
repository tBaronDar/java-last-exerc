// Άσκηση 1 – Κληρονομικότητα και επικάλυψη μεθόδων

abstract class Machinery {
    protected String name;
    protected double weight;

    public Machinery(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    // Default λειτουργία για 8 ώρες
    public void operate() {
        System.out.println("Το μηχάνημα " + name + " λειτούργησε για 8 ώρες.");
    }

    // TODO: Ορίστε την αφηρημένη μέθοδο operate που δέχεται όρισμα ώρες
    // public abstract ...
}

// TODO: Ορίστε την απόγονο κλάση Vehicle που επεκτείνει την Machinery
// και υλοποιεί τη μέθοδο operate(int hours)


// TODO: Ορίστε την απόγονο κλάση Computer που επεκτείνει την Machinery
// Η μέθοδος operate(int hours) να καλεί την operate() της Machinery
// και να εκτυπώνει και το δικό της μήνυμα


// Άσκηση 2 – Πολυμορφισμός και υπερφόρτωση μεθόδων

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    // TODO: Ορίστε τη μέθοδο workOn(Machinery m)
    // που εκτυπώνει ένα γενικό μήνυμα και καλεί την operate(int) του Machinery

    // TODO: Ορίστε τη μέθοδο workOn(Vehicle v)
    // που εκτυπώνει ότι ο άνθρωπος δουλεύει πάνω σε όχημα
}


class Technician extends Person {

    public Technician(String name) {
        super(name);
    }

    // TODO: Κάντε override της μεθόδου workOn(Machinery m)
    // με πιο εξειδικευμένο μήνυμα

    // TODO: Ορίστε επιπλέον μέθοδο workOn(Computer c)
    // που καλεί την operate(int) του υπολογιστή
}


public class Workshop {
    public static void main(String[] args) {

        // TODO: Δημιουργήστε αντικείμενα Vehicle και Computer
        // π.χ. Machinery v = new Vehicle(...); Machinery c = new Computer(...);

        // TODO: Δημιουργήστε αντικείμενο Technician
        // π.χ. Technician tech = new Technician("Όνομα");

        // TODO: Καλέστε τις μεθόδους workOn με διαφορετικά είδη παραμέτρων
        // π.χ. tech.workOn(v); tech.workOn(c);

        // TODO: Δημιουργήστε και αντικείμενο Person και καλέστε τις ίδιες μεθόδους
    }
}
