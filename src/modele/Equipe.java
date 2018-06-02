package modele;

public class Equipe {
    private int id;
    private String nomEquipe;
    private String pays;



    // CONSTRUCTEUR
    public Equipe(int id, String nomEquipe, String pays) {
        this.nomEquipe = nomEquipe;
    }

    //ACCESSEURS
    public String getNomEquipe() {
        return nomEquipe;
    }

    //SETTERS
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

}
