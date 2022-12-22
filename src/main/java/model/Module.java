package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Module  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idModule;

    private boolean isRootModule;

    private String moduleName;

    private float weight;

    private static float sumSubWeights;

    private int semester;

    private List<Module> subModuleList;

}
