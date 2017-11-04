package com.musicreview.service;

import com.musicreview.dao.ArtistRepository;
import com.musicreview.dao.RecordLabelRepository;
import com.musicreview.model.Artist;
import com.musicreview.model.RecordLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 04.11.2017.
 */

@Service
public class RecordLabelServiceImpl implements RecordLabelService{

    @Autowired
    private RecordLabelRepository recordLabelRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public RecordLabel getRecordLabelByName(String label_name) {
        return null;
    }

    @Override
    public boolean existsRecordLabelByName(String label_name) {
        return false;
    }

    @Override
    @Transactional
    public void addRecordLabel(RecordLabel recordLabel) {
        Set<Artist> artistSet = new HashSet<>();
        artistSet.add(artistRepository.getOne(1L));
        recordLabel.setArtistsList(artistSet);
        recordLabelRepository.save(recordLabel);
    }

    @Override
    public void updateArtist(RecordLabel recordLabel) {

    }

    @Override
    public void deleteArtist(Long id) {

    }

    @Override
    public List<RecordLabel> recordLabelList() {
        return null;
    }
}
