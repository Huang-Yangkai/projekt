package propra2.projekt.datebank.repository;

import org.springframework.data.repository.CrudRepository;
import propra2.projekt.datebank.model.Projekt;

public interface PersonRepository extends CrudRepository<Projekt, Long> {

}
