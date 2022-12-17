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
@Entity
// @Inheritance(strategy=InheritanceType.JOINED)
public class Module  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idModule;

    private boolean isRootModule;

    private String moduleName;

    private float weight;

    private static float sumSubWeights;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fieldOfStudyId")
    private FieldOfStudy fieldOfStudy;

    // @ManyToOne(fetch = FetchType.EAGER)
    // private Semester semester;
    private int semester;

    @OneToMany(orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Module> subModuleList;


}
