import java.util.ArrayList;

public class Studente extends Persona{
    ArrayList<Double> voti;

    public Studente(String cognome, String nome) {
        super(cognome, nome);
        voti = new ArrayList<>();
    } 
    
    public double getMedia(){
        double media = 0;
        for (Double v : voti)
            media += v;
        return media/voti.size();
    }

    public void addVoto(Double voto){
        voti.add(voto);
    }

    public String toString(){
        return super.toString() + String.format(", media: %.2f",getMedia());
    }
}
