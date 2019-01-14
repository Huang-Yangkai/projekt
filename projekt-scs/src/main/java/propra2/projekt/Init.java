package propra2.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;
import propra2.projekt.datebank.model.Projekt;
import propra2.projekt.datebank.repository.ProjektRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.sql.Date;
import java.time.LocalDate;

@Component
public class Init implements ServletContextInitializer {

    @Autowired
    ProjektRepository projektRepository;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        Projekt projekt1 = new Projekt();
//        projekt1.setBudget(100);
//        projekt1.setLast(3);
//        projekt1.setName("Projekt KDN");
//        projekt1.setStartTime(Date.valueOf(LocalDate.now()));
//        projekt1.setPersonId(new Integer[]{1,2,3});
//        projektRepository.save(projekt1);
    }
}
