package fr.isima.chronometre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Chronometre {

    @Id
    @GeneratedValue
    long id;

    Date debut;

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public long getTime(){ return new Date().getTime() - debut.getTime(); }

    public long getId() {
        return id;
    }
}
