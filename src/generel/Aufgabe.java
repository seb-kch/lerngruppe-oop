package generel;

public class Aufgabe {
    private Thread t;
    private String name;
    public Aufgabe(String name, AufgabenMethode method) {
        this.name = name;
            this.t = new Thread(() -> {
                method.run();
            });


    }

    public void execute() {
        t.start();
        System.out.println("Running Aufgabe: " + name);
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aufgabe: " + name + " ends.");
    }

}
