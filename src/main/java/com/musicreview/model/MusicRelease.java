package com.musicreview.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Gagauz Sergey
 *         Created by user on 05.11.2017.
 */

@Entity
@Repository
public class MusicRelease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "release_title")
    private String release_title;

    @Column (name = "record_label")
    private int record_label;

    @Column (name = "release_date")
    private Date release_date;

    @OneToMany(mappedBy = "musicRelease", cascade = CascadeType.ALL)
    private Set<Review> relese_review;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "musicReleaseSet")
    private Set <Artist> artists;

    public MusicRelease(String release_title, int record_label, Date release_date) {
        this.release_title = release_title;
        this.record_label = record_label;
        this.release_date = release_date;
    }

    public MusicRelease(String release_title, int record_label, Date release_date, Set<Review> relese_review) {
        this.release_title = release_title;
        this.record_label = record_label;
        this.release_date = release_date;
        this.relese_review = relese_review;
    }

    public MusicRelease() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_title() {
        return release_title;
    }

    public void setRelease_title(String release_title) {
        this.release_title = release_title;
    }

    public int getRecord_label() {
        return record_label;
    }

    public void setRecord_label(int record_label) {
        this.record_label = record_label;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Set<Review> getRelese_review() {
        return relese_review;
    }

    public void setRelese_review(Set<Review> relese_review) {
        this.relese_review = relese_review;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "MusicRelease{" +
                "id=" + id +
                ", release_title='" + release_title + '\'' +
                ", record_label=" + record_label +
                ", release_date=" + release_date +
                ", relese_review=" + relese_review +
                '}';
    }
}
