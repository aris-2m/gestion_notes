package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.ITags.IStrategyEval;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idModule;

    private boolean isSubModule;

    private String moduleName;



    private float weight;

    private static float sumSubWeights;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fieldOfStudyId")
    private FieldOfStudy fieldOfStudy;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Semester semester;
//
//    @OneToMany(orphanRemoval = true,
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private List<Module> moduleList;
//
//    @ElementCollection
//    @CollectionTable(name="evaluations")
//    private Map<IStrategyEval, Float> evaluationsMap;
}
