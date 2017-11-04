package com.musicreview.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Gagauz Segey
 * Created by user on 03.11.2017.
 */


@Entity
@Repository
public class RecordLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String label_name;

    private String artist_country;

/*    @ManyToMany (mappedBy = "record_label")
    private Set <Artist> artists = new HashSet<>();*/

    public RecordLabel(String label_name, String artist_country) {
        this.label_name = label_name;
        this.artist_country = artist_country;
    }

    public RecordLabel(String label_name) {
        this.label_name = label_name;
    }

    public RecordLabel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getArtist_country() {
        return artist_country;
    }

    public void setArtist_country(String artist_country) {
        this.artist_country = artist_country;
    }

/*    @Override
    public String toString() {
        return "RecordLabel{" +
                "id=" + id +
                ", label_name='" + label_name + '\'' +
                ", artist_country='" + artist_country + '\'' +
                ", artists=" + artists +
                '}';
    }*/
}


