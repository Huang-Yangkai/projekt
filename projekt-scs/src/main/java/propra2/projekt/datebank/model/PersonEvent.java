package propra2.projekt.datebank.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PersonEvent {
    @Id
    private Long id;

    private Long personId;

    private String event;

}
