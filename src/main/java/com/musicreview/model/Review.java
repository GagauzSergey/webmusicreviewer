package com.musicreview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Gagauz Sergey
 * Created by user on 05.11.2017.
 */

@Entity
@Repository
@Data
@NoArgsConstructor (force = true)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "review_name")
    private String review_name;

    @Column(name = "review_text")
    private String review_text;

    @Column(name = "review_rate")
    private int review_rate;

    @Column(name = "review_time")
    private Date review_time;

    @ManyToOne
    @JoinColumn(name = "musicrelease_id")
    private MusicRelease musicRelease;

    public Review(String review_name, String review_text, int review_rate, Date review_time, MusicRelease musicRelease) {
        this.review_name = review_name;
        this.review_text = review_text;
        this.review_rate = review_rate;
        this.review_time = review_time;
        this.musicRelease = musicRelease;
    }

}
