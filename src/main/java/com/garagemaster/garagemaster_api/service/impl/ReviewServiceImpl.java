package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Review;
import com.garagemaster.garagemaster_api.repository.ReviewRepository;
import com.garagemaster.garagemaster_api.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getByUserId(String userId) {
        return reviewRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public Review createOrUpdate(Review review) {
        Review existing = getByUserId(review.getUserId());
        review.setCreatedAt(LocalDateTime.now());
        if (existing != null) {
            review.setId(existing.getId());
        }
        return reviewRepository.save(review);
    }
}
