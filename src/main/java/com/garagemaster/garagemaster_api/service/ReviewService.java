package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Review;
import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getByUserId(String userId);
    Review createOrUpdate(Review review);
}
