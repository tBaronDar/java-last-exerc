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
//    public void operate() {
//        System.out.println("Το μηχάνημα " + name + " λειτούργησε για 8 ώρες.");
//    }

    // TODO: Ορίστε την αφηρημένη μέθοδο operate που δέχεται όρισμα ώρες
    // public abstract ...
   abstract public void operate(int hours) ;
}

// TODO: Ορίστε την απόγονο κλάση Vehicle που επεκτείνει την Machinery
// και υλοποιεί τη μέθοδο operate(int hours)

class Vehicle extends Machinery {
    public Vehicle(String name, double weight) {
        super(name, weight);
    }
    public void operate(int hours){
        System.out.println("Το μηχάνημα " + name +" "+weight +"(KG) λειτούργησε για "+hours+" ώρες.\n");
    }
}


// TODO: Ορίστε την απόγονο κλάση Computer που επεκτείνει την Machinery
// Η μέθοδος operate(int hours) να καλεί την operate() της Machinery
// και να εκτυπώνει και το δικό της μήνυμα
class Computer extends Machinery {
    public Computer(String name, double weight) {
        super(name, weight);
    }
    public void operate(int hours){
        System.out.println("Το μηχάνημα " + name +" "+weight +"(KG) λειτούργησε για "+hours+" ώρες.\n");
    }
}

// Άσκηση 2 – Πολυμορφισμός και υπερφόρτωση μεθόδων

class Person {
    protected String name;
    public Person(String name) {
        this.name = name;
    }
    // TODO: Ορίστε τη μέθοδο workOn(Machinery m)
    // που εκτυπώνει ένα γενικό μήνυμα και καλεί την operate(int) του Machinery
    public void workOn(Machinery m){
        System.out.println(name+" works on... ");
        m.operate(6);
    }

    // TODO: Ορίστε τη μέθοδο workOn(Vehicle v)
    // που εκτυπώνει ότι ο άνθρωπος δουλεύει πάνω σε όχημα
    public void workOn(Vehicle v){
        v.operate(1);
    }
}


class Technician extends Person {

    public Technician(String name) {
        super(name);
    }

    // TODO: Κάντε override της μεθόδου workOn(Machinery m)
    // με πιο εξειδικευμένο μήνυμα
    public void workOn(Machinery m){
        System.out.println("Technician "+name+" works on Machinery ");
        m.operate(2);
    }

    // TODO: Ορίστε επιπλέον μέθοδο workOn(Computer c)
    // που καλεί την operate(int) του υπολογιστή
    public void workOn(Computer c){
        System.out.println("Technician works on Computer "+name+" ");
        c.operate(3);
    }
}


public class Workshop {
    public static void main(String[] args) {

        // TODO: Δημιουργήστε αντικείμενα Vehicle και Computer
        // π.χ. Machinery v = new Vehicle(...); Machinery c = new Computer(...);
        Machinery m1 =new Computer("Laptop", 3);
        Machinery m2 =new Vehicle("Kombina", 89);
        Machinery m3 =new Vehicle("PC", 6);

        // TODO: Δημιουργήστε αντικείμενο Technician
        // π.χ. Technician tech = new Technician("Όνομα");
        Technician tech1 = new Technician("Mitsos");
        Technician tech2 = new Technician("Gionis");
        Technician tech3 = new Technician("Yiorikas");

        // TODO: Καλέστε τις μεθόδους workOn με διαφορετικά είδη παραμέτρων
        // π.χ. tech.workOn(v); tech.workOn(c);
        tech1.workOn(m1);
        tech2.workOn(m2);
        tech3.workOn(m3);
        tech1.workOn(m2);

        // TODO: Δημιουργήστε και αντικείμενο Person και καλέστε τις ίδιες μεθόδους
        Person person1 = new Person("Aleka");
        Person person2 = new Person("Makis");
        Person person3 = new Person("Gianna");

        person1.workOn(m1);
        person2.workOn(m2);
        person3.workOn(m1);
    }
}
