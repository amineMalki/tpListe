package models;

public class Item {
    private int id;
    private String nom;
    private String etat;

    public Item() {
    }

    public Item(String nom) {
        this.nom = nom;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Item{" +
                " ; " + nom + '\'' +
                '}';
    }
}
