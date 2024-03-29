package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class FieldOfStudy implements Serializable {

    private int idFieldOfStudy;

    private String name;

}
