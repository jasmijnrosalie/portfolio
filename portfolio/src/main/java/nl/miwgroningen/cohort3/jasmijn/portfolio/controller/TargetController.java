package nl.miwgroningen.cohort3.jasmijn.portfolio.controller;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Target;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CriteriumRepository;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TargetController {

    @Autowired
    TargetRepository targetRepository;

    @Autowired
    CriteriumRepository criteriumRepository;

    @GetMapping("/targets")
    protected String showTargets(Model model){
        model.addAttribute("allTargets", targetRepository.findAll());
        return "targetOverview";
    }

    @GetMapping("/targets/add")
    protected String showTargetForm(Model model){
        model.addAttribute("target", new Target());
        model.addAttribute("criteriumList", criteriumRepository.findAll());
        return "targetForm";
    }

    @PostMapping("/targets/add")
    protected String saveOrUpdateTarget(@ModelAttribute("target") Target target, BindingResult result){
        if (result.hasErrors()) {
            System.out.println(result);
            return "targetForm";
        } else {
            targetRepository.save(target);
            return "redirect:/targets";
        }
    }

}
