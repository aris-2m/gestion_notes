package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.ITags.IFieldOfStudy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FieldOfStudy implements IFieldOfStudy, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFieldOfStudy;

    private String name;

}
