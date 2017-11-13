package com.musicreview.service;

import com.musicreview.model.Artist;
import com.musicreview.model.MusicRelease;
import com.musicreview.model.RecordLabel;
import com.musicreview.model.Review;

import java.util.List;

/**
 * @author Gagauz Sergey
 *         Created by user on 13.11.2017.
 */
public interface ReviewService {
    Review getReviewByName(String review_name);

    boolean existsByReviewName(String review_name);

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Long id);

    List<Review> reviewList();

    List<MusicRelease> musicReleaseLinkedToReview(MusicRelease musicRelease);

    MusicRelease findMusicRelease(long id);
}

