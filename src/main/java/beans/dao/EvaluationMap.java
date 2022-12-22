package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class EvaluationMap {

    private Long idEvaluationMap;

    private Evaluation evaluation;

    private Module fkModule;

    private float evalWeight;
}
