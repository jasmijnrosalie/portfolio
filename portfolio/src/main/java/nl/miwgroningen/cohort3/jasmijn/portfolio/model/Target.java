package nl.miwgroningen.cohort3.jasmijn.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer targetId;

    private Date targetDate;

    private String description;
}
