package com.musicreview.service.impl;

import com.musicreview.dao.MusicReleaseRepository;
import com.musicreview.dao.RecordLabelRepository;
import com.musicreview.model.MusicRelease;
import com.musicreview.model.RecordLabel;
import com.musicreview.service.MusicReleaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gagauz Sergey
 *         Created by user on 11.11.2017.
 */
@Service
@Slf4j
public class MusicReleaseServiceImpl implements MusicReleaseService {

    private MusicReleaseRepository musicReleaseRepository;

    private RecordLabelRepository recordLabelRepository;

    @Autowired
    public MusicReleaseServiceImpl(MusicReleaseRepository musicReleaseRepository, RecordLabelRepository recordLabelRepository) {
        this.musicReleaseRepository = musicReleaseRepository;
        this.recordLabelRepository = recordLabelRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public MusicRelease getMusicReleaseByTitle(String release_title) {
        return musicReleaseRepository.findMusicReleaseByTitle(release_title);
    }

    @Override
    @Transactional
    public boolean existsMusicReleaseByTitle(String release_title) {
        return musicReleaseRepository.existsByMusicReleaseTitle(release_title);
    }

    @Override
    @Transactional
    public void addMusicRelease(MusicRelease musicRelease) {
        Set<RecordLabel> recordLabels = new HashSet<>();
        recordLabels.add(recordLabelRepository.getOne(1L));
//        musicRelease.setRecord_label(recordLabels.);
        musicReleaseRepository.save(musicRelease);
    }

    @Override
    public void updateMusicRelease(MusicRelease musicRelease) {
        musicReleaseRepository.save(musicRelease);
    }

    @Override
    public void deleteMusicRelease(Long id) {
        musicReleaseRepository.delete(id);
    }

    @Override
    public List<MusicRelease> musicReleaseList() {
        return musicReleaseRepository.findAll();
    }
}
