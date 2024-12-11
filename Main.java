import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException{
        //List<Persona> persone = new ArrayList<>();
        List<Studente> studenti = new ArrayList<>();
        File f = new File("persone.txt");
        Scanner nomi = new Scanner(f);

        while(nomi.hasNextLine()){
            String temp = nomi.nextLine(); //Leggo la riga
            String dati[] = temp.split(","); //Spacchetto la riga
            Studente nuovoStudente = new Studente(dati[0], dati[1]);
            //Istanzio un nuovo studente
            for (int i=2; i<dati.length; i++){
                //Converto ed aggiungo i voti
                double d = Double.parseDouble(dati[i]);
                nuovoStudente.addVoto(d);
            }
            //Aggiungo lo studente alla lista
            studenti.add(nuovoStudente);
        }
        nomi.close();

        for(Persona p: studenti)
            System.out.println(p);

        System.out.println("-----------------------");
        
        Collections.sort(studenti, Collections.reverseOrder(new OrdinaVoti()));

        for(Persona p: studenti)
            System.out.println(p);
    }
}
