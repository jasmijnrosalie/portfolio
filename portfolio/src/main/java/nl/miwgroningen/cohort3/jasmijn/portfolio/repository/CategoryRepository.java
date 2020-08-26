package nl.miwgroningen.cohort3.jasmijn.portfolio.repository;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
