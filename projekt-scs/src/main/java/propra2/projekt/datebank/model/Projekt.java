package propra2.projekt.datebank.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Projekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private Date startTime;

    private String beschreibung;

    private Integer budget;

    private Integer last;

    private Integer[] personId;

}
