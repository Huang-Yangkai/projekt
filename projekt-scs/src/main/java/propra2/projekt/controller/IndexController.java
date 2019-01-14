package propra2.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import propra2.projekt.datebank.model.Projekt;
import propra2.projekt.service.IProjektService;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IProjektService projektService;


    @GetMapping("/")
    public String index(Model model){
       List<Projekt> projects = projektService.getAllProjects();
       model.addAttribute("projects", projects);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String UpdateProject(@PathVariable Long id, Model model){
        Projekt project = projektService.getProjectbyId(id);
        model.addAttribute("project", project);
        return "edit";
    }

    @PutMapping("/edit/{id}")
    public String updateProjekt(Projekt project){
        projektService.addAndupdateProject(project);
        return "change_success" ;
    }

    @PostMapping("/edit/{id}")
    public String deleteProjekt(Projekt project){
        projektService.deleteProjekt(project.getId());
        return "change_success";
    }

    @GetMapping("/newproject")
    public String addProject(){
        return "NewProject";
    }

    @PostMapping("/newproject")
    public String addProjekt(Projekt project){
        projektService.addAndupdateProject(project);
        return "change_success";
    }

}
