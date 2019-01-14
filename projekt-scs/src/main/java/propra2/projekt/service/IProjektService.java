package propra2.projekt.service;

import propra2.projekt.datebank.model.Projekt;

import java.util.List;

public interface IProjektService {
    List<Projekt> getAllProjects();
    Projekt getProjectbyId(Long Id);
    void addAndupdateProject(Projekt projekt);
    void deleteProjekt(Long Id);
}
