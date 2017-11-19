package com.musicreview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor (force = true)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "artist_musicrelease", joinColumns = @JoinColumn (name = "musicrelease_id"),
    inverseJoinColumns = @JoinColumn (name = "artist_id"))
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

}
