package com.musicreview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor (force = true)
public class RecordLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "label_name")
    private String label_name;

    @Column(name = "label_country")
    private String label_country;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "artist_recordlabel", joinColumns = @JoinColumn (name = "label_id"),
    inverseJoinColumns = @JoinColumn (name = "artist_id"))
    private Set<Artist> artistsList;

    public RecordLabel(String label_name, String label_country) {
        this.label_name = label_name;
        this.label_country = label_country;
    }

    public RecordLabel(String label_name) {
        this.label_name = label_name;
    }

}


