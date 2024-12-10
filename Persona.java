class Persona implements Comparable<Persona>{
    private String cognome;
    private String nome;

    public Persona(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

    public String toString(){
        return String.format("%s %s",cognome,nome);
    }

    public int compareTo(Persona p){
        return this.cognome.compareTo(p.cognome);
    }
}