package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evaluation_CC extends Evaluation {

    @Override
    public void evaluate() {

    }
}
