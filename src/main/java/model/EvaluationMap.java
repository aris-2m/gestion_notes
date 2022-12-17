package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EvaluationMap {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEvaluationMap;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evaluation evaluation;

    @ManyToOne(fetch = FetchType.EAGER)
    private Module module;

    private float evalWeight;
}
