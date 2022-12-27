package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public abstract class Evaluation implements IEvaluation{

    private int idEvaluation;

    private float mark;

    private Date date;

}
