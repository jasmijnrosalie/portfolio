package nl.miwgroningen.cohort3.jasmijn.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewId;

    private String gitCommit;

    private String description;

    private String priority;
    //moet misschien enum worden
}
