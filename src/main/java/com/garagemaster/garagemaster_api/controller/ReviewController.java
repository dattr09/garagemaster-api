package com.garagemaster.garagemaster_api.controller;

import com.garagemaster.garagemaster_api.model.Review;
import com.garagemaster.garagemaster_api.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAll() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Review> getByUserId(@PathVariable String userId) {
        Review review = reviewService.getByUserId(userId);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Review> createOrUpdate(@RequestBody Review review) {
        if (review.getUserId() == null || review.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(reviewService.createOrUpdate(review));
    }
}
