package ruben.net;

public class animal {
    int id;
    String nom;
    String especie;
    String aliment;
    int edat;
    
    public animal(int id, String nom, String especie, String aliment, int edat) {
        this.id = id;
        this.nom = nom;
        this.especie = especie;
        this.aliment = aliment;
        this.edat = edat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getAliment() {
        return aliment;
    }

    public void setAliment(String aliment) {
        this.aliment = aliment;
    }

    public int getedat() {
        return edat;
    }

    public void setedat(int edat) {
        this.edat = edat;
    }

    

}
