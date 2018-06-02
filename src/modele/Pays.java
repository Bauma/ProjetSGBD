package modele;

public class Pays {

    private int id;
    private String nomPays;


        // CONSTRUCTEUR
        public Pays(int id, String nomPays) {
            this.id = id;
            this.nomPays = nomPays;
        }

        //ACCESSEURS
        public String getNomPays() {
            return nomPays;
        }

        //SETTERS
        public void setNomPays(String nomPays) {
            this.nomPays = nomPays;
        }

    }


