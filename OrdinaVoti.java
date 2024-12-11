import java.util.Comparator;

public class OrdinaVoti implements Comparator<Studente> {
    public int compare(Studente s1, Studente s2){
        if (s1.getMedia()<s2.getMedia())
            return -1;
        else if (s1.getMedia()>s2.getMedia())
            return 1;
        else
            return 0;
    }
}
