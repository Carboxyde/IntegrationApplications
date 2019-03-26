package fr.isima.chronometre.service;

import fr.isima.chronometre.model.Minuteur;
import fr.isima.chronometre.repository.MinuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinuteurService {

    @Autowired
    MinuteurRepository minuteurRepository;

    public Minuteur saveOrUpdate(Minuteur minuteur){
        minuteurRepository.save(minuteur);
        return minuteur;
    }
    public Minuteur getMinuteurById(long id){
        return minuteurRepository.findById(id).get();
    }
}
