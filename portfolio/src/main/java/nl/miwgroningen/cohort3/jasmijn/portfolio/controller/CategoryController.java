package nl.miwgroningen.cohort3.jasmijn.portfolio.controller;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Category;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    protected String showCategories(Model model){
        model.addAttribute("allCategories", categoryRepository.findAll());
        model.addAttribute("category", new Category());
        return "categoryOverview";
    }

    @GetMapping("/categories/add")
    protected String showCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/categories/add")
    protected String saveOrUpdateCategory(@ModelAttribute("category") Category category, BindingResult result){
        if (result.hasErrors()){
            return "categoryForm";
        } else {
            categoryRepository.save(category);
            return "redirect:/categories";
        }
    }

    @GetMapping("/category/{categoryId}")
    protected String showCategory(@PathVariable("categoryId") final Integer categoryId, Model model) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoryDetail";
        }
        return "redirect:/categories";
    }

}
