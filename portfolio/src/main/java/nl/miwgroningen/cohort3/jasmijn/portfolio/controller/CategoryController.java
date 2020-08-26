package nl.miwgroningen.cohort3.jasmijn.portfolio.controller;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Category;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category")
    protected String showCategories(Model model){
        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("category", new Category());
        return "categoryOverview";
    }
}
