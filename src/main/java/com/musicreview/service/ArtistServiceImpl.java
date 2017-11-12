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
 * @author Gagauz Sergey
 * Created by user on 03.11.2017.
 */

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private RecordLabelRepository recordLabelRepository;

    @Override
    @Transactional(readOnly = true)
    public Artist getArtistByNickname(String nickname) {
        return artistRepository.findByNickname(nickname);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNickname(String nickname) {
        return artistRepository.existsByNickname(nickname);
    }

    @Override
    @Transactional
    public void addArtist(Artist artist) {
        Set <RecordLabel> recordLabels = new HashSet<>();
        recordLabels.add(recordLabelRepository.getOne(1L));
        artist.setRecordLabels(recordLabels);
        artistRepository.save(artist);
    }

    @Override
    @Transactional
    public void updateArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    @Transactional
    public void deleteArtist(Long id) {
 //       artistRepository.delete(getArtistByNickname(nickname));
        artistRepository.delete(id);
    }

    @Override
    @Transactional
    public List <Artist> artistList() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional
    public List <RecordLabel> recordLabelsListForArtist(RecordLabel recordLabel) {return recordLabelRepository.findAll();}

    @Override
    public RecordLabel findRecordLabel(long id) {
        return recordLabelRepository.getOne(id);
    }
}
