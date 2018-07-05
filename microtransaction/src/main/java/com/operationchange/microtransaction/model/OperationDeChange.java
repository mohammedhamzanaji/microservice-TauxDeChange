package com.operationchange.microtransaction.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OperationDeChange {

    @Id             //Cle
    @GeneratedValue //auto-incrementation
    private int id;
    private String devise_source;
    private String devise_destination;
    private double montant;
    private String date;
    private double taux;

    //Constructors:

    public OperationDeChange(){}

    public OperationDeChange(int id, String devise_source, String devise_destination, double montant, String date, double taux) {
        this.id = id;
        this.devise_source = devise_source;
        this.devise_destination = devise_destination;
        this.montant = montant;
        this.date = date;
        this.taux = taux;
    }

    //Getter & Setter:

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDevise_source() { return devise_source; }

    public void setDevise_source(String devise_source) { this.devise_source = devise_source; }

    public String getDevise_destination() { return devise_destination; }

    public void setDevise_destination(String devise_destination) { this.devise_destination = devise_destination; }

    public double getMontant() { return montant; }

    public void setMontant(double montant) { this.montant = montant; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public double getTaux() { return taux; }

    public void setTaux(double taux) { this.taux = taux; }

    //Serialization:


    @Override
    public String toString() {
        return "OperationDeChange{" +
                "id=" + id +
                ", devise_source='" + devise_source + '\'' +
                ", devise_destination='" + devise_destination + '\'' +
                ", montant=" + montant +
                ", date='" + date + '\'' +
                ", taux=" + taux +
                '}';
    }
}
