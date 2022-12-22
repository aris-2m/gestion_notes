package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
public class Student extends Person implements Serializable {
	
	private String fieldName; //Nom de la filière
}
