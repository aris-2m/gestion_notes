package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public abstract class Evaluation implements IEvaluation{

    private Long idEvaluation;
}
