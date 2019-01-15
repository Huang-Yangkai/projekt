package propra2.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import propra2.projekt.datebank.model.Event;
import propra2.projekt.datebank.model.Person;
import propra2.projekt.datebank.model.PersonEvent;
import propra2.projekt.datebank.repository.EventRepository;
import propra2.projekt.datebank.repository.PersonRepository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PersonRepository personRepository;

    private static <T> T getEntity(final String id, final Class<T> type){
        final Mono<T> mono = WebClient
                .create()
                .get()
                .uri("http://person:8080/person/api/" + id)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(type);
        return mono.block();
    }
    private static <T> T getEvents(final Class<T> type){
        final Mono<T> mono = WebClient
                .create()
                .post()
                .uri("http://person:8080/person/api/events")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(type);
        return mono.block();
    }


    @Override
    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(e -> personList.add(e));
        return personList;
    }

    @Override
    public void AddDeleteId(Long id) {
        Event event =  eventRepository.findById(id).get();
        event.setDeleted(true);
        event.setProjektId(id);
        eventRepository.save(event);
    }

    @Override
    public void AddNewId(Long id) {
        Event event = new Event();
        event.setProjektId(id);
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
    public void getAllPersonEvent() {
        Person person;
        System.out.println(11111111);
        PersonEvent[]  personEventList = getEvents(PersonEvent[].class);
        System.out.println(personEventList[0]);
        for(int i = 0;i < personEventList.length;i++){
            if(personEventList[i].getEvent().equals("delete")){
                personRepository.deleteById(personEventList[i].getPersonId());
            }else{
                System.out.println(personEventList[i]);
                person = getEntity(personEventList[i].getPersonId().toString(), Person.class);
                personRepository.save(person);
            }
        }
    }



    @Override
    public List<Event> findAllEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(e -> events.add(e));
        eventRepository.deleteAll();
        return events;
    }
}
