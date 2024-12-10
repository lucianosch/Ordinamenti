import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception{
        List<Persona> persone = new ArrayList<>();
        File f = new File("persone.txt");
        Scanner nomi = new Scanner(f);

        while(nomi.hasNextLine()){
            String temp = nomi.nextLine();
            String dati[] = temp.split(",");
            //System.out.println(dati[0]);
            persone.add(new Persona(dati[0],dati[1]));
        }
        nomi.close();

        for(Persona p: persone)
            System.out.println(p);

        System.out.println("-----------------------");
        Collections.sort(persone);

        for(Persona p: persone)
            System.out.println(p);
    }
}
