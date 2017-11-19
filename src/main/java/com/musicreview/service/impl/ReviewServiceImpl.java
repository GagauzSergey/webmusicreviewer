package com.musicreview.service.impl;

import com.musicreview.dao.MusicReleaseRepository;
import com.musicreview.dao.ReviewRepository;
import com.musicreview.model.MusicRelease;
import com.musicreview.model.Review;
import com.musicreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 13.11.2017.
 */

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MusicReleaseRepository musicReleaseRepository;

    @Override
    public Review getReviewByName(String review_name) {
        return reviewRepository.findReviewByName(review_name);
    }

    @Override
    public boolean existsByReviewName(String review_name) {
        return reviewRepository.existsByReviewName(review_name);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(id);
    }

    @Override
    public List<Review> reviewList() {
        return reviewRepository.findAll();
    }

    @Override
    public List<MusicRelease> musicReleaseLinkedToReview(MusicRelease musicRelease) {
        return musicReleaseRepository.findAll();
    }

    @Override
    public MusicRelease findMusicRelease(long id) {
        return musicReleaseRepository.findOne(1L);
    }
}
