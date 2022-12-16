package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.ITags.IPerson;

import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Inheritance(strategy=InheritanceType.JOINED)
public abstract class Person implements IPerson, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPerson;

    private String name;

    private String surname;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Account account;
}


