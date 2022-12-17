package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity @Inheritance(strategy= InheritanceType.JOINED)
public abstract class Evaluation implements IEvaluation{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEvaluation;
}
