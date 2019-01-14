package propra2.projekt.datebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@JsonIgnoreProperties(value={"buget"})
public class Projekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private Date startTime;

    private String beschreibung;

    @JsonIgnore
    private Integer budget;

    private Integer last;

    private Integer[] personId;

}
