package propra2.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propra2.projekt.datebank.model.Projekt;
import propra2.projekt.datebank.repository.ProjektRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjektService implements IProjektService {
    @Autowired
    private ProjektRepository projektRepository;


    @Override
    public List<Projekt> getAllProjects() {
        List<Projekt> projects = new ArrayList<>();
        projektRepository.findAll().forEach(e -> projects.add(e));
        return projects;
    }

    @Override
    public Projekt getProjectbyId(Long Id) {
        Projekt projekt = projektRepository.findById(Id).get();
        return projekt;
    }


    @Override
    public void addAndupdateProject(Projekt projekt) {
        projektRepository.save(projekt);
    }

    @Override
    public void deleteProjekt(Long Id) {
        projektRepository.delete(getProjectbyId(Id));
    }
}
