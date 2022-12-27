package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Module {

    private int idModule;

    private int fkFieldOfStudy;

    private int fkProf;

    private String moduleName;

    private float moduleWeight;

    private int semester;

    private static float sumSubWeights;



}
