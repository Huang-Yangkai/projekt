package propra2.projekt.datebank.repository;

import org.springframework.data.repository.CrudRepository;
import propra2.projekt.datebank.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
