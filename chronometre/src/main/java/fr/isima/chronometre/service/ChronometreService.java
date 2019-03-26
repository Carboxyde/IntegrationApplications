package fr.isima.chronometre.service;

import fr.isima.chronometre.model.Chronometre;
import fr.isima.chronometre.repository.ChronometreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChronometreService {

    @Autowired
    ChronometreRepository chronometreRepository;

    public Chronometre saveOrUpdate(Chronometre chronometre){
        chronometreRepository.save(chronometre);
        return chronometre;
    }
    public Chronometre getChronometreById(long id){
        return chronometreRepository.findById(id).get();
    }
}
