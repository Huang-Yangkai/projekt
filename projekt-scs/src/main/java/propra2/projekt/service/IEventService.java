package propra2.projekt.service;

import propra2.projekt.datebank.model.Event;
import propra2.projekt.datebank.model.Person;

import java.util.List;

public interface IEventService {
    List<Person> getPersonList();
    void AddDeleteId(Long id);
    void AddNewId(Long id);
    void AddEditId(Long id);
    void getAllPersonEvent();
    List<Event> findAllEvents();
}
