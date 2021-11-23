package com.example.td5;

public class Contact {
    private String nom;
    private String prenom;
    private String imageUrl;

    public Contact(String prenom, String nom, String imageUrl) {
        this.prenom = prenom;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
