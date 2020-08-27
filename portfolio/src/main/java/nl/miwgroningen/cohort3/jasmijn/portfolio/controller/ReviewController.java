package nl.miwgroningen.cohort3.jasmijn.portfolio.controller;

import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Category;
import nl.miwgroningen.cohort3.jasmijn.portfolio.model.Review;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.CriteriumRepository;
import nl.miwgroningen.cohort3.jasmijn.portfolio.repository.ReviewRepository;
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
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CriteriumRepository criteriumRepository;

    @GetMapping("/reviews")
    protected String showReviews(Model model){
        model.addAttribute("allReviews", reviewRepository.findAll());
        return "reviewOverview";
    }

    @GetMapping("/reviews/add")
    protected String showReviewForm(Model model){
        model.addAttribute("review", new Review());
        model.addAttribute("criteriumList", criteriumRepository.findAll());
        return "reviewForm";
    }

    @GetMapping("/review/{reviewId}")
    protected String showReview(@PathVariable("reviewId") final Integer reviewId, Model model) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()) {
            model.addAttribute("review", review.get());
            return "reviewDetail";
        }
        return "redirect:/reviews";
    }

    @PostMapping("/reviews/add")
    protected String saveOrUpdateReview(@ModelAttribute("review") Review review, BindingResult result){
        if(result.hasErrors()) {
            return "reviewForm";
        } else {
            reviewRepository.save(review);
            return "redirect:/reviews";
        }
    }
}
