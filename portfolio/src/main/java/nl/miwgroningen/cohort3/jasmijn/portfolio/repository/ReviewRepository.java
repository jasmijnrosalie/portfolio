package nl.miwgroningen.cohort3.jasmijn.portfolio.repository;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
