import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Classe {
    private List<Persona> studenti;

    public Classe() {
        studenti = new ArrayList<>();
        leggiDati();
    }

    private void leggiDati() {
        try (Scanner scanner = new Scanner(new File("persone.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String cognome = parts[0];
                String nome = parts[1];
                Persona persona = new Studente(cognome, nome);
                for (int i = 2; i < parts.length; i++) {
                    double voto = Double.parseDouble(parts[i]);
                    ((Studente) persona).addVoto(voto);
                }
                studenti.add(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }
    }

    public void stampaElenco() {
        Collections.sort(studenti);
        System.out.println("--------------------------------------");
        System.out.println("Elenco studenti:");
        System.out.println("--------------------------------------");
        for (Persona p : studenti) {
            System.out.println(p);
        }
    }

    public void stampaMedie() {
        List<Studente> stud = new ArrayList<>();
        for (Persona p : studenti) {
            if (p instanceof Studente) {
                stud.add((Studente) p);
            }
        }
        stud.sort(new OrdinaVoti());
        System.out.println("--------------------------------------");
        System.out.println("Elenco studenti ordinati per media:");
        System.out.println("--------------------------------------");
        for (Studente s : stud) {
            System.out.println(s);
        }
    }
}
