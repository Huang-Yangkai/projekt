package propra2.projekt.datebank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {

    @Id
    private Long id;

    private String vorname;

    private String nachname;

    private String rolle;

    private String[] skills;

}
