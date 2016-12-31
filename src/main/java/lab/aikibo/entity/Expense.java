package lab.aikibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lab.aikibo.constant.Status;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tamami on 31/12/16.
 */
@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private User user;
    private String merchant;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String comment;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private Status status;

}
