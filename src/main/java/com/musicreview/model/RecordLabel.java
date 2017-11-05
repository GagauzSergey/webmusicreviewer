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
public class RecordLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "label_name")
    private String label_name;

    @Column (name = "label_country")
    private String label_country;

    @ManyToMany (fetch = FetchType.LAZY, mappedBy = "recordLabels")
    private Set <Artist> artistsList;

    public RecordLabel(String label_name, String label_country) {
        this.label_name = label_name;
        this.label_country=label_country;
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

    public String getLabel_country() {
        return label_country;
    }

    public void setLabel_country(String label_country) {
        this.label_country = label_country;
    }

    public Set<Artist> getArtistsList() {
        return artistsList;
    }

    @Override
    public String toString() {
        return "RecordLabel{" +
                "id=" + id +
                ", label_name='" + label_name + '\'' +
                ", label_country='" + label_country + '\'' +
                ", artistsList=" + artistsList +
                '}';
    }

    public void setArtistsList(Set<Artist> artistsList) {
        this.artistsList = artistsList;
    }
}


