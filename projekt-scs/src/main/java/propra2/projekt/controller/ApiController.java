package propra2.projekt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import propra2.projekt.datebank.model.Event;
import propra2.projekt.datebank.model.Projekt;
import propra2.projekt.service.IEventService;
import propra2.projekt.service.IProjektService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    IProjektService projektService;
    @Autowired
    IEventService eventService;

    @GetMapping("/")
    public List<Projekt> findAllProjekt(){
        return projektService.getAllProjects();
    }

    @GetMapping("/events")
    public List<Event> events(){
        return eventService.findAllEvents();
    }

    @GetMapping("/{id}")
    public Projekt findProjektById(@PathVariable Long id){
        return projektService.getProjectbyId(id);
    }

    @GetMapping("/{id}/startTime")
    public Date findProjektstartTime(@PathVariable Long id){
        return projektService.getProjectbyId(id).getStartTime();
    }

    @GetMapping("/{id}/beschreibung")
    public String findProjektBeschreibung(@PathVariable Long id){
        return projektService.getProjectbyId(id).getBeschreibung();
    }

    @GetMapping("/{id}/last")
    public Integer findProjektLast(@PathVariable Long id){
        return projektService.getProjectbyId(id).getLast();
    }

    @GetMapping("/{id}/people")
    public Integer[] findProjektPerdon(@PathVariable Long id){
        return projektService.getProjectbyId(id).getPersonId();
    }



}
