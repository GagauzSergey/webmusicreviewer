package com.musicreview.dao;

import com.musicreview.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Gagauz Segey
 * Created by user on 03.11.2017.
 */
public interface ArtistRepository extends JpaRepository <Artist, Long>{

    @Query("SELECT u FROM Artist u where u.artist_nickname = :artist_nickname")
    Artist findByNickname(@Param("artist_nickname") String artist_nickname);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Artist u WHERE u.artist_nickname = :artist_nickname")
    boolean existsByNickname(@Param("artist_nickname") String artist_nickname);
}
