package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fieldOfStudyId")
    private FieldOfStudy fieldOfStudy;

}
