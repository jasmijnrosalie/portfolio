package nl.miwgroningen.cohort3.jasmijn.portfolio.controller;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Category;
import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Criterium;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CategoryRepository;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CriteriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CriteriumController {

    @Autowired
    CriteriumRepository criteriumRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/criteria")
    protected String showCriteria(Model model) {
        model.addAttribute("allCriteria", criteriumRepository.findAll());
        return "criteriaOverview";
    }

    @GetMapping("/criteria/add")
    protected String showCriteriumForm(Model model) {
        model.addAttribute("criterium", new Criterium());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "criteriumForm";
    }

    @PostMapping("/criteria/add")
    protected String saveOrUpdateCategory(@ModelAttribute("criterium") Criterium criterium, BindingResult result){
        if (result.hasErrors()){
            System.out.println(result);
            return "criteriumForm";
        } else {
            criteriumRepository.save(criterium);
            return "redirect:/criteria";
        }
    }
}
