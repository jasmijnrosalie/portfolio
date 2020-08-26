package nl.miwgroningen.cohort3.jasmijn.portfolio.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Criterium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer criteriumId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    private int points;

    private String description;


}
