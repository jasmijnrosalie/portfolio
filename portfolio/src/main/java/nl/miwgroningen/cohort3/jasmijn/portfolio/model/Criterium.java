package nl.miwgroningen.cohort3.jasmijn.portfolio.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany( cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "criterium")
    private List<Review> reviews;

    public Integer getCriteriumId() {
        return criteriumId;
    }

    public void setCriteriumId(Integer criteriumId) {
        this.criteriumId = criteriumId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
