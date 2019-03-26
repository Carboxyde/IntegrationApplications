package fr.isima.chronometre.repository;

import fr.isima.chronometre.model.Minuteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinuteurRepository extends CrudRepository<Minuteur, Long> {

}
