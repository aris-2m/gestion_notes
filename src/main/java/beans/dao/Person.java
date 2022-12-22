package beans.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person implements Serializable {

    private Long idPerson;

    private String name;

    private String surname;

}


