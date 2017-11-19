
package com.musicreview.model;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;


/**
 * @author Gagauz Segey
 *         Created by user on 03.11.2017.
 */

@Entity
@Repository
@Data
@NoArgsConstructor (force = true)
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


    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "artist_recordlabel", joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<RecordLabel> recordLabels;

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "artist_musicrelease", joinColumns = @JoinColumn (name = "artist_id"),
    inverseJoinColumns = @JoinColumn (name = "musicrelease_id"))
    private Set <MusicRelease> musicReleaseSet;

    public Artist(String artist_firstname, String artist_secondname, String artist_nickname) {
        this.artist_firstname = artist_firstname;
        this.artist_secondname = artist_secondname;
        this.artist_nickname = artist_nickname;
    }
}

