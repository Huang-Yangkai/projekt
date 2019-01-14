package propra2.projekt.service;

import org.springframework.context.annotation.Bean;
import propra2.projekt.datebank.model.Event;

import java.util.List;

public interface IEventService {
    void AddDeleteId(Long id);
    void AddNewId(Long id);
    void AddEditId(Long id);
    List<Event> findAllEvents();
}
