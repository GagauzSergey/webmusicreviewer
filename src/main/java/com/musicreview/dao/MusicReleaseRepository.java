package com.musicreview.dao;

import com.musicreview.model.MusicRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Gagauz Sergey
 * Created by user on 11.11.2017.
 */
public interface MusicReleaseRepository extends JpaRepository <MusicRelease, Long> {

    @Query("SELECT u FROM MusicRelease u where u.release_title = :release_title")
    MusicRelease findMusicReleaseByTitle(@Param("release_title") String release_title);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM MusicRelease u WHERE u.release_title = :release_title")
    boolean existsByMusicReleaseTitle(@Param("release_title") String release_title);

}
