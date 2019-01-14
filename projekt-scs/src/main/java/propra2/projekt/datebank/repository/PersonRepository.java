package propra2.projekt.datebank.repository;

import org.springframework.data.repository.CrudRepository;
import propra2.projekt.datebank.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
