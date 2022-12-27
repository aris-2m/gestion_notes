package beans.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class Admin extends Person implements Serializable {

    private int fkAccount;

}
