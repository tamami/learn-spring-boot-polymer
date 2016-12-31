package lab.aikibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lab.aikibo.constant.Role;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by tamami on 29/12/16.
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String username;

    @JsonIgnore
    private String password = "";

    @Enumerated(EnumType.STRING)
    private Role role;

}
