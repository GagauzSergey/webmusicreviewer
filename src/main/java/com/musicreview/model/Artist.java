
package com.musicreview.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Gagauz Segey
 *         Created by user on 03.11.2017.
 */

@Entity
@Repository
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "artist_firstname")
    private String artist_firstname;

    @Column(name = "artist_secondname")
    private String artist_secondname;

    @Column(name = "artist_nickname")
    private String artist_nickname;


    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "artist_recordlabel", joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<RecordLabel> recordLabels;


    public Artist(String artist_firstname, String artist_secondname, String artist_nickname) {
        this.artist_firstname = artist_firstname;
        this.artist_secondname = artist_secondname;
        this.artist_nickname = artist_nickname;
    }

    public Artist(String artist_nickname) {
        this.artist_nickname = artist_nickname;
    }

    public Artist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist_firstname() {
        return artist_firstname;
    }

    public void setArtist_firstname(String artist_firstname) {
        this.artist_firstname = artist_firstname;
    }

    public String getArtist_secondname() {
        return artist_secondname;
    }

    public void setArtist_secondname(String artist_secondname) {
        this.artist_secondname = artist_secondname;
    }

    public String getArtist_nickname() {
        return artist_nickname;
    }

    public void setArtist_nickname(String artist_nickname) {
        this.artist_nickname = artist_nickname;
    }

    public Set<RecordLabel> getRecordLabels() {
        return recordLabels;
    }

    public void setRecordLabels(Set<RecordLabel> recordLabels) {
        this.recordLabels = recordLabels;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artist_firstname='" + artist_firstname + '\'' +
                ", artist_secondname='" + artist_secondname + '\'' +
                ", artist_nickname='" + artist_nickname + '\'' +
                ", recordLabels=" + recordLabels +
                '}';
    }
}

