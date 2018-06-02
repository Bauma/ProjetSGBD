package modele;


public class Membre {
    private int id;
    private String nomMembre;
    private String pays;


    // CONSTRUCTEUR
    public Membre(int id, String nomMembre, String pays) {
        this.nomMembre = nomMembre;
        this.id = id;
        this.pays = pays;
    }

    //ACCESSEURS
    public String getNomMembre() {
        return nomMembre;
    }

    //SETTERS
    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

}
