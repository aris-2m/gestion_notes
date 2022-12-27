package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class EvaluationMap {

    private int idEvaluationMap;

    private int fkEvaluation;

    private int fkStudent;

    private int fkModule;

    private float evalWeight;
}
