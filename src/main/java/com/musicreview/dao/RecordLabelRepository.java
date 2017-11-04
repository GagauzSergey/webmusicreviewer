package com.musicreview.dao;

import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Gagauz Sergey
 * Created by user on 04.11.2017.
 */
public interface RecordLabelRepository extends JpaRepository <RecordLabel, Long>{

    @Query("SELECT u FROM RecordLabel u where u.label_name = :label_name")
    Artist findByRecordLabelName(@Param("label_name") String label_name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM RecordLabel u WHERE u.label_name = :label_name")
    boolean existsByRecordLabelName(@Param("label_name") String label_name);
}
