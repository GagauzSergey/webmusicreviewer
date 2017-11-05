package com.musicreview.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Gagauz Sergey
 * Created by user on 05.11.2017.
 */

@Entity
@Repository
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

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getReview_rate() {
        return review_rate;
    }

    public void setReview_rate(int review_rate) {
        this.review_rate = review_rate;
    }

    public Date getReview_time() {
        return review_time;
    }

    public void setReview_time(Date review_time) {
        this.review_time = review_time;
    }

    public MusicRelease getMusicRelease() {
        return musicRelease;
    }

    public void setMusicRelease(MusicRelease musicRelease) {
        this.musicRelease = musicRelease;
    }
}
