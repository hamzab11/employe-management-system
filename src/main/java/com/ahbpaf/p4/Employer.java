package com.ahbpaf.p4;

import java.util.Date;

public class Employer {
    private String nom;
    private String prenom;
    private String matricule;
    private String Phone;
    private Date dateDentree;
    private Date dateDeSortie;
    private Date dateFinSortie;
    public enum  Position {}

    // constractor
    public Employer(String nom, String prenom, String phone, String matricule,Enum position) {
        this.nom = nom;
        this.prenom = prenom;
        this.Phone = phone;
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getDateDentree() {
        return dateDentree;
    }

    public void setDateDentree(Date dateDentree) {
        this.dateDentree = dateDentree;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public Date getDateFinSortie() {
        return dateFinSortie;
    }

    public void setDateFinSortie(Date dateFinSortie) {
        this.dateFinSortie = dateFinSortie;
    }
    public  Position getPosition() {
        return Position.valueOf(this.matricule);
    }
    public void setPosition(Position position) {
        this.matricule = position.toString();
    }
    public   String getPositionString() {
        return Position.valueOf(this.matricule).toString();
    }


}

