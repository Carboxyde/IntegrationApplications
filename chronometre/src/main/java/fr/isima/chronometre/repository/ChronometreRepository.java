package fr.isima.chronometre.repository;

import fr.isima.chronometre.model.Chronometre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChronometreRepository extends CrudRepository<Chronometre, Long> {

}
