package com.digitalaicloud.hibernate.services.impl;

import com.digitalaicloud.hibernate.entity.Review;
import com.digitalaicloud.hibernate.repository.ReviewRepository;
import com.digitalaicloud.hibernate.services.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
