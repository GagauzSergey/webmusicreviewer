package com.musicreview.dao;

import com.musicreview.model.MusicRelease;
import com.musicreview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Gagauz Sergey
 * Created by user on 11.11.2017.
 */
public interface ReviewRepository extends JpaRepository <Review, Long> {

    @Query("SELECT u FROM Review u where u.review_name = :review_name")
    Review findReviewByName(@Param("review_name") String review_name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Review u WHERE u.review_name = :review_name")
    boolean existsByReviewName(@Param("review_name") String review_name);

}
