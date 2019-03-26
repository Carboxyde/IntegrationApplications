package fr.isima.chronometre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Minuteur {

    @Id
    @GeneratedValue
    long id;

    Date fin;

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public long getRemainingTime(){
        return fin.getTime() - new Date().getTime();
    }

    public long getId() {
        return id;
    }
}
