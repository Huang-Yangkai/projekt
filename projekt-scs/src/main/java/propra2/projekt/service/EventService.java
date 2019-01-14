package propra2.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propra2.projekt.datebank.model.Event;
import propra2.projekt.datebank.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void AddDeleteId(Long id) {
        Event event =  eventRepository.findById(id).get();
        event.setDeleted(true);
        eventRepository.save(event);
    }

    @Override
    public void AddNewId(Long id) {
        Event event = new Event();
        event.setNeu(true);
        eventRepository.save(event);
    }

    @Override
    public void AddEditId(Long id) {
        Event event = eventRepository.findById(id).get();
        event.setEdit(true);
        eventRepository.save(event);
    }

    @Override
    public List<Event> findAllEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(e -> events.add(e));
        return events;
    }
}
