package models;

import java.util.List;

public class ListeItems {

    private String nom;
    private List<Item> items;

    public ListeItems() {
    }

    public ListeItems(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListeItems{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
