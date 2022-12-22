package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Module  {

    private Long idModule;

    private boolean isRootModule;

    private String moduleName;

    private float weight;

    private static float sumSubWeights;

    private int semester;

    private List<Module> subModuleList;

}
