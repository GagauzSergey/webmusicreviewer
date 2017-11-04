package com.musicreview.service;

import com.musicreview.dao.ArtistRepository;
import com.musicreview.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gagauz Sergey
 * Created by user on 03.11.2017.
 */

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

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
}
