package propra2.projekt.datebank.repository;

import org.springframework.data.repository.CrudRepository;
import propra2.projekt.datebank.model.Event;
import propra2.projekt.datebank.model.PersonEvent;

public interface PersonEventRepository extends CrudRepository<PersonEvent, Long> {

}
